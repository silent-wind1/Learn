package com.yefeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yefeng.pojo.Item;
import org.apache.ibatis.annotations.Mapper;


/**
 * 商品表 Mapper 接口
 */
@Mapper
public interface ItemMapper extends BaseMapper<Item> {

}
