package com.vivek.javaroadmap.repository;

import com.vivek.javaroadmap.model.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {
    Optional<UserProgress> findByLearnerNameAndTopicId(String learnerName, Long topicId);
    List<UserProgress> findByLearnerNameAndCompletedTrue(String learnerName);
}
