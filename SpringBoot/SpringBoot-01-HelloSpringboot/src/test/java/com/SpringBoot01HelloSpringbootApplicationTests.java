package com;

import com.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SpringBoot01HelloSpringbootApplicationTests {
    @Resource
    private Person person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
