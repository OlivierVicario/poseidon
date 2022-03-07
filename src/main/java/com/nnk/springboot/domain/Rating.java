package com.nnk.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rating")
public class Rating {
    // TODO: Map columns in data table RATING with corresponding java fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	@NotNull( message="Please enter a rating")
	@Column(name = "fitchRating")
	private String fitchRating;
	@NotNull( message="Please enter a rating")
	@Column(name = "moodysRating")
	private String moodysRating;
	@NotNull( message="Please enter an order")
	@Column(name = "orderNumber")
	private Integer orderNumber;
	@Column(name = "sandPRating")
	private String sandPRating;

	public Rating() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFitchRating() {
		return this.fitchRating;
	}

	public void setFitchRating(String fitchRating) {
		this.fitchRating = fitchRating;
	}

	public String getMoodysRating() {
		return this.moodysRating;
	}

	public void setMoodysRating(String moodysRating) {
		this.moodysRating = moodysRating;
	}

	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSandPRating() {
		return this.sandPRating;
	}

	public void setSandPRating(String sandPRating) {
		this.sandPRating = sandPRating;
	}

	public Rating( String moodysRating, String sandPRating, String fitchRating,Integer orderNumber) {
		super();
		this.fitchRating = fitchRating;
		this.moodysRating = moodysRating;
		this.orderNumber = orderNumber;
		this.sandPRating = sandPRating;
	}
	
}
