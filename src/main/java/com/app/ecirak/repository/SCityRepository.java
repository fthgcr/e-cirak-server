package com.app.ecirak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ecirak.entity.SCity;

@Repository
@Transactional
public interface SCityRepository extends JpaRepository<SCity, Integer> {
	List<SCity> findByName(String name);
}
