package com.j.tiimi.validator;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by riku on 5.4.2017.
 */
@Component("inproceedings")
public class InproceedingsValidator extends ReferenceValidator {
    private static final Set<String> requiredKeys = new HashSet<>(Arrays.asList(
            "AUTHOR",
            "TITLE",
            "BOOKTITLE",
            "YEAR"
    ));

    private static final Set<String> optionalKeys = new HashSet<>(Arrays.asList(
            "EDITOR",
            "VOLUME",
            "SERIES",
            "PAGES",
            "ADDRESS",
            "MONTH",
            "ORGANIZATION",
            "PUBLISHER",
            "NOTE",
            "KEY"
    ));

    private static final Map<String, String> aliases = new HashMap<>();

    public InproceedingsValidator() {
       super.setOptionalKeys(optionalKeys);
       super.setRequiredKeys(requiredKeys);

       aliases.put("NUMBER", "VOLUME");

    }

}
