package com.vivek.javaroadmap.service;

import com.vivek.javaroadmap.dto.ProgressRequest;
import com.vivek.javaroadmap.dto.ProgressResponse;
import com.vivek.javaroadmap.model.UserProgress;
import com.vivek.javaroadmap.repository.RoadmapTopicRepository;
import com.vivek.javaroadmap.repository.UserProgressRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProgressService {

    private final UserProgressRepository progressRepository;
    private final RoadmapTopicRepository topicRepository;

    public ProgressService(UserProgressRepository progressRepository, RoadmapTopicRepository topicRepository) {
        this.progressRepository = progressRepository;
        this.topicRepository = topicRepository;
    }

    public UserProgress toggleProgress(ProgressRequest request) {
        UserProgress progress = progressRepository
                .findByLearnerNameAndTopicId(request.getLearnerName(), request.getTopicId())
                .orElse(new UserProgress(request.getLearnerName(), request.getTopicId(), false));

        progress.setCompleted(!progress.isCompleted());
        return progressRepository.save(progress);
    }

    public ProgressResponse getProgress(String learnerName) {
        long totalTopics = topicRepository.count();

        Set<Long> completedTopicIds = progressRepository
                .findByLearnerNameAndCompletedTrue(learnerName)
                .stream()
                .map(UserProgress::getTopicId)
                .collect(Collectors.toSet());

        long completedTopics = completedTopicIds.size();
        double percentage = totalTopics == 0 ? 0 : (completedTopics * 100.0) / totalTopics;

        return new ProgressResponse(totalTopics, completedTopics, percentage, completedTopicIds);
    }
}
