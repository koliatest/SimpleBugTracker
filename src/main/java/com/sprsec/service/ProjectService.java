package com.sprsec.service;

import com.sprsec.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public List<Project> listOfProjects();
    public List<Project> listOfProjectsByUser(Long id);
    public Project getProject(Long id);
    public void createProject(Project project);
    public void updateProject(Project project);
    public void deleteProject(Long id);
}
