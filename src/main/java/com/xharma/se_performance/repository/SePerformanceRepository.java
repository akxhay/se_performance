package com.xharma.se_performance.repository;

import com.xharma.se_performance.entity.SePerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Repository interface for managing SE performance entities.
 * Author: Akshay Sharma
 */
@Repository
public interface SePerformanceRepository extends JpaRepository<SePerformance, Long> {

    /**
     * Retrieves SE performance by SE code.
     *
     * @param seCode the SE code
     * @return the SE performance associated with the given SE code
     */
    SePerformance findBySeCode(String seCode);
}
