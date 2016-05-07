package com.sprsec.controller.project;

import com.sprsec.model.Issue;
import com.sprsec.model.Project;
import com.sprsec.model.User;
import com.sprsec.model.enums.StatusOfTheIssue;
import com.sprsec.service.projectService.ProjectService;
import com.sprsec.service.userService.UserService;
import com.sprsec.service.issueService.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SelectProjectController
{
    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    IssueService issueService;

    @RequestMapping(value = "/profile/project/{id}", method = RequestMethod.GET)
    public ModelAndView selectProjectGet(@PathVariable("id") Integer id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        Project selectedProject = projectService.getProject(id);

        List<Issue> listOfIssues = issueService.listOfIssuesOfProject(selectedProject.getId());
        listOfIssues.removeIf(issue -> (issue.getFixerOfTheIssue().getId() != currentUser.getId()
                && issue.getTesterOfTheIssue().getId() != currentUser.getId()) || issue.getStatus() == StatusOfTheIssue.CLOSED );

        ModelAndView modelAndView = new ModelAndView("profile-page");

        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("listOfIssues", listOfIssues);
        modelAndView.addObject("listOfProjects", currentUser.getUserProjects());
        modelAndView.addObject("selectedProjectName", new String(selectedProject.getNameOfTheProject()));

        return modelAndView;
    }
}
