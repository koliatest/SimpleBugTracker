package com.sprsec.dao.issueDao;

import com.sprsec.model.Issue;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class IssueDaoImpl implements IssueDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<Issue> listOfIssues() {
        return (List)openSession().createQuery("from Issue").list();
    }

    @Override
    @Transactional
    public List<Issue> listOfIssuesOfProject(Integer id){
        Query query = openSession().createQuery
                ("select i from Issue i where i.projectOfTheIssue = :id");
        query.setString("id", id.toString());
        return query.list();
    }

    @Override
    @Transactional
    public List<Issue> listOfIssuesOfFixer(Integer id){
        Query query = openSession().createQuery
                ("select i from Issue i where i.fixerOfTheIssue = :id");
        query.setString("id", id.toString());
        return query.list();
    }

    @Override
    @Transactional
    public List<Issue> listOfIssuesOfTester(Integer id){
        Query query = openSession().createQuery
                ("select i from Issue i where i.testerOfTheIssue = :id");
        query.setString("id", id.toString());
        return query.list();
    }

    @Override
    @Transactional
    public Issue getIssue(Integer id) {
        return (Issue) openSession().get(Issue.class, id);
    }

    @Override
    @Transactional
    public void createIssue(Issue issue) {
        openSession().save(issue);
    }

    @Override
    @Transactional
    public void updateIssue(Issue issue) {
        openSession().update(issue);
    }

    @Override
    @Transactional
    public void removeIssue(Integer id) {
        openSession().delete(getIssue(id));
    }
}

