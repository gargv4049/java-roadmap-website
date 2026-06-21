package com.vivek.javaroadmap.service;

import com.vivek.javaroadmap.dto.PhaseRequest;
import com.vivek.javaroadmap.dto.TopicRequest;
import com.vivek.javaroadmap.model.RoadmapPhase;
import com.vivek.javaroadmap.model.RoadmapTopic;
import com.vivek.javaroadmap.repository.RoadmapPhaseRepository;
import com.vivek.javaroadmap.repository.RoadmapTopicRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoadmapService {

    private final RoadmapPhaseRepository phaseRepository;
    private final RoadmapTopicRepository topicRepository;

    public RoadmapService(RoadmapPhaseRepository phaseRepository, RoadmapTopicRepository topicRepository) {
        this.phaseRepository = phaseRepository;
        this.topicRepository = topicRepository;
    }

    public List<RoadmapPhase> getAllPhases() {
        return phaseRepository.findAllByOrderByPhaseOrderAsc();
    }

    public RoadmapPhase createPhase(PhaseRequest request) {
        RoadmapPhase phase = new RoadmapPhase(
                request.getPhaseOrder(),
                request.getTitle(),
                request.getLevel(),
                request.getDuration(),
                request.getGoal(),
                request.getDescription()
        );
        return phaseRepository.save(phase);
    }

    public RoadmapPhase updatePhase(Long id, PhaseRequest request) {
        RoadmapPhase phase = phaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phase not found with id: " + id));

        phase.setPhaseOrder(request.getPhaseOrder());
        phase.setTitle(request.getTitle());
        phase.setLevel(request.getLevel());
        phase.setDuration(request.getDuration());
        phase.setGoal(request.getGoal());
        phase.setDescription(request.getDescription());

        return phaseRepository.save(phase);
    }

    public void deletePhase(Long id) {
        if (!phaseRepository.existsById(id)) {
            throw new RuntimeException("Phase not found with id: " + id);
        }
        phaseRepository.deleteById(id);
    }

    public RoadmapTopic createTopic(TopicRequest request) {
        RoadmapPhase phase = phaseRepository.findById(request.getPhaseId())
                .orElseThrow(() -> new RuntimeException("Phase not found with id: " + request.getPhaseId()));

        RoadmapTopic topic = new RoadmapTopic(
                request.getTopicOrder(),
                request.getName(),
                request.getDescription(),
                request.isProjectBased()
        );
        topic.setPhase(phase);

        return topicRepository.save(topic);
    }

    public RoadmapTopic updateTopic(Long id, TopicRequest request) {
        RoadmapTopic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found with id: " + id));

        RoadmapPhase phase = phaseRepository.findById(request.getPhaseId())
                .orElseThrow(() -> new RuntimeException("Phase not found with id: " + request.getPhaseId()));

        topic.setTopicOrder(request.getTopicOrder());
        topic.setName(request.getName());
        topic.setDescription(request.getDescription());
        topic.setProjectBased(request.isProjectBased());
        topic.setPhase(phase);

        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        if (!topicRepository.existsById(id)) {
            throw new RuntimeException("Topic not found with id: " + id);
        }
        topicRepository.deleteById(id);
    }
}
