package com.yefeng;

import com.yefeng.entity.User;
import com.yefeng.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;


    @Test
    void testService() {
        List<User> list = userService.list(null);
        list.forEach(System.out::println);
    }

    @Test
    void testService1() {
        User user = userService.findList();
        System.out.println(user);
    }

}
