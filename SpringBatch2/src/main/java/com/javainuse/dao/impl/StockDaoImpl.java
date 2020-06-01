package com.javainuse.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javainuse.dao.StockDao;
import com.javainuse.entity.Stock;

@Repository
@Transactional
public class StockDaoImpl implements StockDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public String storeStock(List<? extends Stock> items) {
		items.stream().forEach(f -> {
			Stock employee = f;
			entityManager.persist(employee);
			System.out.println("id = " + employee.getId());
		});
		entityManager.flush();
		entityManager.clear();
		return "" + items.size();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Stock> getStock() {
		Query query = entityManager.createQuery("From Stock");
		List<Stock> list = query.getResultList();
		return list;
	}
}
