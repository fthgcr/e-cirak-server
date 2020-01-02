package com.app.ecirak.entity;

import java.sql.Date;

import javax.persistence.Column;
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
@Table(name="company_req")
public class CompanyReq {
	
	@Id
	@SequenceGenerator(name = "company_req_seq", sequenceName = "company_req_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "company_req_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name="date_time" )
	private Date dateTime;

	@Column(name="user_id")
	private Integer userId;
	
	private Integer property_id;
	private Integer company_id;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="company_id" , insertable=false ,updatable=false)
	private Company company;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="property_id" , insertable=false ,updatable=false)	
	private Property property;
	
	public CompanyReq() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProperty_id() {
		return property_id;
	}
	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	
	
	
}
