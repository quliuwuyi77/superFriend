package com.friend.modules.demo.service.impl;

import com.friend.modules.demo.dao.EmployeeMapper;
import com.friend.modules.demo.model.Employee;
import com.friend.modules.demo.model.User;
import com.friend.modules.demo.service.IEmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Page<Employee> selectEmployeeByPage(Integer page, Integer rows,Employee employee){
        Page<Employee> employeesPage = PageHelper.startPage(page, rows,true);
        Page<Employee> employees = employeeMapper.selectEmployeeByPage(employee);
        System.out.println("-------------------" + employeesPage.toString() + "-----------");
        return employees;
    }
    @Override
    public int deleteByPrimaryKey(Integer id){
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Employee record){
        return employeeMapper.insert(record);
    }

    @Override
    public int insertSelective(Employee record){
        return employeeMapper.insertSelective(record);
    }

    @Override
    public Employee selectByPrimaryKey(Integer id){
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record){
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record){
        return employeeMapper.updateByPrimaryKey(record);
    }
}
