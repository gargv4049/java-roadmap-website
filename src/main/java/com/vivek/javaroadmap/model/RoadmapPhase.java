package com.vivek.javaroadmap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roadmap_phases")
public class RoadmapPhase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int phaseOrder;

    @NotBlank
    private String title;

    private String level;
    private String duration;

    @Column(columnDefinition = "TEXT")
    private String goal;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "phase", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("topicOrder ASC")
    private List<RoadmapTopic> topics = new ArrayList<>();

    public RoadmapPhase() {
    }

    public RoadmapPhase(int phaseOrder, String title, String level, String duration, String goal, String description) {
        this.phaseOrder = phaseOrder;
        this.title = title;
        this.level = level;
        this.duration = duration;
        this.goal = goal;
        this.description = description;
    }

    public void addTopic(RoadmapTopic topic) {
        topics.add(topic);
        topic.setPhase(this);
    }

    public Long getId() {
        return id;
    }

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

    public List<RoadmapTopic> getTopics() {
        return topics;
    }

    public void setTopics(List<RoadmapTopic> topics) {
        this.topics = topics;
    }
}
