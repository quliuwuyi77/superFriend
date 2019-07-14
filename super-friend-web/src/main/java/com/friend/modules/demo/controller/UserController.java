package com.friend.modules.demo.controller;

import com.friend.modules.demo.model.User;
import com.friend.modules.demo.service.IUserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("getUserbyPage")
    public Page<User> getUserByPage(Integer page, Integer rows){

        return userService.getByPage(page,rows);
    }

    @RequestMapping("getUserById")
    public User getUserById(Integer id){
        User user = userService.getById(id);
        return user;
    }

}
