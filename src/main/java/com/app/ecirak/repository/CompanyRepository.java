package com.app.ecirak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ecirak.entity.Company;


@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	
	
}
