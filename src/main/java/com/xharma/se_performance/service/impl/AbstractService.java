package com.xharma.se_performance.service.impl;

import com.xharma.se_performance.config.ColumnMappings;
import com.xharma.se_performance.repository.SePerformanceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Abstract service providing common functionalities and configurations.
 * Author: Akshay Sharma
 */
@Service
@Slf4j
public class AbstractService {

    @Autowired
    protected SePerformanceRepository sePerformanceRepository;

    @Value("${displayedColumnIndices}")
    protected String displayedColumnIndices;

    @Value("${csv.file.path}")
    protected String csvFilePath;

    @Value("${skip.rows:2}")
    protected int skipRows;

    @Value("${rsm.name:1}")
    protected int rsmName;

    @Value("${tm.name:2}")
    protected int tmName;

    @Value("${se.code:3}")
    protected int seCode;

    @Value("${emp.name:4}")
    protected int empName;

    @Autowired
    protected ColumnMappings columnMappings;

    // Add additional methods and functionalities as needed

}
