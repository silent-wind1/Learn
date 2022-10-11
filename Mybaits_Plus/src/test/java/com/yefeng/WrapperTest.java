package com.yefeng;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yefeng.entity.User;
import com.yefeng.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 条件查询
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    void testWrapper01() {
        //参数是一个wrapper ，条件构造器，和刚才的map对比学习！
        //查询name不为空，email不为空，age大于18的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 18);
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void testWrapper02() {
        // 查询name为小芳的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //查询一个数据selectOne，若查询出多个会报错
        //Expected one result (or null) to be returned by selectOne(), but found: *
        //若出现多个结果使用list或map
        wrapper.eq("name", "小芳");
        User user = userMapper.selectOne(wrapper); //查询一个数据，若出现多个结果使用selectList或selectMap
        System.out.println(user);
    }


    @Test
    void testWrapper03() {
        // 查询age在10-20之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 10 , 20);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
        // 统计有多少数据
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }


    @Test
    void testWrapper04() {
        // 模糊查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // select * from user where name not like "%小%" and email like "t%"
        // 查询name字段不带小并且email字段t开头的数据
        wrapper.notLike("name", "小").likeRight("email", "t");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testWrapper05() {
        // 模糊查询
        // SELECT id,name,age,email,version,deleted,create_time,update_time
        //FROM user
        //WHERE deleted=0 AND id IN
        //(select id from user where id<5)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //id 在子查询中查出来
        wrapper.inSql("id", "select id from user where id < 5");
        List<Object> users = userMapper.selectObjs(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testWrapper6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //通过id进行降序排序
        wrapper.orderByDesc("id");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    // 分组查询
    @Test
    public void testWrapper07() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 统计男女各多少人
        wrapper.select("sex, count(*) as count");
        wrapper.groupBy("sex");
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

}
