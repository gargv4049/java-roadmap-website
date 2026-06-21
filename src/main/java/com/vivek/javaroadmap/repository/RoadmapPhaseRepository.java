package com.vivek.javaroadmap.repository;

import com.vivek.javaroadmap.model.RoadmapPhase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoadmapPhaseRepository extends JpaRepository<RoadmapPhase, Long> {
    List<RoadmapPhase> findAllByOrderByPhaseOrderAsc();
}
