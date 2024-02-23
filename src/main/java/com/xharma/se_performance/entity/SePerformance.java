package com.xharma.se_performance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class representing SE performance.
 * Author: Akshay Sharma
 */
@Data
@Entity
public class SePerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rsmName;

    private String tmName;

    private String seCode;

    private String empName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "se_performance_id")
    private List<CsvColumn> data = new ArrayList<>();
}

