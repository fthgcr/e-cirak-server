package com.app.ecirak.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="s_district")
public class SDistrict {
	
	@Id
	@SequenceGenerator(name = "s_district_seq", sequenceName = "s_district_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "s_district_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Integer city_id;
	
	public SDistrict() {
		
	}
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="city_id" , insertable=false, updatable=false)
	private SCity city;
	
	@OneToMany(mappedBy = "district", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<School> school = new HashSet<>();
	
	@OneToMany(mappedBy = "SDistrict", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<Company> company = new HashSet<>();
	
	@OneToMany(mappedBy = "district", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<SNeighborhood> sNeighborhood = new HashSet<>();
	
	@OneToMany(mappedBy = "SDistrict", orphanRemoval = true, cascade = CascadeType.ALL)
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
	public Integer getCity_id() {
		return city_id;
	}
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}
	
	
	

}
