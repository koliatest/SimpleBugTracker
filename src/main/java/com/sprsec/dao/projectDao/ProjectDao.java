package com.sprsec.dao.projectDao;

import com.sprsec.model.Project;

import java.util.List;

public interface ProjectDao {
    public List<Project> listOfProjects();
    public List<Project> listOfProjectsByUser(Integer id);
    public void deleteUserFormProject(Integer id);
    public Project getProject(Integer id);
    public void createProject(Project project);
    public void updateProject(Project project);
    public void deleteProject(Integer id);
}
