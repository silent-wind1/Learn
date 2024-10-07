package com.yefeng.controller;

import com.yefeng.pojo.Item;
import com.yefeng.pojo.itemDoc;
import com.yefeng.service.ItemService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 叶枫
 * @Date: 2024/06/09/21:51
 * @Description:
 */
@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    @GetMapping("/es")
    public itemDoc queryItemByEs() {
        Item item = itemService.getById(561178L);
        itemDoc itemDoc = new itemDoc();
        BeanUtils.copyProperties(item, itemDoc);
        System.out.println(itemDoc);
        return itemDoc;
    }

    @GetMapping("/es/{id}")
    public itemDoc queryItemByIdEs(@PathVariable String id) {
        Item item = itemService.getById(id);
        itemDoc itemDoc = new itemDoc();
        BeanUtils.copyProperties(item, itemDoc);
        System.out.println(itemDoc);
        return itemDoc;
    }
}
