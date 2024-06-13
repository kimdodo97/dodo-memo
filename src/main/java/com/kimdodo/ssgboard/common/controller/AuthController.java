package com.kimdodo.ssgboard.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @GetMapping("/auth/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/auth/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/auth/login")
    public void login(){

    }
}
