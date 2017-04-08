package com.j.tiimi.validator;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by riku on 5.4.2017.
 */
@Component("article")
public class ArticleValidator extends ReferenceValidator {
    private static final Set<String> requiredKeys = new HashSet<>(Arrays.asList(
            "AUTHOR",
            "TITLE",
            "JOURNAL",
            "YEAR",
            "VOLUME"
    ));

    private static final Set<String> optionalKeys = new HashSet<>(Arrays.asList(
            "NUMBER",
            "PAGES",
            "MONTH",
            "NOTE",
            "KEY"
    ));

    private static final Map<String, String> aliases = new HashMap<>();

    public ArticleValidator() {
        super.setRequiredKeys(requiredKeys);
        super.setOptionalKeys(optionalKeys);
        super.setAliases(aliases);
    }

}
