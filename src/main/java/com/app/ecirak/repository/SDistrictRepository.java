package com.app.ecirak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ecirak.entity.SDistrict;

@Repository
@Transactional
public interface SDistrictRepository extends JpaRepository<SDistrict, Integer> {
	
	List<SDistrict> findByCity_id(Integer city_id);
	List<SDistrict> findByName(String name);	
}
