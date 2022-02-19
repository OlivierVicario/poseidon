package com.nnk.springboot.domain;

import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "bidlist")
public class BidList {
    // TODO: Map columns in data table BIDLIST with corresponding java fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int BidListId;

	private String account;

	private double ask;

	private double askQuantity;

	private String benchmark;

	private double bid;

	private Timestamp bidListDate;

	private double bidQuantity;

	private String book;

	private String commentary;

	private Timestamp creationDate;

	private String creationName;

	private String dealName;

	private String dealType;

	private Timestamp revisionDate;

	private String revisionName;

	private String security;

	private String side;

	private String sourceListId;

	private String status;

	private String trader;

	private String type;

	public BidList() {
	}

	/*public BidList(String account, String type, double bidQuantity) {
		// TODO Auto-generated constructor stub
	}*/

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
