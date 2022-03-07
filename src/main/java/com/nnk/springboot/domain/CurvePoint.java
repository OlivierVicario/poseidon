package com.nnk.springboot.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "curvepoint")
public class CurvePoint {
	// TODO: Map columns in data table CURVEPOLong with corresponding java fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;

	@Column(name = "asOfDate")
	private Timestamp asOfDate;

	@Column(name = "creationDate")
	private Timestamp creationDate;
	@NotNull( message="Please enter a curve id")
	@Column(name = "CurveId")
	private Integer curveId;
	@Max(1000)
	@Min(1)
	@Column(name = "term")
	private Double term;
	@Max(1000)
	@Min(1)
	@Column(name = "value")
	private Double value;

	public CurvePoint() {
	}

// TODO Auto-generated constructor stub
	public CurvePoint(Integer curveId, Double term, Double value) {
		super();
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getAsOfDate() {
		return this.asOfDate;
	}

	public void setAsOfDate(Timestamp asOfDate) {
		this.asOfDate = asOfDate;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getCurveId() {
		return this.curveId;
	}

	public void setCurveId(Integer curveId) {
		this.curveId = curveId;
	}

	public Double getTerm() {
		return this.term;
	}

	public void setTerm(Double term) {
		this.term = term;
	}

	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
