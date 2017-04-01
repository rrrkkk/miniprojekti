package com.j.tiimi.service;

import com.j.tiimi.entity.Attribute;
import com.j.tiimi.entity.Reference;
import com.j.tiimi.repository.AttributeRepository;
import com.j.tiimi.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceService {

    @Autowired
    ReferenceRepository referenceRepository;
    @Autowired
    AttributeRepository attributeRepository;

    public Reference createReference(Reference reference) {
        List<Attribute> attributes = reference.getAttributes();
        attributeRepository.save(attributes);

        return referenceRepository.save(reference);
    }

    public List<Reference> listReferences() {
        return referenceRepository.findAll();
    }
}
