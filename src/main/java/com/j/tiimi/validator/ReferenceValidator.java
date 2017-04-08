package com.j.tiimi.validator;

import com.j.tiimi.entity.Reference;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by riku on 5.4.2017.
 */
public abstract class ReferenceValidator implements Validator {

    private Set<String> requiredKeys;
    private Set<String> optionalKeys;
    private Map<String, String> aliases;

    public Set<String> getRequiredKeys() {
        return requiredKeys;
    }

    public void setRequiredKeys(Set<String> requiredKeys) {
        this.requiredKeys = requiredKeys;
    }

    public Set<String> getOptionalKeys() {
        return optionalKeys;
    }

    public void setOptionalKeys(Set<String> optionalKeys) {
        this.optionalKeys = optionalKeys;
    }

    public void setAliases(Map<String, String> aliases) {
        this.aliases = aliases;
    }

    public Map<String, String> getAliases() {
        return aliases;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Reference.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Reference reference = (Reference) target;
        if (reference.getAttributes() == null) {
            errors.reject(reference.getType() + " reference should have attributes.");
            return;
        }

        Set<String> attributeKeys = reference
                .getAttributes()
                .stream()
                .map(a -> {
                    if (aliases.containsKey(a.getKey().toUpperCase())) {
                        return aliases.get(a.getKey().toUpperCase());
                    }
                    return a.getKey().toUpperCase();
                })
                .collect(Collectors.toSet());

        for (String requiredKey : requiredKeys) {
            if (!attributeKeys.contains(requiredKey)) {
                errors.reject("Field " + requiredKey + " is required.");
            }
        }

        attributeKeys.removeAll(requiredKeys);
        attributeKeys.removeAll(optionalKeys);

        if (!attributeKeys.isEmpty()) {
            for (String badKey : attributeKeys) {
                errors.reject(badKey + " isn't a valid field.");
            }
        }
    }

}
