package com.javamentor.revseev.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
//        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String showDeniedPage() {
        return "denied";
    }

}

