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
     * @param request          HttpServletRequest 对象
     * @return 返回上传结果
     */
    @PostMapping("/zoneUpload")
    public Result zoneUpload(
            @RequestParam("file") @NotNull(message = "文件不能为空") MultipartFile multipartFile,
            @RequestBody  ArchiveZoneRecord archiveZoneRecord,
            HttpServletRequest request) {
        long startTime = System.currentTimeMillis();

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
