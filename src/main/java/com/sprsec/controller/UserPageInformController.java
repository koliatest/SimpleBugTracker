package com.sprsec.controller;

import com.sprsec.model.User;
import com.sprsec.model.enums.StatusOfTheIssue;
import com.sprsec.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserPageInformController
{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/inform/{id}", method = RequestMethod.GET)
    public ModelAndView userInformPageGet(@PathVariable("id") Integer id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        User userToLook = userService.getUser(id);

        ModelAndView modelAndView = new ModelAndView("user-page-inform");

        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("listOfProjects", userToLook.getUserProjects());
        modelAndView.addObject("userToLook", userToLook);

        modelAndView.addObject("countFixOfOpened", userToLook.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.OPENED)
                .count());
        modelAndView.addObject("countFixOfInProgress", userToLook.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.IN_PROGRESS)
                .count());
        modelAndView.addObject("countFixOfRejected", userToLook.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.REJECTED)
                .count());
        modelAndView.addObject("countFixOfDeferred", userToLook.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.DEFERRED)
                .count());
        modelAndView.addObject("countFixOfTest", userToLook.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.TEST)
                .count());
        modelAndView.addObject("countFixOfReopened", userToLook.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.REOPENED)
                .count());
        modelAndView.addObject("countFixOfVerified", userToLook.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.VERIFIED)
                .count());
        modelAndView.addObject("countFixOfClosed", userToLook.getIssuesToFix()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.CLOSED)
                .count());

        modelAndView.addObject("countTestOfOpened", userToLook.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.OPENED)
                .count());
        modelAndView.addObject("countTestOfInProgress", userToLook.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.IN_PROGRESS)
                .count());
        modelAndView.addObject("countTestOfRejected", userToLook.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.REJECTED)
                .count());
        modelAndView.addObject("countTestOfDeferred", userToLook.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.DEFERRED)
                .count());
        modelAndView.addObject("countTestOfTest", userToLook.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.TEST)
                .count());
        modelAndView.addObject("countTestOfReopened", userToLook.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.REOPENED)
                .count());
        modelAndView.addObject("countTestOfVerified", userToLook.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.VERIFIED)
                .count());
        modelAndView.addObject("countTestOfClosed", userToLook.getIssuesToTest()
                .stream()
                .filter(iss -> iss.getStatus() == StatusOfTheIssue.CLOSED)
                .count());

        return modelAndView;
    }
}
