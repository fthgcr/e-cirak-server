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
@Table(name="s_city")
public class SCity {

	@Id
	@SequenceGenerator(name = "s_city_seq", sequenceName = "s_city_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "s_city_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String name;

	public SCity() {
		
	}
	
	@OneToMany(mappedBy = "city", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<School> school = new HashSet<>();
	
	@OneToMany(mappedBy = "SCity", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<Company> company = new HashSet<>();
	
	@OneToMany(mappedBy = "city", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<SDistrict> SDistricts = new HashSet<>();
	
	@OneToMany(mappedBy = "SCity", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<SUser> sUser = new HashSet<>();
	
	
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
