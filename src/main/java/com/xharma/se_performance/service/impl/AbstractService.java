package com.xharma.se_performance.service.impl;

import com.xharma.se_performance.config.ColumnMappings;
import com.xharma.se_performance.repository.SePerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Abstract service providing common functionalities and configurations.
 * Author: Akshay Sharma
 */
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

}
