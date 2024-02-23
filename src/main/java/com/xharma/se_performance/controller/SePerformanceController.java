package com.xharma.se_performance.controller;

import com.xharma.se_performance.entity.SePerformance;
import com.xharma.se_performance.service.impl.SePerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SePerformanceController {
    @Autowired
    private SePerformanceService sePerformanceService;

    @PutMapping("/data")
    public ResponseEntity<String> putData() {
        sePerformanceService.loadCsvDataToDatabase();
        return ResponseEntity.ok("Done");
    }

    @GetMapping("/data")
    public ResponseEntity<List<SePerformance>> getDataBySeCode() {
        var data = sePerformanceService.getAllEntities();
        if (data != null) {
            return ResponseEntity.ok(data);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
