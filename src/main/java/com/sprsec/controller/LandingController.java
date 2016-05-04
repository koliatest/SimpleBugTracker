package com.sprsec.controller;

import com.sprsec.model.Issue;
import com.sprsec.model.User;
import com.sprsec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class LandingController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView homePage()
    {
        return new ModelAndView("landing-page");
    }

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public ModelAndView indexPage() {
        return new ModelAndView("landing-page");
    }

    @RequestMapping(value="/about", method=RequestMethod.GET)
    public ModelAndView aboutPage() {
        return new ModelAndView("about-page");
    }

    @RequestMapping(value="/profile", method=RequestMethod.GET)
    public ModelAndView profilePage(Map<String, Object> map) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());
        Set<Issue> listOfIssues = new HashSet<>(currentUser.getIssuesToFix());
        listOfIssues.addAll(currentUser.getIssuesToTest());
        map.put("currentUser", currentUser);
        map.put("listOfIssues", listOfIssues);
        map.put("listOfProjects", currentUser.getUserProjects());
        map.put("selectedProjectName", new String("All Projects"));
        return new ModelAndView("profile-page");
    }
}
