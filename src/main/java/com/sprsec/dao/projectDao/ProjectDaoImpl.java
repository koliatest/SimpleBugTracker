package com.sprsec.dao.projectDao;

import com.sprsec.model.Project;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Project> listOfProjects() {
        return (List)openSession().createQuery("from Project").list();
    }

    private Session openSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<Project> listOfProjectsByUser(Integer id){
        Query query = openSession().createQuery
                ("select p from Project p where p.leadOfTheProject = :id");
        query.setString("id", id.toString());
        return query.list();
    }

    @Override
    @Transactional
    public Project getProject(Integer id) {
        return (Project) openSession().get(Project.class, id);
    }

    @Override
    @Transactional
    public void createProject(Project project) {
        openSession().save(project);
    }

    @Override
    @Transactional
    public void updateProject(Project project) {
        openSession().update(project);
    }

    @Override
    @Transactional
    public void deleteProject(Integer id) {
        openSession().delete(getProject(id));
    }
}
