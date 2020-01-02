package com.app.ecirak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ecirak.entity.SNeighborhood;

@Repository
@Transactional
public interface SNeighborhoodRepository extends JpaRepository<SNeighborhood, Integer> {
	
	List<SNeighborhood> findByDistrict_id(Integer district_id);
	List<SNeighborhood> findByName(String name);
	
}
