package com.friend.modules.demo.dao;


import com.friend.modules.demo.model.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

//    int update(User user);

//    int delete(User user);

    User getById(int userId);

    Page<User> getBypage();
}
