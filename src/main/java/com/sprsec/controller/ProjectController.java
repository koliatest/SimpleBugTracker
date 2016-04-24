package com.sprsec.controller;

import com.sprsec.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController
{
    @RequestMapping(value = "/project/create", method = RequestMethod.GET)
    public ModelAndView createProject(Model model)
    {
        model.addAttribute("project", new Project());
        return new ModelAndView("project-create-page");
    }
}
