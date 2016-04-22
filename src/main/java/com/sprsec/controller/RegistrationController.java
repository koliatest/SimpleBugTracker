package com.sprsec.controller;

import com.sprsec.model.User;
import com.sprsec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView registration(Model model)
    {
        model.addAttribute("user", new User());
        return new ModelAndView("registration");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("user") User user)
    {
        this.userService.addUser(user);
        return new ModelAndView("redirect:/index.html");
    }
}
