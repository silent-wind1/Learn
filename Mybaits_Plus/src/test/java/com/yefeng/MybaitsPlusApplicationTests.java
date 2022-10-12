package com.yefeng;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yefeng.entity.User;
import com.yefeng.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybaitsPlusApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Test
	void contextLoads() {
		List<User> users = userMapper.selectList(null);
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test//测试更新
	public void updateTest(){
		User user = new User();
		user.setId(2L);//怎么改id？？
		//通过条件自动拼接动态Sql
		user.setName("小枫");
		user.setAge(12);
		user.setEmail("update@qq.com");
		int i = userMapper.updateById(user);//updateById，但是参数是个user
		System.out.println(i);
	}

	@Test
	public void InsertUser() {
		User user = new User();
		user.setEmail("baidzhou@qq.com");
		user.setName("白轴");
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}


	@Test
	void TestOptimisticLocker() {
		User user = userMapper.selectById(1L);
		user.setName("请带好口罩");
		user.setAge(8);
		userMapper.updateById(user);
	}

	@Test//测试乐观锁失败  多线程下
	public void testOptimisticLocker2(){
		//线程1
		User user1 = userMapper.selectById(1L);
		user1.setAge(1);
		user1.setEmail("2803708553@qq.com");
		//模拟另外一个线程执行了插队操作
		User user2 = userMapper.selectById(1L);
		user2.setAge(2);
		user2.setEmail("2803708553@qq.com");
		userMapper.updateById(user2);
		//自旋锁来多次尝试提交！
		userMapper.updateById(user1);//如果没有乐观锁就会覆盖插队线程的值
	}


	@Test
	void testSelectById() {
		User user = userMapper.selectById(4);
		System.out.println(user);
	}

	@Test//通过id查询多个用户
	public void testSelectBatchIds(){
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
		users.forEach(System.out::println);
	}

	@Test//通过条件查询之一  map
	public void testMap(){
		HashMap<String, Object> map = new HashMap<>();
		//自定义要查询的
		map.put("name","yefeng");
		map.put("age",21);
		List<User> users = userMapper.selectByMap(map);
		users.forEach(System.out::println);
	}

	@Test//测试分页查询
	public void testPage(){
		//参数一current：当前页   参数二size：页面大小
		//使用了分页插件之后，所有的分页操作都变得简单了
		Page<User> page = new Page<>(1,5);
		userMapper.selectPage(page,null);
		page.getRecords().forEach(System.out::println);
		System.out.println("总页数==>"+page.getTotal());
		System.out.println("当前页==>" + page.getCurrent());
	}

	@Test
	void testDeleteByID() {
		userMapper.deleteById(4);
	}

	@Test
	void testDeleteByIDs() {
		userMapper.deleteById(5);
	}

	@Test
	void testDeleteByMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "白轴");
		userMapper.deleteByMap(map);
	}

	@Test
	void testSelectMapByID() {
		Map<String, Object> map = userMapper.selectMapByID(1L);
		System.out.println(map);
	}

}
