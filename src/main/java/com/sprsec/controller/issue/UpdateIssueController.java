package com.sprsec.controller.issue;

import com.sprsec.Helper.EmailSender;
import com.sprsec.dto.IssueDto;
import com.sprsec.model.Issue;
import com.sprsec.model.User;
import com.sprsec.model.enums.PriorityOfTheIssue;
import com.sprsec.service.issueService.IssueService;
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

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class UpdateIssueController
{
    @Autowired
    UserService userService;

    @Autowired
    IssueService issueService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/issue/update/{id}", method = RequestMethod.GET)
    public ModelAndView issueUpdateGet(@PathVariable("id") Integer id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        ModelAndView modelAndView = new ModelAndView("issue/issue-update-page");

        Issue currentIssue = issueService.getIssue(id);

        modelAndView.addObject("currentIssue", currentIssue);
        modelAndView.addObject("currentUser", currentUser);
        modelAndView.addObject("userProjects", currentUser.getUserProjects());
        modelAndView.addObject("listOfPriority", new ArrayList<>(Arrays.asList(PriorityOfTheIssue.values())));
        modelAndView.addObject("listOfUsers", userService.listOfUsers());
        modelAndView.addObject("dto", new IssueDto());

        return modelAndView;
    }

    @RequestMapping(value = "/issue/update/{id}", method = RequestMethod.POST)
    public String issueUpdatePost(@PathVariable("id") Integer id, @ModelAttribute(value = "dto") IssueDto dto)
    {
        Issue issue = issueService.getIssue(id);

        User fixer = userService.getUser(dto.getFixerId()),
                tester = userService.getUser(dto.getTesterId());

        EmailSender emailSender = new EmailSender();

        issue.setTitleOfIssue(dto.getTitle());
        issue.setDescription(dto.getDescription());
        issue.setPriority(PriorityOfTheIssue.valueOf(dto.getPriority()));
        issue.setFixerOfTheIssue(fixer);
        issue.setTesterOfTheIssue(tester);

        fixer.getIssuesToFix().removeIf(iss -> iss.getId() == issue.getId());
        fixer.getIssuesToFix().add(issue);

        tester.getIssuesToTest().removeIf(iss -> iss.getId() == issue.getId());
        tester.getIssuesToTest().add(issue);

        /*emailSender.send("Issue Tracker", "You have been assigned to issue <" + issue.getTitleOfIssue() + "> as fixer",
                fixer.getEmail());
        emailSender.send("Issue Tracker", "You have been assigned to issue <" + issue.getTitleOfIssue() + "> as tester",
                tester.getEmail());*/

        issueService.updateIssue(issue);

        return "redirect:/issue/inform/" + id;
    }
}
