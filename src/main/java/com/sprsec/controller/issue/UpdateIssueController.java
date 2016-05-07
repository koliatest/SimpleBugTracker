package com.sprsec.controller.issue;

/*@Controller
public class UpdateIssueController
{
    @Autowired
    UserService userService;

    @Autowired
    IssueService issueService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/issue/update/{id}", method = RequestMethod.GET)
    ModelAndView issueUpdateGet(Map<String, Object> map, @PathVariable("id") Integer id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUser(auth.getName());

        map.put("currentUser", currentUser);

        return new ModelAndView("issue-update-page");
    }

    @RequestMapping(value = "/issue/update", method = RequestMethod.POST)
    ModelAndView issueUpdatePost()
    {

        return new ModelAndView("redirect:/issue/update/" + id);
    }
}*/
