package com.sprsec.service.issueService;

import com.sprsec.dao.issueDao.IssueDao;
import com.sprsec.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {
    @Autowired
    private IssueDao issueDao;

    @Override
    public List<Issue> listOfIssues() {
        return issueDao.listOfIssues();
    }

    @Override
    public List<Issue> listOfIssuesOfProject(Integer id) {
        return issueDao.listOfIssuesOfProject(id);
    }

    @Override
    public List<Issue> listOfIssuesOfFixer(Integer id) {
        return issueDao.listOfIssuesOfFixer(id);
    }

    @Override
    public List<Issue> listOfIssuesOfTester(Integer id) {
        return issueDao.listOfIssuesOfTester(id);
    }

    @Override
    public Issue getIssue(Integer id) {
        return issueDao.getIssue(id);
    }

    @Override
    public void createIssue(Issue issue) {
        issueDao.createIssue(issue);
    }

    @Override
    public void updateIssue(Issue issue) {
        issueDao.updateIssue(issue);
    }

    @Override
    public void removeIssue(Integer id) {
        issueDao.removeIssue(id);
    }
}
