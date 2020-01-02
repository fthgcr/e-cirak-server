package com.app.ecirak.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "s_role")
public class SRole {
	
	@Id
	@SequenceGenerator(name = "s_role_seq", sequenceName = "s_role_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "s_role_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "role_name")
	private String roleName;
	
	@OneToMany(mappedBy = "SRole", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<SUserRole> sUserRole = new HashSet<>();
	
	@OneToMany(mappedBy = "SRole", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<SRolePermission> sRolePermission = new HashSet<>();
	
	public SRole() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
