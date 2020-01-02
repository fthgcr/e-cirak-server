package com.app.ecirak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ecirak.entity.School;


@Repository
@Transactional
public interface SchoolRepository extends JpaRepository<School, Integer> {
	List<School> findByCity_id(Integer city_id);
	List<School> findByDistrict_id(Integer district_id);
	List<School> findByNeighborhood_id(Integer neighborhood_id);
	
	
}
