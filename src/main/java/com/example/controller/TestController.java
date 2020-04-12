package com.example.controller;

import com.example.entity.Student;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public String test(){
        String str = stringRedisTemplate.opsForValue().get("test");
        System.out.println(str);
        return str;
    }

    @GetMapping("/testQuery")
    public String testQuery(String key){
        return testService.query(key);
    }

    @GetMapping("/testStudent")
    public String testStudent(){
        Student student = new Student();
        student.id="stu1";
        student.name="name";
        return testService.testEntity(student);
    }
}
