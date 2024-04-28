package com.Controller;

import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

//    @GetMapping("/updateUser")
//    public int updateUser() {
//        int row = userMapper.updateUser(new User(5, "yefeng", "123456"));
//        return row;
//    }


    @GetMapping("/queryUser/{id}")
    public List<UserVO> queryUser(@PathVariable int id) {
        List<UserVO> userList = userMapper.queryUser(id);
        for (UserVO user : userList) {
            System.out.println(user);
        }
        return userList;
    }
}
