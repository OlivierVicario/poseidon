package com.nnk.springboot.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curvepoint")
public class CurvePoint {
	// TODO: Map columns in data table CURVEPOINT with corresponding java fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "asOfDate")
	private Timestamp asOfDate;

	@Column(name = "creationDate")
	private Timestamp creationDate;

	@Column(name = "CurveId")
	private int curveId;

	@Column(name = "term")
	private double term;

	@Column(name = "value")
	private double value;

	public CurvePoint() {
	}

// TODO Auto-generated constructor stub
	public CurvePoint(int curveId, double term, double value) {
		super();
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public int getCurveId() {
		return this.curveId;
	}

	public void setCurveId(int curveId) {
		this.curveId = curveId;
	}

	public double getTerm() {
		return this.term;
	}

	public void setTerm(double term) {
		this.term = term;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
