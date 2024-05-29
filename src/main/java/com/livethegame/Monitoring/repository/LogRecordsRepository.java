package com.livethegame.Monitoring.repository;

import com.livethegame.Monitoring.entities.LogRecords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRecordsRepository extends JpaRepository<LogRecords, Long> {
    List<LogRecords> findByTypeId(Long typeId);
}
