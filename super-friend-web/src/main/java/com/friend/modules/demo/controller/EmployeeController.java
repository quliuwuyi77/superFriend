package com.friend.modules.demo.controller;

import com.friend.modules.demo.dao.EmployeeMapper;
import com.friend.modules.demo.model.Employee;
import com.friend.modules.demo.model.User;
import com.friend.modules.demo.service.IEmployeeService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController{

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("selectEmployeeByPage")
    @ResponseBody
    public Page<Employee> selectEmployeeByPage(Integer page, Integer rows){
        Employee employee = new Employee();
        employee.setName("I am db1");
        return employeeService.selectEmployeeByPage(page,rows,employee);
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public int deleteByPrimaryKey(Integer id){
        return employeeService.deleteByPrimaryKey(id);
    }

    @RequestMapping("insert")
    @ResponseBody
    public int insert(){
        Employee record = new Employee();
        return employeeService.insert(record);
    }

    @RequestMapping("insertSelective")
    @ResponseBody
    public int insertSelective(Employee record){
        return employeeService.insertSelective(record);
    }


    @RequestMapping("selectById")
    @ResponseBody
    public Employee selectByPrimaryKey(Integer id){
        return employeeService.selectByPrimaryKey(id);
    }

    @RequestMapping("updateByIdSelective")
    @ResponseBody
    public int updateByPrimaryKeySelective(Employee record){
        return employeeService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping("updateById")
    @ResponseBody
    public int updateByPrimaryKey(Employee record){
        return employeeService.updateByPrimaryKey(record);
    }
}
