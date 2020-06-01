package com.javainuse.model;

public class StockModel {

	private String symbol;
	private String series;
	private String open;
	private String high;
	private String low;
	private String close;
	private String last;
	private String prevclose;
	private String tottrdqty;
	private String tottrdval;
	private String timestamp;
	private String totaltrades;
	private String isin;

	public StockModel() {
		super();
	}

	public StockModel(String symbol, String series, String open, String high, String low, String close, String last,
			String prevclose, String tottrdqty, String tottrdval, String timestamp, String totaltrades, String isin) {
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

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getPrevclose() {
		return prevclose;
	}

	public void setPrevclose(String prevclose) {
		this.prevclose = prevclose;
	}

	public String getTottrdqty() {
		return tottrdqty;
	}

	public void setTottrdqty(String tottrdqty) {
		this.tottrdqty = tottrdqty;
	}

	public String getTottrdval() {
		return tottrdval;
	}

	public void setTottrdval(String tottrdval) {
		this.tottrdval = tottrdval;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTotaltrades() {
		return totaltrades;
	}

	public void setTotaltrades(String totaltrades) {
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
		return "StockModel [symbol=" + symbol + ", series=" + series + ", open=" + open + ", high=" + high + ", low="
				+ low + ", close=" + close + ", last=" + last + ", prevclose=" + prevclose + ", tottrdqty=" + tottrdqty
				+ ", tottrdval=" + tottrdval + ", timestamp=" + timestamp + ", totaltrades=" + totaltrades + ", isin="
				+ isin + "]";
	}
}
