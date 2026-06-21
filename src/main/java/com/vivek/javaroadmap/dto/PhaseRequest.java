package com.vivek.javaroadmap.dto;

import jakarta.validation.constraints.NotBlank;

public class PhaseRequest {

    private int phaseOrder;

    @NotBlank(message = "Title is required")
    private String title;

    private String level;
    private String duration;
    private String goal;
    private String description;

    public int getPhaseOrder() {
        return phaseOrder;
    }

    public void setPhaseOrder(int phaseOrder) {
        this.phaseOrder = phaseOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
