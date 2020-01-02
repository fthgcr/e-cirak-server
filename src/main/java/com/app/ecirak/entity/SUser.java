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
@Table(name="s_user")
public class SUser {
	
	@Id
	@SequenceGenerator(name = "s_user_seq", sequenceName = "s_user_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "s_user_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String address;

	@Column(name="identity_number")
	private Long identityNumber;

	private String mail;

	@Column(name="name_surname")
	private String nameSurname;

	private Long phone;
	private String username;
	private Integer neighborhood_id;
	private Integer city_id;
	private Integer district_id;
	private Integer school_id;
	private Integer company_id;
	private String type;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="company_id" , insertable=false , updatable=false )
	private Company company;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="city_id" , insertable=false , updatable=false)
	private SCity SCity;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="district_id", insertable=false , updatable=false)
	private SDistrict SDistrict;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="neighborhood_id", insertable=false , updatable=false)
	private SNeighborhood SNeighborhood;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="school_id", insertable=false , updatable=false)
	private School school;
	
	@OneToMany(mappedBy = "SUser", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<SUserRole> sUserRole = new HashSet<>();
	
	@OneToMany(mappedBy = "SUser", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<StudentProp> studentProp = new HashSet<>();
	
	@OneToMany(mappedBy = "SUser", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<UserSpecialCase> userSpecialCases;
	
	@OneToMany(mappedBy="SUser2",  orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<UserExperience> userExperiences2;
	
	@OneToMany(mappedBy="SUser1",  orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<UserExperience> userExperiences1;
	
	
	public SUser() {
		
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
	public Long getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(Long identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNameSurname() {
		return nameSurname;
	}
	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	

}
