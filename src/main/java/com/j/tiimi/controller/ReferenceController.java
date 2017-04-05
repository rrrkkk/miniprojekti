package com.j.tiimi.controller;

import com.j.tiimi.entity.Reference;
import com.j.tiimi.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("reference")
public class ReferenceController {

    @Autowired
    ReferenceService referenceService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String bibtex() {
        return referenceService.getBibtexString();
    }

    /* Maybe better way to do it, dunno...
    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<String> bibtex() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new HttpEntity<>(referenceService.getBibtexString(), responseHeaders);
    }
    */

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Reference post(@RequestBody Reference reference) {
        return referenceService.createReference(reference);
    }
}
