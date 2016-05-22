package com.sprsec.controller.project;

import com.sprsec.dto.ProjectDto;
import com.sprsec.model.Project;
import com.sprsec.model.User;
import com.sprsec.model.enums.StatusOfTheIssue;
import com.sprsec.service.projectService.ProjectService;
import com.sprsec.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InformProjectController
{
    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/project/inform/{id}", method = RequestMethod.GET)
    public ModelAndView informProjectGet(@PathVariable("id") Integer id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        Project currentProject = projectService.getProject(id);

        ModelAndView modelAndView = new ModelAndView("project/project-inform-page");

        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("currentProject", currentProject);
        modelAndView.addObject("listOfUsersInProject", currentProject.getUsersInTheCurrentProject());
        modelAndView.addObject("dto", new ProjectDto());

        modelAndView.addObject("currentUser", currentUser);

        modelAndView.addObject("countOfOpened", currentProject.getIssuesSet()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.OPENED)
                .count());
        modelAndView.addObject("countOfInProgress", currentProject.getIssuesSet()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.IN_PROGRESS)
                .count());
        modelAndView.addObject("countOfRejected", currentProject.getIssuesSet()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.REJECTED)
                .count());
        modelAndView.addObject("countOfDeferred", currentProject.getIssuesSet()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.DEFERRED)
                .count());
        modelAndView.addObject("countOfTest", currentProject.getIssuesSet()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.TEST)
                .count());
        modelAndView.addObject("countOfReopened", currentProject.getIssuesSet()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.REOPENED)
                .count());
        modelAndView.addObject("countOfVerified", currentProject.getIssuesSet()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.VERIFIED)
                .count());
        modelAndView.addObject("countOfClosed", currentProject.getIssuesSet()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.CLOSED)
                .count());

        return modelAndView;
    }

    @RequestMapping(value = "/project/inform/{id}", method = RequestMethod.POST)
    public String informProjectPost(@PathVariable("id") Integer id, @ModelAttribute(value = "dto") ProjectDto dto)
    {
        Project project = projectService.getProject(id);
        project.setNameOfTheProject(dto.getNameOfTheProject());
        project.setLeadOfTheProject(userService.getUser(dto.getLeadOfTheProject()));
        project.setDescriptionOfTheProject(dto.getDescriptionOfTheProject());
        String dtoLogins = dto.getUsersInTheCurrentProject();
        if(dtoLogins.length() > 0)
        {
            dtoLogins = dtoLogins.trim();
            String[] logins = dtoLogins.split(";");
            for (String login : logins)
            {
                project.getUsersInTheCurrentProject().add(userService.getUser(login.trim()));
            }
        }

        projectService.updateProject(project);

        return "redirect:/project/inform/" + id;
    }
}
