package com.j.tiimi.controller;

import com.j.tiimi.entity.Reference;
import com.j.tiimi.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("reference")
public class ReferenceController {

    @Autowired
    ReferenceService referenceService;

    @Autowired
    Map<String, Validator> validators;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Reference> list() {
        return referenceService.listReferences();
        //return referenceService.getBibtexString(); TÄÄ!
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> post(@Valid @RequestBody Reference reference, BindingResult result) {

        if (validators.containsKey(reference.getType().toLowerCase())) {
            validators.get(reference.getType()).validate(reference, result);
        } else {
            result.reject(reference.getType() + " isn't a valid reference type.");
        }

        if (result.hasErrors()) {
            // tää on vaan esimerkki.
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(e -> e.getCode())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok(referenceService.createReference(reference));
    }
}
