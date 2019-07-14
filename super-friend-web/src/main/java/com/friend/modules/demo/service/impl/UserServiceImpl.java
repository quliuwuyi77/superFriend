package com.friend.modules.demo.service.impl;

import com.friend.modules.demo.dao.UserMapper;
import com.friend.modules.demo.model.User;
import com.friend.modules.demo.service.IUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public boolean createUser(User user) {
        userMapper.insert(user);

        //事务测试
//        int i = 1 / 0;
        return true;
    }

    @Override
    public Page<User> getByPage(int page, int rows) {
        Page<User> userPage = PageHelper.startPage(page, rows,true);
        Page<User> users = userMapper.getBypage();
        System.out.println("-------------------" + userPage.toString() + "-----------");
        return users;
    }
    @Override
    public User getById(Integer id){
        User user = userMapper.getById(id);
        return user;
    }
}
