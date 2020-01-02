package com.app.ecirak.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="school")
public class School {
	
	@Id
	@SequenceGenerator(name = "school_seq", sequenceName = "school_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "school_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String address;	
	private String name;
	
	@Column(name="zip_code")
	private Integer zipCode;
	
	private Integer neighborhood_id;
	private Integer city_id;
	private Integer district_id;
	
	@OneToMany(mappedBy = "school", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<SUser> sUser = new HashSet<>();
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="city_id" , insertable=false ,updatable=false)
	private SCity city;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="district_id", insertable=false ,updatable=false)
	private SDistrict district;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="neighborhood_id", insertable=false ,updatable=false)
	private SNeighborhood neighborhood;
	
	
	public School() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public Integer getNeighborhood_id() {
		return neighborhood_id;
	}
	public void setNeighborhood_id(Integer neighborhood_id) {
		this.neighborhood_id = neighborhood_id;
	}
	public Integer getCity_id() {
		return city_id;
	}
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}
	public Integer getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(Integer district_id) {
		this.district_id = district_id;
	}

	
	
}
