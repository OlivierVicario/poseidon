package com.nnk.springboot.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "trade")
public class Trade {
    // TODO: Map columns in data table TRADE with corresponding java fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tradeId")
	private Integer tradeId;
	@NotNull( message="Please enter an account")
	@Column(name = "account")
	private String account;
	@Column(name = "benchmark")
	private String benchmark;
	@Column(name = "book")
	private String book;
	@Column(name = "buyPrice")
	private Double buyPrice;
	@Column(name = "buyQuantity")
	private Double buyQuantity;
	@Column(name = "creationDate")
	private Timestamp creationDate;
	@Column(name = "creationName")
	private String creationName;
	@Column(name = "dealName")
	private String dealName;
	@NotNull( message="Please enter a type")
	@Column(name = "dealType")
	private String dealType;
	@Column(name = "revisionDate")
	private Timestamp revisionDate;
	@Column(name = "revisionName")
	private String revisionName;
	@Column(name = "security")
	private String security;
	@Column(name = "sellPrice")
	private Double sellPrice;
	@Column(name = "sellQuantity")
	private Double sellQuantity;

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getSourceListId() {
		return sourceListId;
	}

	public void setSourceListId(String sourceListId) {
		this.sourceListId = sourceListId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Timestamp tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String side;

	private String sourceListId;

	private String status;

	private Timestamp tradeDate;

	private String trader;

	private String type;

	public Trade() {
	}

	public Trade(String account, String type) {
		super();
		this.account = account;
		this.type = type;
	}


	public Integer getTradeId() {
		return this.tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBenchmark() {
		return this.benchmark;
	}

	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}

	public String getBook() {
		return this.book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public Double getBuyPrice() {
		return this.buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getBuyQuantity() {
		return this.buyQuantity;
	}

	public void setBuyQuantity(Double buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreationName() {
		return this.creationName;
	}

	public void setCreationName(String creationName) {
		this.creationName = creationName;
	}

	public String getDealName() {
		return this.dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public String getDealType() {
		return this.dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public Timestamp getRevisionDate() {
		return this.revisionDate;
	}

	public void setRevisionDate(Timestamp revisionDate) {
		this.revisionDate = revisionDate;
	}

	public String getRevisionName() {
		return this.revisionName;
	}

	public void setRevisionName(String revisionName) {
		this.revisionName = revisionName;
	}

	public String getSecurity() {
		return this.security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public Double getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Double getSellQuantity() {
		return this.sellQuantity;
	}

	public void setSellQuantity(Double sellQuantity) {
		this.sellQuantity = sellQuantity;
	}
}
