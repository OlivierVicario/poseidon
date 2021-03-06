package com.nnk.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rulename")
public class RuleName {
    // TODO: Map columns in data table RULENAME with corresponding java fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	@NotNull( message="Please enter a description")
	@Column(name = "description")
	private String description;
	@Column(name = "json")
	private String json;
	@NotNull( message="Please enter a name")
	@Column(name = "name")
	private String name;
	@Column(name = "sqlPart")
	private String sqlPart;
	@Column(name = "sqlStr")
	private String sqlStr;
	@Column(name = "template")
	private String template;

	public RuleName() {
	}


	public RuleName(String name,String description, String json,  String template, String sqlStr,String sqlPart ) {
		super();
		this.description = description;
		this.json = json;
		this.name = name;
		this.sqlPart = sqlPart;
		this.sqlStr = sqlStr;
		this.template = template;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJson() {
		return this.json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSqlPart() {
		return this.sqlPart;
	}

	public void setSqlPart(String sqlPart) {
		this.sqlPart = sqlPart;
	}

	public String getSqlStr() {
		return this.sqlStr;
	}

	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
