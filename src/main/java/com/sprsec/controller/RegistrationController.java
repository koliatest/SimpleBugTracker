package com.sprsec.controller;

import com.sprsec.model.User;
import com.sprsec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController
{
    private UserService userService;

    @Autowired
    RegistrationController(UserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration()
    {
        ModelAndView modelAndView = new ModelAndView("registration");

        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user)
    {
        this.userService.createUser(user);
        return "redirect:/login";
    }
}
