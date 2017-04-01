package com.j.tiimi.repository;

import com.j.tiimi.entity.Attribute;
import com.j.tiimi.entity.Reference;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReferenceRepository extends JpaRepository<Reference, Long> {
    Reference findByType(String type);
}
