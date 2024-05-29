package com.livethegame.Monitoring.repository;

import com.livethegame.Monitoring.entities.LogRecords;
import com.livethegame.Monitoring.entities.Types;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypesRepository extends JpaRepository<Types, Long> {
}
