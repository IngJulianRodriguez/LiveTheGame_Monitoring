package com.livethegame.Monitoring.repository;

import com.livethegame.Monitoring.entities.ServicesUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesUrlRepository extends JpaRepository<ServicesUrl, Long> {
    List<ServicesUrl> findByActive (boolean active);
}
