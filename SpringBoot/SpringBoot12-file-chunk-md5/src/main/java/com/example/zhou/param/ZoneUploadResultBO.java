package com.example.zhou.param;

import com.example.zhou.entity.ArchiveZoneRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhouQuan
 * @description todo
 * @date 2024-05-05 10:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZoneUploadResultBO {

    /**
     * 分片记录
     */
    private ArchiveZoneRecord zoneRecord;

    /**
     * 是否存在
     */
    private boolean isExist;

    /**
     * 当前分片索引
     */
    private Integer zoneNowIndex;
}
