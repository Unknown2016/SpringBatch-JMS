package com.javainuse.dao;

import java.util.List;

import com.javainuse.entity.Stock;

public interface StockDao {

	public String storeStock(List<? extends Stock> items);
	public List<Stock> getStock();
}
