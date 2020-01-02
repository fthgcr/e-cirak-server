package com.app.ecirak.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="special_case")
public class SpecialCase {
	
	@Id
	@SequenceGenerator(name = "special_case_seq", sequenceName = "special_case_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "special_case_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String value;
	
	
	public SpecialCase() {
		
	}
	
	@OneToMany(mappedBy="specialCase", cascade=CascadeType.ALL,orphanRemoval = true)
	private Set<UserSpecialCase> userSpecialCases;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
