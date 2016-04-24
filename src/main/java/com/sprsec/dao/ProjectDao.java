package com.sprsec.dao;

import com.sprsec.model.Project;

import java.util.List;

/**
 * Created by Oleg on 19.01.2015.
 */
public interface ProjectDao {
    public List<Project> listOfProjects();
    public List<Project> listOfProjectsByUser(Long id);
    public Project getProject(Long id);
    public void createProject(Project project);
    public void updateProject(Project project);
    public void deleteProject(Long id);
}
