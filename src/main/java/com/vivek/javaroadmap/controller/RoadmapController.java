package com.vivek.javaroadmap.controller;

import com.vivek.javaroadmap.dto.PhaseRequest;
import com.vivek.javaroadmap.dto.TopicRequest;
import com.vivek.javaroadmap.model.RoadmapPhase;
import com.vivek.javaroadmap.model.RoadmapTopic;
import com.vivek.javaroadmap.service.RoadmapService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roadmap")
@CrossOrigin(origins = "*")
public class RoadmapController {

    private final RoadmapService roadmapService;

    public RoadmapController(RoadmapService roadmapService) {
        this.roadmapService = roadmapService;
    }

    @GetMapping("/phases")
    public List<RoadmapPhase> getAllPhases() {
        return roadmapService.getAllPhases();
    }

    @PostMapping("/phases")
    public RoadmapPhase createPhase(@Valid @RequestBody PhaseRequest request) {
        return roadmapService.createPhase(request);
    }

    @PutMapping("/phases/{id}")
    public RoadmapPhase updatePhase(@PathVariable Long id, @Valid @RequestBody PhaseRequest request) {
        return roadmapService.updatePhase(id, request);
    }

    @DeleteMapping("/phases/{id}")
    public String deletePhase(@PathVariable Long id) {
        roadmapService.deletePhase(id);
        return "Phase deleted successfully";
    }

    @PostMapping("/topics")
    public RoadmapTopic createTopic(@Valid @RequestBody TopicRequest request) {
        return roadmapService.createTopic(request);
    }

    @PutMapping("/topics/{id}")
    public RoadmapTopic updateTopic(@PathVariable Long id, @Valid @RequestBody TopicRequest request) {
        return roadmapService.updateTopic(id, request);
    }

    @DeleteMapping("/topics/{id}")
    public String deleteTopic(@PathVariable Long id) {
        roadmapService.deleteTopic(id);
        return "Topic deleted successfully";
    }
}
