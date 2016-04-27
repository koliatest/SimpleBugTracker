package com.sprsec.dao;

import com.sprsec.model.Project;

import java.util.List;

public interface ProjectDao {
    public List<Project> listOfProjects();
    public List<Project> listOfProjectsByUser(Integer id);
    public Project getProject(Integer id);
    public void createProject(Project project);
    public void updateProject(Project project);
    public void deleteProject(Integer id);
}
