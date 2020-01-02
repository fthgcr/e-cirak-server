package com.app.ecirak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ecirak.entity.SUser;

@Repository
@Transactional
public interface SUserRepository extends JpaRepository<SUser, Integer> {
	List<SUser> findByType(String type);
}
