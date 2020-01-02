package com.app.ecirak.entity;

import java.util.HashSet;
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
@Table(name="property")
public class Property {

	@Id
	@SequenceGenerator(name = "property_seq", sequenceName = "property_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "property_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	
	public Property() {
		
	}

	@OneToMany(mappedBy="property",  orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<StudentProp> studentProps;
	
	@OneToMany(mappedBy = "property", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<CompanyReq> companyReq = new HashSet<>();
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
