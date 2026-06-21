package com.vivek.javaroadmap.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TopicRequest {

    private int topicOrder;

    @NotBlank(message = "Topic name is required")
    private String name;

    private String description;
    private boolean projectBased;

    @NotNull(message = "Phase id is required")
    private Long phaseId;

    public int getTopicOrder() {
        return topicOrder;
    }

    public void setTopicOrder(int topicOrder) {
        this.topicOrder = topicOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProjectBased() {
        return projectBased;
    }

    public void setProjectBased(boolean projectBased) {
        this.projectBased = projectBased;
    }

    public Long getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Long phaseId) {
        this.phaseId = phaseId;
    }
}
