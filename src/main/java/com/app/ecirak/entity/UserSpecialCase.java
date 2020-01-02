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
@Table(name="user_special_case")
public class UserSpecialCase {

	@Id
	@SequenceGenerator(name = "user_special_case_seq", sequenceName = "user_special_case_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "user_special_case_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private Integer case_id;
	private Integer user_id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="case_id" , insertable=false ,updatable=false)
	private SpecialCase specialCase;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="user_id", insertable=false ,updatable=false)
	private SUser SUser;
	
	public UserSpecialCase() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCase_id() {
		return case_id;
	}
	public void setCase_id(Integer case_id) {
		this.case_id = case_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	

	
}
