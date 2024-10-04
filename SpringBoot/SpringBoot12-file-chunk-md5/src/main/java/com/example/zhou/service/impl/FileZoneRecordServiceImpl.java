package com.example.zhou.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zhou.common.Result;
import com.example.zhou.common.ResultCode;
import com.example.zhou.config.FileUploadConfig;
import com.example.zhou.entity.Archive;
import com.example.zhou.entity.ArchiveZoneRecord;
import com.example.zhou.entity.enums.CheckType;
import com.example.zhou.mapper.ArchiveMapper;
import com.example.zhou.mapper.ArchiveRecordMapper;
import com.example.zhou.param.FileUploadResultBO;
import com.example.zhou.param.ZoneUploadResultBO;
import com.example.zhou.service.IFileRecordService;
import com.example.zhou.service.IFileZoneRecordService;
import com.example.zhou.utils.FileHandleUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class FileZoneRecordServiceImpl extends ServiceImpl<ArchiveRecordMapper, ArchiveZoneRecord> implements IFileZoneRecordService {

    @Resource
    private ArchiveMapper archiveMapper;

    @Resource
    private FileUploadConfig fileUploadConfig;

    @Resource
    private IFileRecordService fileRecordService;

    @Resource
    private ArchiveRecordMapper archiveRecordMapper;

    @Override
    public ZoneUploadResultBO zoneUpload(HttpServletRequest request, ArchiveZoneRecord archiveZoneRecord,
                                         MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            // 如果文件为空，返回错误信息
            throw new RuntimeException("请选择文件");
        }

        try {
            // 根据UUID生成同步锁，避免多线程竞争，确保线程安全

            // 根据MD5和zoneTotalMd5查询分片记录
            ArchiveZoneRecord zoneRecord =
                    archiveRecordMapper.selectOne(Wrappers.<ArchiveZoneRecord>lambdaQuery()
                            .eq(ArchiveZoneRecord::getZoneMd5, archiveZoneRecord.getZoneMd5())
                            .eq(ArchiveZoneRecord::getZoneTotalMd5, archiveZoneRecord.getZoneTotalMd5())
                            .last("limit 1"));

            // 如果分片记录存在，返回已存在的分片记录信息
            if (zoneRecord != null) {
                ZoneUploadResultBO resultBo = new ZoneUploadResultBO(zoneRecord, true,
                        zoneRecord.getZoneNowIndex());
                return resultBo;
            }

            Archive archive = null;
            // 根据MD5和上传类型查询文件记录
            archive = archiveMapper.selectOne(Wrappers.<Archive>lambdaQuery()
                    .eq(Archive::getMd5Value, archiveZoneRecord.getZoneTotalMd5())
                    .last("limit 1"));
            // (文件秒传)如果文件记录已存在且已经上传完毕，则返回文件已上传的错误信息
            if (archive != null && archive.isZoneFlag() && archive.isMergeFlag()) {
                throw new RuntimeException("文件已经上传");
            }

            // 获取文件md5
            String filemd5 = archiveZoneRecord.getZoneMd5();
            // 如果分片记录的md5为空，则生成md5
            if (StringUtils.isBlank(filemd5)) {
                filemd5 = DigestUtils.md5DigestAsHex(multipartFile.getInputStream());
                archiveZoneRecord.setZoneMd5(filemd5);
            }

            // 获取文件后缀
            String fileSuffix = "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());

            // 获取保存路径
            String saveFilePath = "";
            String fileRecordId = "";

            // 如果数据库中不存在对应的文件记录，则创建新记录
            if (archive == null) {
                // 保存分片的路径
                saveFilePath = Paths.get(fileUploadConfig.getUploadFolder(), "chunks",
                        archiveZoneRecord.getZoneTotalMd5()).toString();
                // 保存文件记录
                fileRecordId = saveFileRecord(request, archiveZoneRecord, multipartFile.getOriginalFilename(),
                        saveFilePath);
            } else {
                // 如果文件记录已存在，则获取文件记录id
                fileRecordId = archive.getSid();
                saveFilePath = archive.getPath();
            }

            // 生成临时文件文件名
            String serverFileName = filemd5 + fileSuffix + ".chunks";
            // 上传文件
            FileHandleUtil.upload(multipartFile.getInputStream(), saveFilePath, serverFileName);
            // 保存分片记录
            saveFileZoneRecord(archiveZoneRecord, filemd5, fileRecordId, serverFileName, saveFilePath, fileSuffix);

            // 返回结果信息
            ZoneUploadResultBO resultBo = new ZoneUploadResultBO(archiveZoneRecord, false,
                    archiveZoneRecord.getZoneNowIndex());
            return resultBo;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件上传错误，错误消息：" + e.getMessage());
            throw new RuntimeException("文件上传错误，错误消息：" + e.getMessage());
        }
    }

    /**
     * 保存分片记录
     *
     * @param archiveZoneRecord
     * @param fileMd5
     * @param fileRecordId
     * @param serverFileName
     * @param localPath
     * @param fileSuffix
     */
    private void saveFileZoneRecord(ArchiveZoneRecord archiveZoneRecord, String fileMd5, String fileRecordId,
                                    String serverFileName, String localPath, String fileSuffix) {
        archiveZoneRecord.setSid(UUID.randomUUID() + "");
        archiveZoneRecord.setZoneMd5(fileMd5);
        archiveZoneRecord.setArchiveSid(fileRecordId);
        archiveZoneRecord.setName(serverFileName);
        archiveZoneRecord.setZonePath(localPath);
        archiveZoneRecord.setZoneCheckDate(new Date());
        archiveZoneRecord.setZoneSuffix(fileSuffix);
        super.saveOrUpdate(archiveZoneRecord);
    }

    private String saveFileRecord(HttpServletRequest request, ArchiveZoneRecord ArchiveZoneRecord,
                                  String originalFilename, String localPath) {
        Archive archive = new Archive();
        archive.setSize(ArchiveZoneRecord.getZoneTotalSize());
        archive.setFileType(FilenameUtils.getExtension(originalFilename));
        archive.setMd5Value(ArchiveZoneRecord.getZoneTotalMd5());
        archive.setOriginalName(originalFilename);
        archive.setPath(localPath);
        archive.setZoneFlag(true);
        archive.setMergeFlag(false);
        archive.setZoneTotal(ArchiveZoneRecord.getZoneTotalCount());
        archive.setZoneDate(LocalDateTime.now());
        fileRecordService.saveOrUpdate(archive);
        return archive.getSid();
    }

    @Override
    public Result md5Check(ArchiveZoneRecord archiveZoneRecord, CheckType checkType, HttpServletRequest request) {
        if (checkType == CheckType.FILE_EXISTS) {
            Archive archive = archiveMapper.selectOne(Wrappers.<Archive>lambdaQuery()
                    .eq(Archive::getMd5Value, archiveZoneRecord.getZoneTotalMd5())
                    .last("limit 1"));
            return archive != null && archive.isMergeFlag() ?
                    new Result(ResultCode.FILEUPLOADED, archive) :
                    new Result(ResultCode.SERVER_ERROR, "请选择文件上传");
        } else {
            ArchiveZoneRecord ArchiveZoneRecordDB =
                    archiveRecordMapper.selectOne(Wrappers.<ArchiveZoneRecord>lambdaQuery()
                            .eq(ArchiveZoneRecord::getZoneMd5, archiveZoneRecord.getZoneMd5())
                            .eq(ArchiveZoneRecord::getZoneTotalMd5, archiveZoneRecord.getZoneTotalMd5())
                            .last("limit 1"));
            return ArchiveZoneRecordDB != null ?
                    new Result(ResultCode.SUCCESS, ArchiveZoneRecordDB) :
                    new Result(ResultCode.SERVER_ERROR, "分片文件不存在，继续上传");
        }
    }


    /**
     * 合并分片文件并保存到服务器
     *
     * @param totalMd5 分片文件的总MD5值
     * @param request  HttpServletRequest对象
     * @return 返回合并结果
     */
    @Override
    public FileUploadResultBO mergeZoneFile(String totalMd5, HttpServletRequest request) {
        FileUploadResultBO resultBO = new FileUploadResultBO();
        if (totalMd5 == null || totalMd5.trim().length() == 0) {
            throw new RuntimeException("总MD5值不能为空");
        }

        // 查询总MD5值对应的文件信息
        Archive archive = archiveMapper.selectOne(Wrappers.<Archive>lambdaQuery()
                .eq(Archive::getMd5Value, totalMd5)
                .last("limit 1"));
        if (archive == null) {
            throw new RuntimeException("文件MD5:" + totalMd5 + "对应的文件不存在");
        }


        if (archive.isZoneFlag() && archive.isMergeFlag()) {
            // 如果文件已上传并合并完成，则返回文件信息
            resultBO.setFileId(archive.getSid());
            resultBO.setFileInfo(archive);
            Path netPath = Paths.get(fileUploadConfig.getStaticAccessPath(), archive.getFileType(),
                    archive.getPath());
            resultBO.setNetworkPath(netPath.toString());
            return resultBO;
        }

        String fileType = archive.getFileType();

        // 查询分片记录
        List<ArchiveZoneRecord> archiveZoneRecords = super.list(Wrappers.<ArchiveZoneRecord>lambdaQuery()
                .eq(ArchiveZoneRecord::getZoneTotalMd5, totalMd5)
                .orderByAsc(ArchiveZoneRecord::getZoneNowIndex)
        );

        if (CollectionUtils.isEmpty(archiveZoneRecords)) {
            throw new RuntimeException("文件MD5:" + totalMd5 + "对应的分片记录不存在");
        }

        // 获取当前日期和时间用于生成文件路径
        String pathDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MMdd/HH"));
        // 获取文件上传路径（不包含文件名） 示例：D:/upload/file/2023/03/08/
        String localPath = Paths.get(fileUploadConfig.getUploadFolder(), fileType, pathDate).toString();
        // 生成唯一文件名
        String saveFileName = UUID.randomUUID() + "." + archive.getFileType();

        // 设置文件信息的路径和全路径
        archive.setFullPath(localPath + saveFileName);
        archive.setPath(Paths.get(pathDate, saveFileName).toString());
        archive.setFileName(saveFileName);

        // 合并分片文件并写入文件
        mergeAndWriteFile(localPath, saveFileName, archiveZoneRecords, pathDate, archive);

        // 保存或更新文件信息
        fileRecordService.saveOrUpdate(archive);

        // 获取网络访问路径
        Path netPath = Paths.get(fileUploadConfig.getStaticAccessPath(),
                fileType, pathDate, saveFileName);

        resultBO.setNetworkPath(fileUploadConfig.getDomain() + "/" + netPath.toString());
        resultBO.setFileInfo(archive);
        resultBO.setFileId(archive.getSid());
        return resultBO;
    }

    /**
     * 合并分片文件并写入文件
     *
     * @param localPath          存储文件的本地路径
     * @param saveFileName       保存的文件名
     * @param archiveZoneRecords 分片文件的记录列表
     * @param pathDate           文件路径日期部分
     * @param archive            文件档案对象
     */
    private void mergeAndWriteFile(String localPath, String saveFileName, List<ArchiveZoneRecord> archiveZoneRecords,
                                   String pathDate, Archive archive) {
        String allPath = Paths.get(localPath, saveFileName).toString();
        File targetFile = new File(allPath);

        FileOutputStream fileOutputStream = null;
        try {
            if (!targetFile.exists()) {
                // 创建目录如果不存在
                FileHandleUtil.createDirIfNotExists(localPath);

                // 创建目标临时文件，如果不存在则创建
                targetFile.getParentFile().mkdirs();
                targetFile.createNewFile();
            }

            fileOutputStream = new FileOutputStream(targetFile, true); // 使用追加模式

            // 合并分片文件
            for (ArchiveZoneRecord archiveZoneRecord : archiveZoneRecords) {
                File partFile = new File(archiveZoneRecord.getZonePath(), archiveZoneRecord.getName());
                try (FileInputStream fis = new FileInputStream(partFile)) {
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = fis.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                }
            }

            // 更新文件信息
            archive.setZoneMergeDate(LocalDateTime.now());
            archive.setMergeFlag(true);
            fileRecordService.saveOrUpdate(archive);

            // 删除由于并发导致文件archive多条重复记录，todo 这里在上传方法中使用乐观锁锁来避免
            fileRecordService.remove(Wrappers.<Archive>lambdaQuery()
                    .eq(Archive::getMd5Value, archive.getMd5Value())
                    .isNotNull(Archive::isMergeFlag)
            );

        } catch (Exception e) {
            log.info("Exception while merging file parts: {}", e.getMessage());
            throw new RuntimeException("文件合并失败原因：" + e.getMessage());
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
