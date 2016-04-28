package com.sprsec.service.issueService;

import com.sprsec.model.Issue;

import java.util.List;

public interface IssueService {
    public List<Issue> listOfIssues();
    public List<Issue> listOfIssuesOfProject(Integer id);
    public List<Issue> listOfIssuesOfFixer(Integer id);
    public List<Issue> listOfIssuesOfTester(Integer id);
    public Issue getIssue(Integer id);
    public void createIssue(Issue issue);
    public void updateIssue(Issue issue);
    public void removeIssue(Integer id);
}
