package com.mapper;

import com.pojo.User;
import com.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();

//    int updateUser(User user);

    List<UserVO> queryUser(int id);


}
