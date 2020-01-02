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
@Table(name="student_prop")
public class StudentProp {
	
	@Id
	@SequenceGenerator(name = "student_prop_seq", sequenceName = "student_prop_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "student_prop_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private Integer user_id;
	private Integer prop_id;
	
	
	public StudentProp() {
	
	}
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="prop_id" , insertable=false , updatable=false)
	private Property property;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="user_id",insertable=false , updatable=false)
	private SUser SUser;
	
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
	public Integer getProp_id() {
		return prop_id;
	}
	public void setProp_id(Integer prop_id) {
		this.prop_id = prop_id;
	}
	
	

}
