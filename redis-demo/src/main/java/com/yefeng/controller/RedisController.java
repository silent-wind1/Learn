package com.yefeng.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 叶枫
 * @Date: 2025/05/14/21:20
 * @Description:
 */
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/str/add/{name}/{value}")
    public String addRedis(@PathVariable("name") String name, @PathVariable("value") String value) {
        String key = "yefeng:" + name;
        log.info("添加redis键值对，key：{}，value：{}", key, value);
        stringRedisTemplate.opsForValue().set(key, value);
        return "添加成功";
    }

    @GetMapping("/str/get/{name}")
    public String getRedis(@PathVariable("name") String name) {
        String key = "yefeng:" + name;
        log.info("获取redis键值对，key：{}", key);
        return stringRedisTemplate.opsForValue().get(key);
    }

    @GetMapping("/str/del/{name}")
    public String delRedis(@PathVariable("name") String name) {
        String key = "yefeng:" + name;
        log.info("删除redis键值对，key：{}", key);
        stringRedisTemplate.delete(key);
        return "删除成功";
    }


    @GetMapping("/hash/add/{name}/{field}/{value}")
    public String addHashRedis(@PathVariable("name") String name, @PathVariable("field") String field, @PathVariable("value") String value) {
        String key = "yefeng:" + name;
        log.info("添加redis键值对，key：{}，field：{}，value：{}", key, field, value);
        stringRedisTemplate.opsForHash().put(key, field, value);
        return "添加成功";
    }

    @GetMapping("/hash/get/{name}/{field}")
    public String getHashRedis(@PathVariable("name") String name, @PathVariable("field") String field) {
        String key = "yefeng:" + name;
        log.info("获取redis hash 键值对，key：{}", key);
        return (String) stringRedisTemplate.opsForHash().get(key, field);
    }


    @GetMapping("/hash/del/{name}/{field}")
    public String delHashRedis(@PathVariable("name") String name, @PathVariable("field") String field) {
        String key = "yefeng:" + name;
        log.info("删除redis hash 键值对，key：{}", key);
        stringRedisTemplate.opsForHash().delete(key, field);
        return "删除成功";
    }


}
