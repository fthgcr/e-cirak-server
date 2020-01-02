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
@Table(name="s_user_role")
public class SUserRole {

	@Id
	@SequenceGenerator(name = "s_user_role_seq", sequenceName = "s_user_role_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "s_user_role_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private Integer user_id;
	private Integer role_id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="role_id", insertable=false ,updatable=false)
	private SRole SRole;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="user_id", insertable=false ,updatable=false)
	private SUser SUser;
		
	public SUserRole() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	
}
