package com.yefeng.statemachine.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yefeng.statemachine.model.enums.OrderStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wind
 * @description: 订单实体（MyBatis-Plus）
 * @date 2025/8/22 12:16
 */
@Data
@TableName("`order`")
public class Order {

    /**
     * 主键 id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 业务订单号
     */
    private Long orderId;

    /**
     * 订单状态
     */
    private OrderStatusEnum orderStatus;

    /**
     * 逻辑删除标记
     */
    @TableLogic
    private Integer deleted;

    /**
     * 创建时间（自动填充）
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间（自动填充）
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
