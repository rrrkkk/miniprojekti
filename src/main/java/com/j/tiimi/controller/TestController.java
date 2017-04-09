package com.j.tiimi.controller;

import java.util.ArrayList;
import com.j.tiimi.entity.*;
import com.j.tiimi.repository.ReferenceRepository;
import com.j.tiimi.service.ReferenceService;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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
    public String bibtex() throws IOException {
        testInitLatex();
        String latex = referenceService.getBibtexString();
        System.out.println("\n\nlatex : \n\n" + latex);
        System.out.println("----------------------------\n\n");
        String bibtex = readFile(referenceService.getBibtexFile());
        System.out.println("bibtex: \n\n" + bibtex);
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
 
    private String readFile(File file) throws IOException {
        Scanner reader = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        
        while (reader.hasNextLine()) {
            sb.append(reader.nextLine() + "\n"); //nextLine syö rivinvaihdot >_>
        }
        
        reader.close();
        return sb.toString();
    }
    
}
