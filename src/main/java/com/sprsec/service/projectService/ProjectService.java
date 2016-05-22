package com.sprsec.service.projectService;

import com.sprsec.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public List<Project> listOfProjects();
    public List<Project> listOfProjectsByUser(Integer id);
    public void deleteUserFormProject(Integer id);
    public Project getProject(Integer id);
    public void createProject(Project project);
    public void updateProject(Project project);
    public void deleteProject(Integer id);
}
