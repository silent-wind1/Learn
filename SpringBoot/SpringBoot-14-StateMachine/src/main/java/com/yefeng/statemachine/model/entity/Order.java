package com.yefeng.statemachine.model.entity;

import com.yefeng.statemachine.model.enums.OrderStatusEnum;
import lombok.Data;

/**
 * @author wind
 * @description:
 * @date 2025/8/22 12:16
 */
@Data
public class Order {
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单状态
     */
    private OrderStatusEnum orderStatus;
}
