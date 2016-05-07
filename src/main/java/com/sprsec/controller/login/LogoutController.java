package com.sprsec.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

    @RequestMapping(value = "/auth/logout")
    public String auth(){
        return "redirect:/";
    }
}
