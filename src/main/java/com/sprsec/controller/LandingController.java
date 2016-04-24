package com.sprsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LandingController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView homePage() {
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
    public ModelAndView profilePage() {
        return new ModelAndView("profile-page");
    }
}
