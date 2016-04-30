package com.sprsec.controller;

import com.sprsec.model.Issue;
import com.sprsec.model.Project;
import com.sprsec.model.User;
import com.sprsec.service.ProjectService;
import com.sprsec.service.UserService;
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
import java.util.Map;

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
    public ModelAndView selectProjectGet(Map<String, Object> map, @PathVariable("id") Integer id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        Project selectedProject = projectService.getProject(id);

        List<Issue> listOfIssues = issueService.listOfIssuesOfProject(selectedProject.getId());
        /*for (Issue issue : listOfIssues)
        {
            if(issue.getFixerOfTheIssue().getId() != currentUser.getId()
                    && issue.getTesterOfTheIssue().getId() != currentUser.getId())
            {
                listOfIssues.remove(issue);
            }
        }*/
        listOfIssues.removeIf(issue -> issue.getFixerOfTheIssue().getId() != currentUser.getId()
                && issue.getTesterOfTheIssue().getId() != currentUser.getId());

        map.put("listOfIssues", listOfIssues);
        map.put("listOfProjects", currentUser.getUserProjects());
        map.put("selectedProjectName", new String(selectedProject.getNameOfTheProject()));

        return new ModelAndView("profile-page");
    }
}
