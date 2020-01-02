package com.app.ecirak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ecirak.entity.SRolePermission;




@Repository
@Transactional
public interface SRolePermissionRepository extends JpaRepository<SRolePermission, Integer> {
	
	
	
}
