package com.xharma.se_performance.service;

import com.xharma.se_performance.entity.SePerformance;
import jakarta.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service interface for managing SE performance data.
 */
public interface ISePerformanceService {

    /**
     * Loads data from CSV file to the database.
     */
    @Transactional
    @PostConstruct
    void loadCsvDataToDatabase();

    /**
     * Retrieves all SE performance entities from the database.
     *
     * @return List of SE performance entities
     */
    List<SePerformance> getAllEntities();

    /**
     * Retrieves SE performance entity by SE code.
     *
     * @param seCode SE code
     * @return SE performance entity
     */
    SePerformance getSePerformanceBySeCode(String seCode);

    /**
     * Retrieves indices of displayed columns.
     *
     * @return List of displayed column indices
     */
    List<Integer> getDisplayedColumnIndices();
}
