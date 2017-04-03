package com.j.tiimi.controller;

import java.util.ArrayList;
import com.j.tiimi.entity.*;
import com.j.tiimi.repository.ReferenceRepository;
import com.j.tiimi.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestController {

    @Autowired
    private ReferenceRepository referenceRepository;
    @Autowired
    private ReferenceService referenceService;

    @RequestMapping("*")
    @ResponseBody
    public String home() {
        return "Hello!";
    }

    //ei toimi :(
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String bibtex() {
        Reference reference = new Reference();
        reference.setType("Book");
        reference.setIdentifier("Martin09");
        ArrayList<Attribute> attributes = new ArrayList();
        attributes.add(new Attribute().setAttributes("author", "Martin, Robert"));
        attributes.add(new Attribute().setAttributes("title", "Clean Code: A Handbook of Agile Software Craftsmanship"));
        attributes.add(new Attribute().setAttributes("year", "2008"));
        attributes.add(new Attribute().setAttributes("publisher", "Prentice Hall"));
        reference.setAttributes(attributes);
        referenceService.createReference(reference);
        return referenceService.getBibtexString();
    }

}
