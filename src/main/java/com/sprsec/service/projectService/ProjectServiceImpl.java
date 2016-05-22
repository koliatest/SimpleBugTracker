package com.sprsec.service.projectService;

import com.sprsec.dao.projectDao.ProjectDao;
import com.sprsec.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> listOfProjects() {
        return projectDao.listOfProjects();
    }

    @Override
    public List<Project> listOfProjectsByUser(Integer id){
        return projectDao.listOfProjectsByUser(id);
    }

    @Override
    public void deleteUserFormProject(Integer id)
    {
        projectDao.deleteUserFormProject(id);
    }

    @Override
    public Project getProject(Integer id) {
        return projectDao.getProject(id);
    }

    @Override
    public void createProject(Project project) {
        projectDao.createProject(project);
    }

    @Override
    public void updateProject(Project project) {
        projectDao.updateProject(project);
    }

    @Override
    public void deleteProject(Integer id) {
        projectDao.deleteProject(id);
    }
}
