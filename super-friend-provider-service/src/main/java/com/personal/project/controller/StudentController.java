package com.personal.project.controller;

import com.personal.project.service.IClassServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IClassServiceFeign classServiceFeign;

    @Value("${server.port}")
    String port;

    /**
     * 查询学生及所在的班级
     * @param name
     * @return
     */
    @GetMapping(value = "/getStudent")
    public String getStudentAndClass(@RequestParam String name) {

        String studentName = "XiaoMing";
        String className = classServiceFeign.getStudentAndClass( name );

        return "name: " + studentName + " in class " + className;
    }

    /**
     * 测试服务是否存活
     * @return
     */
    @GetMapping(value = "/hi")
    public String sayHi() {
        return  "provider service is survived,port is " + this.port;
    }
}