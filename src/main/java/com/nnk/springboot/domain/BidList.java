package com.nnk.springboot.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bidlist")
public class BidList {
    // TODO: Map columns in data table BIDLIST with corresponding java fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BidListId")
	private int BidListId;
	@Column(name = "account")
	private String account;
	@Column(name = "ask")
	private double ask;
	@Column(name = "askQuantity")
	private double askQuantity;
	@Column(name = "benchmark")
	private String benchmark;
	@Column(name = "bid")
	private double bid;
	@Column(name = "bidListDate")
	private Timestamp bidListDate;
	@Column(name = "bidQuantity")
	private double bidQuantity;
	@Column(name = "book")
	private String book;
	@Column(name = "commentary")
	private String commentary;
	@Column(name = "creationDate")
	private Timestamp creationDate;
	@Column(name = "creationName")
	private String creationName;
	@Column(name = "dealName")
	private String dealName;
	@Column(name = "dealType")
	private String dealType;
	@Column(name = "revisionDate")
	private Timestamp revisionDate;
	@Column(name = "revisionName")
	private String revisionName;
	@Column(name = "security")
	private String security;
	@Column(name = "side")
	private String side;
	@Column(name = "sourceListId")
	private String sourceListId;
	@Column(name = "status")
	private String status;
	@Column(name = "trader")
	private String trader;
	@Column(name = "type")
	private String type;
	
	public BidList() {
	}


// TODO Auto-generated constructor stub
	public BidList(String account, String type, double bidQuantity) {
		super();
		this.account = account;
		this.bidQuantity = bidQuantity;
		this.type = type;
	}

	public int getBidListId() {
		return this.BidListId;
	}

	public void setBidListId(int bidListId) {
		this.BidListId = bidListId;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getAsk() {
		return this.ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public double getAskQuantity() {
		return this.askQuantity;
	}

	public void setAskQuantity(double askQuantity) {
		this.askQuantity = askQuantity;
	}

	public String getBenchmark() {
		return this.benchmark;
	}

	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}

	public double getBid() {
		return this.bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public Timestamp getBidListDate() {
		return this.bidListDate;
	}

	public void setBidListDate(Timestamp bidListDate) {
		this.bidListDate = bidListDate;
	}

	public double getBidQuantity() {
		return this.bidQuantity;
	}

	public void setBidQuantity(double bidQuantity) {
		this.bidQuantity = bidQuantity;
	}

	public String getBook() {
		return this.book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getCommentary() {
		return this.commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
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

	public String getSide() {
		return this.side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getSourceListId() {
		return this.sourceListId;
	}

	public void setSourceListId(String sourceListId) {
		this.sourceListId = sourceListId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrader() {
		return this.trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
