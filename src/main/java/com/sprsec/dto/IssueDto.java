package com.sprsec.dto;

import org.springframework.stereotype.Component;

@Component
public class IssueDto
{
    private int id;

    private String title;

    private String description;

    private String priority;

    private String status;

    private int projectId;

    private int fixerId;

    private int testerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTesterId() {
        return testerId;
    }

    public void setTesterId(int testerId) {
        this.testerId = testerId;
    }

    public int getFixerId() {
        return fixerId;
    }

    public void setFixerId(int fixerId) {
        this.fixerId = fixerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
