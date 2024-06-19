package com.yefeng.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.mapper.ItemMapper;
import com.yefeng.pojo.Item;
import com.yefeng.service.ItemService;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {


}
