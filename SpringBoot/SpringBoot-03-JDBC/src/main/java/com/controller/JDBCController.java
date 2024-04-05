package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Resource
    JdbcTemplate jdbcTemplate;
//  查询数据库的所有信息
//  没有实体类，数据库中的东西，怎么获取？Map
    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @GetMapping("/addUser")
    // 添加数据
    public String addUser() {
        String sql = "insert into user  values(7, '小明', '214567')";
        jdbcTemplate.update(sql);
        return "add_ok";
    }

    @GetMapping("/updateUser")
    // 添加数据
    public String updateUser() {
        String sql = "update user set name='小枫', pwd='4321' where id=7";
        jdbcTemplate.update(sql);
        return "update_OK";
    }

    @GetMapping("/delUser")
    // 添加数据
    public String delete() {
        String sql = "delete from USER where id=7;";
        jdbcTemplate.update(sql);
        return "del_ok";
    }
}
