package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "redis")
public class NodeMap {
    private Map<String,String> node = new HashMap<>();

    public Map<String, String> getNode() {
        return node;
    }
}
