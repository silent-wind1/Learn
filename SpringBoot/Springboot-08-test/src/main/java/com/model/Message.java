package com.model;

import lombok.Data;

/**
 * @Author: 叶枫
 * @Date: 2024/12/02/22:30
 * @Description:
 */
@Data
public class Message {
    private Boolean html;
    private String title;
    private String text;
    private String mailTo;
    private String mailForm;
}
