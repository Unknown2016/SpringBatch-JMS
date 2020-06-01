package com.javainuse.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javainuse.dao.StockDao;
import com.javainuse.entity.Stock;

@Component
public class StockWriter implements ItemWriter<Stock> {

	@Autowired
	StockDao employeeDao;

	@Override
	public void write(List<? extends Stock> items) throws Exception {
		employeeDao.storeStock(items);
		System.out.println("writing ==" + items);
	}
}
