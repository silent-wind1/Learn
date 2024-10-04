package com.example.zhou.controller;

import com.example.zhou.common.Result;
import com.example.zhou.common.ResultCode;
import com.example.zhou.entity.ArchiveZoneRecord;
import com.example.zhou.entity.enums.CheckType;
import com.example.zhou.param.FileUploadResultBO;
import com.example.zhou.param.ZoneUploadResultBO;
import com.example.zhou.service.IFileZoneRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author ZhouQuan
 * @desciption 文件上传操作录控制类
 * @date 2024/5/4 17:09
 */
@Validated
@Slf4j
@RestController
@RequestMapping("/v1/upload/zone")
public class FileUploadController {

    @Resource
    private IFileZoneRecordService iFileZoneRecordService;

    /**
     * 大文件分片上传
     *
     * @param multipartFile    文件二进制数据
     * @param id               文件ID
     * @param name             文件名称
     * @param type             文件类型
     * @param lastModifiedDate 最后修改日期
     * @param fileMd5          文件MD5
     * @param zoneTotalMd5     总分片MD5
     * @param zoneMd5          当前分片MD5
     * @param zoneTotalCount   总分片数量
     * @param zoneNowIndex     当前分片序号
     * @param zoneTotalSize    文件总大小
     * @param zoneStartSize    文件开始位置
     * @param zoneEndSize      文件结束位置
     * @param request          HttpServletRequest 对象
     * @return 返回上传结果
     */
    @PostMapping("/zoneUpload")
    public Result zoneUpload(
            @RequestParam("file") @NotNull(message = "文件不能为空") MultipartFile multipartFile,
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("lastModifiedDate") Date lastModifiedDate,
            @RequestParam("fileMd5") String fileMd5,
            @RequestParam("zoneTotalMd5") String zoneTotalMd5,
            @RequestParam("zoneMd5") String zoneMd5,
            @RequestParam("zoneTotalCount") int zoneTotalCount,
            @RequestParam("zoneNowIndex") int zoneNowIndex,
            @RequestParam("zoneTotalSize") long zoneTotalSize,
            @RequestParam("zoneStartSize") long zoneStartSize,
            @RequestParam("zoneEndSize") long zoneEndSize,
            HttpServletRequest request) {
        long startTime = System.currentTimeMillis();

        // 使用构造函数初始化 ArchiveZoneRecord 对象
        ArchiveZoneRecord archiveZoneRecord = new ArchiveZoneRecord(
                id, name, type, lastModifiedDate, fileMd5, zoneTotalMd5, zoneMd5,
                zoneTotalCount, zoneNowIndex, zoneTotalSize, zoneStartSize, zoneEndSize
        );

        // 调用服务方法进行上传
        ZoneUploadResultBO resultBo = iFileZoneRecordService.zoneUpload(request, archiveZoneRecord, multipartFile);

        long endTime = System.currentTimeMillis();
        log.info("zoneUpload 上传耗时：{} ms", (endTime - startTime));

        return new Result(ResultCode.SUCCESS, resultBo);
    }


    /**
     * 校验文件或者分片的md5值
     *
     * @param ArchiveZoneRecord 文件或者分片信息
     * @param checkType         FILE_EXISTS:校验文件是否存在,ZONE_EXISTS:校验分片是否存在
     * @param request
     * @return
     */
    @PostMapping("/md5Check")
    public Result md5Check(ArchiveZoneRecord ArchiveZoneRecord, CheckType checkType, HttpServletRequest request) {
        long l = System.currentTimeMillis();
        Result result = iFileZoneRecordService.md5Check(ArchiveZoneRecord, checkType, request);
        log.info("md5Check校验耗时：{}", System.currentTimeMillis() - l);
        return result;
    }

    /**
     * 合并文件
     * 前端所有分片上传完成时，发起请求，将所有的文件合并成一个完整的文件
     *
     * @param totalMd5 总文件的MD5值
     * @param request
     * @return
     */
    @PostMapping("/merge")
    public Result mergeZoneFile(@RequestParam("totalMd5") String totalMd5, HttpServletRequest request) {
        long l = System.currentTimeMillis();
        FileUploadResultBO result = iFileZoneRecordService.mergeZoneFile(totalMd5, request);
        log.info("merge合并校验耗时：{}", System.currentTimeMillis() - l);
        return new Result(ResultCode.SUCCESS, result);
    }

}
