package com.example.zhou.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author ZhouQuan
 * @desciption 分片文件接收对象
 * @date 2024/6/10 10:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZoneUploadDTO {

    /**
     * 文件 ID
     */
    private String id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 最后修改日期
     */
    private Date lastModifiedDate;

    /**
     * 文件大小
     */
    private long size;

    /**
     * 总块数
     */
    private int chunks;

    /**
     * 当前块数
     */
    private int chunk;

    /**
     * 文件二进制数据
     */
    private MultipartFile file;

}
