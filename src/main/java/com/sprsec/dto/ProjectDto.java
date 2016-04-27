package com.sprsec.dto;


import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProjectDto {

    private int id;

    private String nameOfTheProject;

    private String descriptionOfTheProject;

    private int leadOfTheProject;

    private int[] issues;

    private int[] usersInTheCurrentProject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfTheProject() {
        return nameOfTheProject;
    }

    public void setNameOfTheProject(String nameOfTheProject) {
        this.nameOfTheProject = nameOfTheProject;
    }

    public String getDescriptionOfTheProject() {
        return descriptionOfTheProject;
    }

    public void setDescriptionOfTheProject(String descriptionOfTheProject) {
        this.descriptionOfTheProject = descriptionOfTheProject;
    }

    public int getLeadOfTheProject() {
        return leadOfTheProject;
    }

    public void setLeadOfTheProject(int leadOfTheProject) {
        this.leadOfTheProject = leadOfTheProject;
    }

    public int[] getIssues() {
        return issues;
    }

    public void setIssues(int[] issues) {
        this.issues = issues;
    }

    public int[] getUsersInTheCurrentProject() {
        return usersInTheCurrentProject;
    }

    public void setUsersInTheCurrentProject(int[] usersInTheCurrentProject) {
        this.usersInTheCurrentProject = usersInTheCurrentProject;
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "nameOfTheProject='" + nameOfTheProject + '\'' +
                ", leadOfTheProject=" + leadOfTheProject +
                ", issues=" + Arrays.toString(issues) +
                '}';
    }
}
