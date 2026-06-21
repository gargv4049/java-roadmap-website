package com.vivek.javaroadmap.dto;

import java.util.Set;

public class ProgressResponse {

    private long totalTopics;
    private long completedTopics;
    private double percentage;
    private Set<Long> completedTopicIds;

    public ProgressResponse(long totalTopics, long completedTopics, double percentage, Set<Long> completedTopicIds) {
        this.totalTopics = totalTopics;
        this.completedTopics = completedTopics;
        this.percentage = percentage;
        this.completedTopicIds = completedTopicIds;
    }

    public long getTotalTopics() {
        return totalTopics;
    }

    public long getCompletedTopics() {
        return completedTopics;
    }

    public double getPercentage() {
        return percentage;
    }

    public Set<Long> getCompletedTopicIds() {
        return completedTopicIds;
    }
}
