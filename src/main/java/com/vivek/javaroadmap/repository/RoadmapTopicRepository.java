package com.vivek.javaroadmap.repository;

import com.vivek.javaroadmap.model.RoadmapTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoadmapTopicRepository extends JpaRepository<RoadmapTopic, Long> {
    List<RoadmapTopic> findAllByOrderByTopicOrderAsc();
}
