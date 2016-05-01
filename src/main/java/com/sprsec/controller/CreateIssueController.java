package com.sprsec.controller;

import com.sprsec.Helper.EmailSender;
import com.sprsec.dto.IssueDto;
import com.sprsec.model.Issue;
import com.sprsec.model.Project;
import com.sprsec.model.User;
import com.sprsec.model.enums.PriorityOfTheIssue;
import com.sprsec.service.ProjectService;
import com.sprsec.service.UserService;
import com.sprsec.service.issueService.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class CreateIssueController
{
    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    IssueService issueService;

    /*@RequestMapping(value = "/issue/create/project/{id}", method = RequestMethod.GET)
    public ModelAndView createIssueGet(Map<String, Object> map, @PathVariable("id") Integer id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        Project selectedProject = projectService.getProject(id);

        map.put("dto", new IssueDto());
        map.put("userProjects", currentUser.getUserProjects());
        map.put("listOfPriority", new ArrayList<>(Arrays.asList(PriorityOfTheIssue.values())));
        map.put("listOfUsers", selectedProject.getUsersInTheCurrentProject());

        return new ModelAndView("issue-create-page");
    }*/

    @RequestMapping(value = "/issue/create", method = RequestMethod.GET)
    public ModelAndView createIssueGet1(Map<String, Object> map)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        map.put("dto", new IssueDto());
        map.put("userProjects", currentUser.getUserProjects());
        map.put("listOfPriority", new ArrayList<>(Arrays.asList(PriorityOfTheIssue.values())));
        map.put("listOfUsers", userService.listOfUsers());

        return new ModelAndView("issue-create-page");
    }

    @RequestMapping(value = "/issue/create", method = RequestMethod.POST)
    public ModelAndView createIssuePost(@ModelAttribute(value = "dto") IssueDto dto)
    {
        User fixer, tester;
        Project project = projectService.getProject(dto.getProjectId());
        fixer = userService.getUser(dto.getFixerId());
        tester = userService.getUser(dto.getTesterId());

        EmailSender emailSender = new EmailSender();

        Issue issue = new Issue();
        issue.setTitleOfIssue(dto.getTitle());
        issue.setDescription(dto.getDescription());
        issue.setPriority(PriorityOfTheIssue.valueOf(dto.getPriority()));
        issue.setProjectOfTheIssue(project);
        issue.setFixerOfTheIssue(fixer);
        issue.setTesterOfTheIssue(tester);

        project.getIssuesSet().add(issue);
        fixer.getIssuesToFix().add(issue);
        tester.getIssuesToTest().add(issue);

        /*emailSender.send("Issue Tracker", "You have been assigned to issue <" + issue.getTitleOfIssue() + "> as fixer",
                fixer.getEmail());
        emailSender.send("Issue Tracker", "You have been assigned to issue <" + issue.getTitleOfIssue() + "> as tester",
                tester.getEmail());*/

        issueService.createIssue(issue);

        return new ModelAndView("redirect:/profile");
    }
}
