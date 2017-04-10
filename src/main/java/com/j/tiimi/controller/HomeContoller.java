package com.j.tiimi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeContoller {


    // Kesken

    @RequestMapping("/")
    public String home() {
        return "form";
    }
}
