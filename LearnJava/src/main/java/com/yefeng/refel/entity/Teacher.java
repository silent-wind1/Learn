package com.yefeng.refel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 叶枫
 * @Date: 2025/02/24/22:19
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String fullName;
    private int yearsOld;
    private String location;
}
