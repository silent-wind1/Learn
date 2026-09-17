package com.yefeng.statemachine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yefeng.statemachine.model.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wind
 * @description: 订单 Mapper（MyBatis-Plus）
 * @date 2025/9/17
 */
@Mapper
public interface OrderDao extends BaseMapper<Order> {
}
