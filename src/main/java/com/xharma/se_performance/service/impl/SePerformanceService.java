package com.xharma.se_performance.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.xharma.se_performance.entity.CsvColumn;
import com.xharma.se_performance.entity.SePerformance;
import com.xharma.se_performance.service.ISePerformanceService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing SE performance data.
 * Author: Akshay Sharma
 */
@Service
@Slf4j
public class SePerformanceService extends AbstractService implements ISePerformanceService {

    /**
     * Loads data from CSV file to the database.
     */
    @Transactional
    @PostConstruct
    @Override
    public void loadCsvDataToDatabase() {
        sePerformanceRepository.deleteAll();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            for (int i = 0; i < skipRows; i++) {
                reader.readNext(); // Skip the row
            }
            String[] row;
            while ((row = reader.readNext()) != null) {
                saveSePerformanceFromRow(row);
            }
        } catch (IOException | CsvException e) {
            log.error("Error occurred while processing CSV file: {}", e.getMessage());
        }
    }

    /**
     * Retrieves all SE performance entities from the database.
     *
     * @return List of SE performance entities
     */
    @Override
    public List<SePerformance> getAllEntities() {
        return sePerformanceRepository.findAll();
    }

    /**
     * Retrieves SE performance entity by SE code.
     *
     * @param seCode SE code
     * @return SE performance entity
     */
    @Override
    public SePerformance getSePerformanceBySeCode(String seCode) {
        return sePerformanceRepository.findBySeCode(seCode);
    }

    /**
     * Retrieves indices of displayed columns.
     *
     * @return List of displayed column indices
     */
    @Override
    public List<Integer> getDisplayedColumnIndices() {
        return Arrays.stream(displayedColumnIndices.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    // Helper method to save SE performance data from a CSV row
    private void saveSePerformanceFromRow(String[] row) {
        int numColumns = columnMappings.getColumnMappings().size();
        SePerformance sePerformance = new SePerformance();
        for (int i = 0; i < numColumns; i++) {
            CsvColumn csvColumn = new CsvColumn();
            csvColumn.setColumnIndex(i);
            csvColumn.setColumnName(columnMappings.getColumnMappings().get(i + 1)); // Adjust index
            csvColumn.setColumnValue(row[i]);
            setMasterData(sePerformance, i + 1, row[i]);
            sePerformance.getData().add(csvColumn);
        }
        sePerformanceRepository.save(sePerformance);
    }

    // Helper method to set master data in SE performance entity
    private void setMasterData(SePerformance sePerformance, int columnIndex, String columnValue) {
        if (columnIndex == rsmName) {
            sePerformance.setRsmName(columnValue);
        } else if (columnIndex == tmName) {
            sePerformance.setTmName(columnValue);
        } else if (columnIndex == seCode) {
            sePerformance.setSeCode(columnValue);
        } else if (columnIndex == empName) {
            sePerformance.setEmpName(columnValue);
        }
    }
}
