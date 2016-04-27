package com.sprsec.controller;

import com.sprsec.dto.ProjectDto;
import com.sprsec.model.Project;
import com.sprsec.model.User;
import com.sprsec.service.ProjectService;
import com.sprsec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ProjectController
{
    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project/create", method = RequestMethod.GET)
    public ModelAndView createProjectGet(Map<String, Object> map)
    {
        map.put("dto", new ProjectDto());
        map.put("userList", userService.listOfUsers());
        map.put("user", new User());
        return new ModelAndView("project-create-page");
    }

    @RequestMapping(value = "/project/create", method = RequestMethod.POST)
    public ModelAndView createProjectPost(@ModelAttribute(value = "dto") ProjectDto dto)
    {
        Project project = new Project();
        project.setNameOfTheProject(dto.getNameOfTheProject());
        project.setDescriptionOfTheProject(dto.getDescriptionOfTheProject());
        project.setLeadOfTheProject(userService.getUser(dto.getLeadOfTheProject()));
        projectService.createProject(project);
        return new ModelAndView("project-create-page");
    }
}
