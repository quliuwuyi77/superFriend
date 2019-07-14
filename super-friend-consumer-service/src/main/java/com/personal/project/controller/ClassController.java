package com.personal.project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Value("${server.port}")
    String port;

    @GetMapping(value = "/getClass")
    public String getStudentAndClass(@RequestParam String name) {


        //String className = classServiceFeign.getStudentAndClass( name );

        return "DaMoZhang School,class one grade one .";
    }

    /**
     * 测试服务是否存活
     * @return
     */
    @RequestMapping(value = "/hi")
    public String sayHi() {
        return  "consumer service is survived,port is " + this.port;
    }
}