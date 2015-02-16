package com.tom.abp.dao;

import java.util.List;

import com.tom.abp.entity.Stock;

public interface StockDao {
	void addStock(Stock stock);
	void updateStock(Stock stock);
	void deleteStock(int id);
	Stock findById(int id);
	Stock findByBoxNumber(String boxNumber);
	List<Stock> findByName(String name);
	List<Stock> findByTag(String tag);
	List<Stock> findAll();
}
