package com.personal.project.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-consumer")
public interface IClassServiceFeign {

    @RequestMapping(value = "/class/getClass",method = RequestMethod.GET)
    String getStudentAndClass(@RequestParam(value = "name") String name);

}