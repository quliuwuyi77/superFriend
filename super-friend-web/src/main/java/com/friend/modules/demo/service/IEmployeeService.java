package com.friend.modules.demo.service;


import com.friend.modules.demo.model.Employee;
import com.github.pagehelper.Page;

import java.util.List;

public interface IEmployeeService {

    Page<Employee> selectEmployeeByPage(Integer page, Integer rows,Employee employee);

    public int deleteByPrimaryKey(Integer id);

    public int insert(Employee record);

    public int insertSelective(Employee record);

    public Employee selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Employee record);

    public int updateByPrimaryKey(Employee record);
}
