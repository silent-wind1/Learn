package com.yefeng.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

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


    @GetMapping("/hash/getAll/{name}")
    public String getAllHashRedis(@PathVariable("name") String name) {
        String key = "yefeng:" + name;
        log.info("获取redis hash all 键值对，key：{}", key);
        return (String) stringRedisTemplate.opsForHash().get(key, name);
    }

    @GetMapping("/list/add/left/{key}/{value}")
    public String addListLeftRedis(@PathVariable("key") String key,  @PathVariable("value") String value){
        String keys = "yefeng:" + key;
        log.info("添加redis list left 键值对，key：{}", keys);
        stringRedisTemplate.opsForList().leftPush(keys, value);
        return "添加成功";
    }

    @GetMapping("/list/add/right/{key}/{value}")
    public String addListRightRedis(@PathVariable("key") String key,  @PathVariable("value") String value){
        String keys = "yefeng:" + key;
        log.info("添加redis list right 键值对，key：{}", keys);
        stringRedisTemplate.opsForList().rightPush(keys, value);
        return "添加成功";
    }

    @GetMapping("/list/set/{key}/{index}/{value}")
    public String addListSetRedis(@PathVariable("key") String key,  @PathVariable("index") Long index, @PathVariable("value") String value){
        String keys = "yefeng:" + key;
        log.info("修改redis list index 键值对，key：{}", keys);
        stringRedisTemplate.opsForList().set(keys, index, value);
        return "添加成功";
    }

    @GetMapping("/list/get/{key}/{start}/{end}")
    public String getListRedis(@PathVariable("key") String key,  @PathVariable("start") Long start, @PathVariable("end") Long end){
        String keys = "yefeng:" + key;
        log.info("获取redis list index 键值对，key：{}", keys);
        return Objects.requireNonNull(stringRedisTemplate.opsForList().range(keys, start, end)).toString();
    }


    @GetMapping("/list/del/left/{key}/")
    public String delListLeftRedis(@PathVariable("key") String key){
        String keys = "yefeng:" + key;
        log.info("删除redis list left 键值对，key：{}", keys);
        stringRedisTemplate.opsForList().leftPop(keys);
        return "添加成功";
    }

}
