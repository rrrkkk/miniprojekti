package com.j.tiimi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeContoller {

    @RequestMapping("/")
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

    @RequestMapping("/list")
    public String references() {
        return "references";
    }
}
