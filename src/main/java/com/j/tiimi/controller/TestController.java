package com.j.tiimi.controller;

import java.util.ArrayList;
import com.j.tiimi.entity.*;
import com.j.tiimi.latex.LatexGenerator;
import com.j.tiimi.repository.ReferenceRepository;
import com.j.tiimi.service.ReferenceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String bibtex() {
        testInitLatex();
        String latex = referenceService.getBibtexString();
        System.out.println("latex : \n" + referenceService.getBibtexString());
        return latex;
    }
    
    //puts references to repo
    public void testInitLatex() {
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
    }
    
}
