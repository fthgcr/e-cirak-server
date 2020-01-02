package com.app.ecirak.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="s_role_permission")
public class SRolePermission {

	@Id
	@SequenceGenerator(name = "s_role_permission_seq", sequenceName = "s_role_permission_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "s_role_permission_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private Integer role_id;
	
	public SRolePermission() {
		
	}
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="role_id",insertable=false ,updatable=false)
	private SRole SRole;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	

}
