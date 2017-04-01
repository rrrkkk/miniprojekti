package com.j.tiimi.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Reference extends AbstractPersistable<Long> {

    @OneToMany
    private List<Attribute> attributes;

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public void addAttribute(String key, String value) {
        if (attributes == null) {
            attributes = new ArrayList();
        }

        Attribute attribute = new Attribute();
        attribute.setKey(key);
        attribute.setValue(value);
        attributes.add(attribute);
    }

    public void addAttribute(Attribute attribute) {
        if (attributes == null) {
            attributes = new ArrayList();
        }

        attributes.add(attribute);
    }

    @Override
    public String toString() {
        String presentation = "type: " + type + "\n";
        for (Attribute a : attributes) {
            presentation += "key: " + a.getKey() + " value: " + a.getValue() + "\n";
        }
        return presentation;
    }
}
