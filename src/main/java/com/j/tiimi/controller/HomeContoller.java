package com.j.tiimi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeContoller {


    // Kesken

    @RequestMapping("/")
  //  @ResponseBody
    public String index() {
        return "index";
    }

    @RequestMapping("/book")
    public String book() {
        return "book-form";
    }

    @RequestMapping("/article")
    public String article() {
        return "article-form";
    }

    @RequestMapping("/inproceedings")
    public String inproceedings() {
        return "inproceedings-form";
    }

}
