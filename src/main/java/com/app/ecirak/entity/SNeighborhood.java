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
@Table(name="s_neighborhood")
public class SNeighborhood {
	
	@Id
	@SequenceGenerator(name = "s_neighborhood_seq", sequenceName = "s_neighborhood_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "s_neighborhood_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Integer district_id;
	
	public SNeighborhood() {
		
	}
	
	@OneToMany(mappedBy = "neighborhood", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<School> school = new HashSet<>();
	
	@OneToMany(mappedBy = "SNeighborhood", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<SUser> sUser = new HashSet<>();
	
	@OneToMany(mappedBy = "SNeighborhood", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<Company> company = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="district_id", insertable=false ,updatable=false)
	private SDistrict district;
	
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
	public Integer getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(Integer district_id) {
		this.district_id = district_id;
	}
	
	
}
