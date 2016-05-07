package com.sprsec.controller.issue;

import com.sprsec.service.issueService.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteIssueController
{
    @Autowired
    IssueService issueService;

    @RequestMapping(value = "/issue/delete/{id}", method = RequestMethod.GET)
    public String deleteIssueGet(@PathVariable("id") Integer id)
    {
        issueService.removeIssue(id);

        return "redirect:/profile";
    }
}
