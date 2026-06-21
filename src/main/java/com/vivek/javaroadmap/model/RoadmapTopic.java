package com.vivek.javaroadmap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "roadmap_topics")
public class RoadmapTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int topicOrder;

    @NotBlank
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean projectBased;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phase_id")
    @JsonIgnore
    private RoadmapPhase phase;

    public RoadmapTopic() {
    }

    public RoadmapTopic(int topicOrder, String name, String description, boolean projectBased) {
        this.topicOrder = topicOrder;
        this.name = name;
        this.description = description;
        this.projectBased = projectBased;
    }

    public Long getId() {
        return id;
    }

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

    public RoadmapPhase getPhase() {
        return phase;
    }

    public void setPhase(RoadmapPhase phase) {
        this.phase = phase;
    }
}
