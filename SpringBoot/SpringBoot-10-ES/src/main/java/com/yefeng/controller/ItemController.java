package com.yefeng.controller;

import com.yefeng.pojo.Item;
import com.yefeng.pojo.itemDoc;
import com.yefeng.service.ItemService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

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

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @GetMapping("/es")
    public String queryItemByEs() {
        Item item = itemService.getById(561178L);
        itemDoc itemDoc = new itemDoc();
        BeanUtils.copyProperties(item, itemDoc);
        System.out.println(itemDoc);
        elasticsearchRestTemplate.indexOps(itemDoc.class);
        elasticsearchRestTemplate.save(itemDoc);
        return "ok";
    }
}
