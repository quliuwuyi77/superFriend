package com.friend.modules.demo.service;


import com.friend.modules.demo.model.User;
import com.github.pagehelper.Page;

import java.util.List;


public interface IUserService {

    boolean createUser(User user) ;

    Page<User> getByPage(int page, int rows) ;

    User getById(Integer id);

}
