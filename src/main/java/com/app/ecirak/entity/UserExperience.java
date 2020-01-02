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
@Table(name="user_experience")
public class UserExperience {
	
	@Id
	@SequenceGenerator(name = "user_experience_seq", sequenceName = "user_experience_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(generator = "user_experience_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name="company_reviews")
	private String companyReviews;

	@Column(name="finish_date")
	private Date finishDate;

	@Column(name="start_date")
	private Date startDate;
	
	private Integer user_id;
	private Integer related_user_id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="related_user_id", insertable=false ,updatable=false)
	private SUser SUser1;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="user_id", insertable=false ,updatable=false)
	private SUser SUser2;
	
	public UserExperience() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyReviews() {
		return companyReviews;
	}
	public void setCompanyReviews(String companyReviews) {
		this.companyReviews = companyReviews;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getRelated_user_id() {
		return related_user_id;
	}
	public void setRelated_user_id(Integer related_user_id) {
		this.related_user_id = related_user_id;
	}
	
	

}
