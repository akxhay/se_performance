package com.xharma.se_performance.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to load column mappings from environment properties.
 * Author: Akshay Sharma
 */
@Component
@Getter
public class ColumnMappings {

    @Autowired
    private Environment environment;

    private final Map<Integer, String> columnMappings = new HashMap<>();

    /**
     * Loads column mappings from environment properties during bean initialization.
     * Each property key should be in the format "column.mappings.{index}" where {index} starts from 1.
     * The method stops loading mappings when no property is found for the next index.
     */
    @PostConstruct
    public void loadColumnMappings() {
        int i = 1;
        while (true) {
            String key = "column.mappings." + i;
            if (environment.containsProperty(key)) {
                String value = environment.getProperty(key);
                columnMappings.put(i, value);
                i++;
            } else {
                break;
            }
        }
    }
}



