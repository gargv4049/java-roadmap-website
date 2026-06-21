package com.vivek.javaroadmap.controller;

import com.vivek.javaroadmap.dto.ProgressRequest;
import com.vivek.javaroadmap.dto.ProgressResponse;
import com.vivek.javaroadmap.model.UserProgress;
import com.vivek.javaroadmap.service.ProgressService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "*")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping
    public ProgressResponse getProgress(@RequestParam(defaultValue = "Vivek") String learnerName) {
        return progressService.getProgress(learnerName);
    }

    @PostMapping("/toggle")
    public UserProgress toggleProgress(@Valid @RequestBody ProgressRequest request) {
        return progressService.toggleProgress(request);
    }
}
