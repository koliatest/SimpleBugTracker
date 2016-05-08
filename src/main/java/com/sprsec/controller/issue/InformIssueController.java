package com.sprsec.controller.issue;

import com.sprsec.Helper.EmailSender;
import com.sprsec.dto.IssueDto;
import com.sprsec.model.ChangeOfState;
import com.sprsec.model.Issue;
import com.sprsec.model.User;
import com.sprsec.model.enums.StatusOfTheIssue;
import com.sprsec.service.changeOfStateService.ChangeOfStateService;
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
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class InformIssueController
{
    @Autowired
    UserService userService;

    @Autowired
    IssueService issueService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ChangeOfStateService changeOfStateService;

    @RequestMapping(value = "/issue/inform/{id}", method = RequestMethod.GET)
    public ModelAndView issueInformGet(@PathVariable("id") Integer id)
    {
        ModelAndView modelAndView = new ModelAndView("issue/issue-inform-page");

        Issue currentIssue = issueService.getIssue(id);

        List<ChangeOfState> listOfChanges = currentIssue.getChangeOfStatesSet();
        listOfChanges = listOfChanges.stream().distinct().collect(Collectors.toList());

        modelAndView.addObject("listOfChanges", listOfChanges);
        modelAndView.addObject("currentUser", getCurrentUser());
        modelAndView.addObject("currentIssue", currentIssue);
        modelAndView.addObject("listOfStatus", new ArrayList<>(Arrays.asList(StatusOfTheIssue.values())));
        modelAndView.addObject("dto", new IssueDto());

        return modelAndView;
    }

    @RequestMapping(value = "/issue/inform/{id}", method = RequestMethod.POST)
    public ModelAndView issueInformPost(@ModelAttribute(value = "dto") IssueDto dto, @PathVariable("id") Integer id)
    {
        Issue issue = issueService.getIssue(id);
        issue.setStatus(StatusOfTheIssue.valueOf(dto.getStatus()));

        issueService.updateIssue(issue);

        User fixer = issue.getFixerOfTheIssue(), tester = issue.getTesterOfTheIssue();

        ChangeOfState changeOfState = new ChangeOfState();
        changeOfState.setIssueOfState(issue);
        changeOfState.setBasicText(getCurrentUser().getFirstName() + " " + getCurrentUser().getLastName().charAt(0)
                + " changed the status to " + dto.getStatus());

        issue.getChangeOfStatesSet().add(changeOfState);
        changeOfStateService.createChangeOfState(changeOfState);

//        sendNotifications(StatusOfTheIssue.valueOf(dto.getStatus()), fixer, tester, issue);

        return new ModelAndView("redirect:/issue/inform/" + id);
    }

    private User getCurrentUser()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());
        return currentUser;
    }

    private void sendNotifications(StatusOfTheIssue statusOfTheIssue, User fixer, User tester, Issue issue)
    {
        EmailSender emailSender = new EmailSender();

        switch (statusOfTheIssue)
        {
            case REJECTED:
                emailSender.send("Issue tracker", "The issue <" + issue.getTitleOfIssue() + "> just changed status to " +
                                StatusOfTheIssue.REJECTED.toString(), tester.getEmail());
                break;
            case DEFERRED:
                emailSender.send("Issue tracker", "The issue <" + issue.getTitleOfIssue() + "> just changed status to " +
                        StatusOfTheIssue.DEFERRED.toString(), tester.getEmail());
                break;
            case TEST:
                emailSender.send("Issue tracker", "The issue <" + issue.getTitleOfIssue() + "> just changed status to " +
                        StatusOfTheIssue.TEST.toString(), tester.getEmail());
                break;
            case REOPENED:
                emailSender.send("Issue tracker", "The issue <" + issue.getTitleOfIssue() + "> just changed status to " +
                        StatusOfTheIssue.REOPENED.toString(), fixer.getEmail());
                break;
            case VERIFIED:
                emailSender.send("Issue tracker", "The issue <" + issue.getTitleOfIssue() + "> just changed status to " +
                        StatusOfTheIssue.VERIFIED.toString(), fixer.getEmail());
                break;
            case CLOSED:
                emailSender.send("Issue tracker", "The issue <" + issue.getTitleOfIssue() + "> just changed status to " +
                        StatusOfTheIssue.CLOSED.toString() + ". Well done!", fixer.getEmail());
                break;
        }
    }
}
