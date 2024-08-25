package com.example.zhou.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zhou.common.Result;
import com.example.zhou.entity.ArchiveZoneRecord;
import com.example.zhou.entity.enums.CheckType;
import com.example.zhou.param.FileUploadResultBO;
import com.example.zhou.param.ZoneUploadResultBO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 文件上传记录 服务类
 * </p>
 *
 * @author haijun
 * @since 2020-02-14
 */
@Service
public interface IFileZoneRecordService extends IService<ArchiveZoneRecord> {

    /**
     * 分片上传
     *
     * @param request
     * @param ArchiveZoneRecord
     * @return
     */
    ZoneUploadResultBO zoneUpload(HttpServletRequest request, ArchiveZoneRecord ArchiveZoneRecord, MultipartFile multipartFile);

    /**
     * 校验分片
     *
     * @param ArchiveZoneRecord
     * @param checkType
     * @param request
     * @return
     */
    Result md5Check(ArchiveZoneRecord ArchiveZoneRecord, CheckType checkType, HttpServletRequest request);

    /**
     * 合并分片
     *
     * @param totalMd5
     * @param request
     * @return
     */
    FileUploadResultBO mergeZoneFile(String totalMd5, HttpServletRequest request);
}
