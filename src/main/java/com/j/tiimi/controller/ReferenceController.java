package com.j.tiimi.controller;

import com.j.tiimi.entity.Reference;
import com.j.tiimi.service.ReferenceService;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.h2.util.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("reference")
public class ReferenceController {

    @Autowired
    ReferenceService referenceService;

    @Autowired
    Map<String, Validator> validators;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String bibtexText() {
        return referenceService.getBibtexString();
    }

    @RequestMapping(value = "/file"/*, method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE*/)
    public void bibtexFile(HttpSession session, HttpServletResponse response) throws Exception {
        try {
            File bibtexfile = referenceService.getBibtexFile();
            InputStream inputStream = new FileInputStream(bibtexfile);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=sigproc.bib");
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

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
