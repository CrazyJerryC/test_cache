package com.example.service.impl;

import com.example.entity.Student;
import com.example.service.TestService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "test")
public class TestServiceImpl implements TestService {

    @Override
    @Cacheable(cacheNames = "quary",key = "#key")
    public String query(String key) {
        System.out.println("execute query method");
        return "query method "+key;
    }

    @Override
    @Cacheable(cacheNames = "student")
    public String testEntity(Student student) {
        System.out.println("execute testEntity method");
        return "testEntity method "+student;
    }
}
