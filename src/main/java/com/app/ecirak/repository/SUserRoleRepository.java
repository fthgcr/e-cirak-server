package com.app.ecirak.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ecirak.entity.SUserRole;




@Repository
@Transactional
public interface SUserRoleRepository extends JpaRepository<SUserRole, Integer> {
	
	
	
}
