package com.xharma.se_performance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entity class representing a CSV column.
 * Author: Akshay Sharma
 */
@Data
@Entity
public class CsvColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer columnIndex;
    private String columnName;
    private String columnValue;
}
