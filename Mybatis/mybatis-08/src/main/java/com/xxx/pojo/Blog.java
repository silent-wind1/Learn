package com.xxx.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Blog
 * @Description TODO
 * @Author yefeng
 * @Date 2021/4/19 11:38
 * @Version 1.0
 */
@Data
public class Blog {
  private String id;
  private String title;
  private String author;
  private Date createTime;
  private int views;
}
