package com.yefeng.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: 叶枫
 * @Date: 2025/05/23/22:01
 * @Description:
 */
@Data
public class Order {
    /**
     * id
     */
    private Long id;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单状态
     */
    private int status;
    /**
     * 订单名称
     */
    private String name;
    /**
     * 订单价格
     */
    private BigDecimal price;
    /**
     * 删除标记
     */
    private int deleteFlag;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private String createUserCode;
    /**
     * 更新人
     */
    private String updateUserCode;
    /**
     * 版本号
     */
    private int version;
    /**
     * 备注
     */
    private String remark;
}
