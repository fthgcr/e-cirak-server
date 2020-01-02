package com.app.ecirak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.ecirak.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
