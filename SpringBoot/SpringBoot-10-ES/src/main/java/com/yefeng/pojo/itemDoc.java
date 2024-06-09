package com.yefeng.pojo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Data
@Document(indexName = "itemdoc")
public class itemDoc {

    private String id;

    private String name;

    private Integer price;

    private String image;

    private String category;

    private String brand;

    private Integer sold;

    private Integer commentCount;

    private Boolean isAD;

    private LocalDateTime updateTime;
}