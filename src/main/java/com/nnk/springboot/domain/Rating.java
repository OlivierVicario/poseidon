package com.nnk.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {
    // TODO: Map columns in data table RATING with corresponding java fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String fitchRating;

	private String moodysRating;

	private int orderNumber;

	private String sandPRating;

	public Rating() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public int getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSandPRating() {
		return this.sandPRating;
	}

	public void setSandPRating(String sandPRating) {
		this.sandPRating = sandPRating;
	}

	public Rating( String moodysRating, String sandPRating, String fitchRating,int orderNumber) {
		super();
		this.fitchRating = fitchRating;
		this.moodysRating = moodysRating;
		this.orderNumber = orderNumber;
		this.sandPRating = sandPRating;
	}
	
}
