package com.javamentor.revseev.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("login");
//        new ModelAndView("fancy-login");
    }

    @GetMapping("/access-denied")
    public ModelAndView showDeniedPage() {
        return new ModelAndView("denied");
    }

}

