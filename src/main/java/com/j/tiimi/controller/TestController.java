package com.j.tiimi.controller;

import com.j.tiimi.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {

    @Autowired
    private ReferenceRepository referenceRepository;

    @RequestMapping("*")
    @ResponseBody
    public String home() {
        return "Hello!";
    }

}
