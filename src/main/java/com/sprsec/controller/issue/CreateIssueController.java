package com.sprsec.controller.issue;

import com.sprsec.Helper.EmailSender;
import com.sprsec.dto.IssueDto;
import com.sprsec.model.Issue;
import com.sprsec.model.Project;
import com.sprsec.model.User;
import com.sprsec.model.enums.PriorityOfTheIssue;
import com.sprsec.service.issueService.IssueService;
import com.sprsec.service.projectService.ProjectService;
import com.sprsec.service.userService.UserService;
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
    public ModelAndView createIssueGet(@PathVariable("id") Integer id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        Project selectedProject = projectService.getProject(id);

        ModelAndView modelAndView = new ModelAndView("select-page");

        modelAndView.addObject("listOfUsers", selectedProject.getUsersInTheCurrentProject());

        return modelAndView;
    }*/

    @RequestMapping(value = "/issue/create", method = RequestMethod.GET)
    public ModelAndView createIssueGet1()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        ModelAndView modelAndView = new ModelAndView("issue/issue-create-page");

        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("dto", new IssueDto());
        modelAndView.addObject("userProjects", currentUser.getUserProjects());
        modelAndView.addObject("listOfPriority", new ArrayList<>(Arrays.asList(PriorityOfTheIssue.values())));
        modelAndView.addObject("listOfUsers", userService.listOfUsers());

        return modelAndView;
    }

    @RequestMapping(value = "/issue/create", method = RequestMethod.POST)
    public String createIssuePost(@ModelAttribute(value = "dto") IssueDto dto)
    {
        User fixer, tester;
        Project project = projectService.getProject(dto.getProjectId());
        fixer = userService.getUser(dto.getFixerId());
        tester = userService.getUser(dto.getTesterId());

        EmailSender emailSender = new EmailSender();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        Issue issue = new Issue();
        issue.setTitleOfIssue(dto.getTitle());
        issue.setDescription(dto.getDescription());
        issue.setPriority(PriorityOfTheIssue.valueOf(dto.getPriority()));
        issue.setProjectOfTheIssue(project);
        issue.setFixerOfTheIssue(fixer);
        issue.setTesterOfTheIssue(tester);
        issue.setCreatorOfIssue(currentUser);

        project.getIssuesSet().add(issue);
        fixer.getIssuesToFix().add(issue);
        tester.getIssuesToTest().add(issue);

        /*emailSender.send("Issue Tracker", "You have been assigned to issue <" + issue.getTitleOfIssue() + "> as fixer",
                fixer.getEmail());
        emailSender.send("Issue Tracker", "You have been assigned to issue <" + issue.getTitleOfIssue() + "> as tester",
                tester.getEmail());*/

        issueService.createIssue(issue);

        return "redirect:/profile";
    }
}
