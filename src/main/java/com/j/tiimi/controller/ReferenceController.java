package com.j.tiimi.controller;

import com.j.tiimi.entity.Reference;
import com.j.tiimi.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("reference")
public class ReferenceController {

    @Autowired
    ReferenceService referenceService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Reference> list() {
        return referenceService.listReferences();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Reference post(@RequestBody Reference reference) {
        return referenceService.createReference(reference);
    }
}
