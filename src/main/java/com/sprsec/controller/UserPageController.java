package com.sprsec.controller;

import com.sprsec.model.User;
import com.sprsec.model.enums.StatusOfTheIssue;
import com.sprsec.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserPageController
{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView userPageGet()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        ModelAndView modelAndView = new ModelAndView("user-page");

        modelAndView.addObject("currentUser", currentUser);

        modelAndView.addObject("countFixOfOpened", currentUser.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.OPENED)
                .count());
        modelAndView.addObject("countFixOfInProgress", currentUser.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.IN_PROGRESS)
                .count());
        modelAndView.addObject("countFixOfRejected", currentUser.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.REJECTED)
                .count());
        modelAndView.addObject("countFixOfDeferred", currentUser.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.DEFERRED)
                .count());
        modelAndView.addObject("countFixOfTest", currentUser.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.TEST)
                .count());
        modelAndView.addObject("countFixOfReopened", currentUser.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.REOPENED)
                .count());
        modelAndView.addObject("countFixOfVerified", currentUser.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.VERIFIED)
                .count());
        modelAndView.addObject("countFixOfClosed", currentUser.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.CLOSED)
                .count());

        modelAndView.addObject("countTestOfOpened", currentUser.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.OPENED)
                .count());
        modelAndView.addObject("countTestOfInProgress", currentUser.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.IN_PROGRESS)
                .count());
        modelAndView.addObject("countTestOfRejected", currentUser.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.REJECTED)
                .count());
        modelAndView.addObject("countTestOfDeferred", currentUser.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.DEFERRED)
                .count());
        modelAndView.addObject("countTestOfTest", currentUser.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.TEST)
                .count());
        modelAndView.addObject("countTestOfReopened", currentUser.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.REOPENED)
                .count());
        modelAndView.addObject("countTestOfVerified", currentUser.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.VERIFIED)
                .count());
        modelAndView.addObject("countTestOfClosed", currentUser.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.CLOSED)
                .count());

        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String userPagePost(@ModelAttribute("user") User user)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());

        userService.updateUser(currentUser);

        return "redirect:/user";
    }
}
