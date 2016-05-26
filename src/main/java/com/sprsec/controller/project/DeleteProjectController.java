package com.sprsec.controller.project;

import com.sprsec.model.Project;
import com.sprsec.service.projectService.ProjectService;
import com.sprsec.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteProjectController
{
    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/project/delete/{id}", method = RequestMethod.GET)
    public String deleteProjectGet(@PathVariable("id") Integer id)
    {
        projectService.deleteProject(id);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/project/{idProject}/delete/user/{idUser}", method = RequestMethod.GET)
    public String removeUserFromProject(@PathVariable("idProject") Integer idProject, @PathVariable("idUser") Integer idUser)
    {
        Project project = projectService.getProject(idProject);
        project.getUsersInTheCurrentProject().remove(userService.getUser(idUser));

        projectService.updateProject(project);

        return "redirect:/project/inform/" + idProject;
    }
}
