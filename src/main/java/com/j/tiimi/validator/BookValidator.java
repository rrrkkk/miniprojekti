package com.j.tiimi.validator;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

/**
 * Created by riku on 5.4.2017.
 */
@Component("book")
public class BookValidator extends ReferenceValidator {
    private static final Set<String> requiredKeys =
            new HashSet<>(Arrays.asList(
                    "AUTHOR",
                    "TITLE",
                    "PUBLISHER",
                    "YEAR"
            ));

    private static final Set<String> optionalKeys =
            new HashSet<>(Arrays.asList(
                    "VOLUME",
                    "SERIES",
                    "ADDRESS",
                    "EDITION",
                    "MONTH",
                    "NOTE",
                    "KEY"
            ));

    private static final Map<String, String> aliases = new HashMap<>();

    public BookValidator() {
        super.setRequiredKeys(requiredKeys);
        super.setOptionalKeys(optionalKeys);

        aliases.put("EDITOR", "AUTHOR");
        aliases.put("NUMBER", "VOLUME");
        super.setAliases(aliases);
    }

}
