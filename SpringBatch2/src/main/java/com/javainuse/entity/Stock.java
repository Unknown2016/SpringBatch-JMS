package com.javainuse.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class Stock implements Serializable {

	private static final long serialVersionUID = 3446959764240583911L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private BigInteger id;

	@Column(name = "SYMBOL")
	private String symbol;

	@Column(name = "SERIES")
	private String series;

	@Column(name = "OPEN")
	private Double open;

	@Column(name = "HIGH")
	private Double high;

	@Column(name = "LOW")
	private Double low;

	@Column(name = "CLOSE")
	private Double close;

	@Column(name = "LAST")
	private Double last;

	@Column(name = "PREVCLOSE")
	private Double prevclose;

	@Column(name = "TOTTRDQTY")
	private BigInteger tottrdqty;

	@Column(name = "TOTTRDVAL")
	private BigDecimal tottrdval;

	@Column(name = "TIMESTAMP")
	private Date timestamp;

	@Column(name = "TOTALTRADES")
	private Long totaltrades;

	@Column(name = "ISIN")
	private String isin;

	public Stock() {
		super();
	}

	public Stock(String symbol, String series, Double open, Double high, Double low, Double close, Double last,
			Double prevclose, BigInteger tottrdqty, BigDecimal tottrdval, Date timestamp, Long totaltrades, String isin) {
		super();
		this.symbol = symbol;
		this.series = series;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.last = last;
		this.prevclose = prevclose;
		this.tottrdqty = tottrdqty;
		this.tottrdval = tottrdval;
		this.timestamp = timestamp;
		this.totaltrades = totaltrades;
		this.isin = isin;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getLast() {
		return last;
	}

	public void setLast(Double last) {
		this.last = last;
	}

	public Double getPrevclose() {
		return prevclose;
	}

	public void setPrevclose(Double prevclose) {
		this.prevclose = prevclose;
	}

	public BigInteger getTottrdqty() {
		return tottrdqty;
	}

	public void setTottrdqty(BigInteger tottrdqty) {
		this.tottrdqty = tottrdqty;
	}

	public BigDecimal getTottrdval() {
		return tottrdval;
	}

	public void setTottrdval(BigDecimal tottrdval) {
		this.tottrdval = tottrdval;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getTotaltrades() {
		return totaltrades;
	}

	public void setTotaltrades(Long totaltrades) {
		this.totaltrades = totaltrades;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", symbol=" + symbol + ", series=" + series + ", open=" + open + ", high=" + high
				+ ", low=" + low + ", close=" + close + ", last=" + last + ", prevclose=" + prevclose + ", tottrdqty="
				+ tottrdqty + ", tottrdval=" + tottrdval + ", timestamp=" + timestamp + ", totaltrades=" + totaltrades
				+ ", isin=" + isin + "]";
	}
}
