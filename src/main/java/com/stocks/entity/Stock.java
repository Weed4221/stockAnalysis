package com.stocks.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ticker;
	
	@Temporal(TemporalType.DATE)
	private Date date;

	private BigDecimal open;

	private BigDecimal high;

	private BigDecimal low;

	private BigDecimal close;

	// Constructors, getters, and setters

	// Default constructor
	public Stock() {
	}

	// Parameterized constructor
	public Stock(String ticker, Date date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
		this.ticker = ticker;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
	}

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getClose() {
		return close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}
}
