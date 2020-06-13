package com.stockalarm.watch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockalarm.watch.domain.UserStock;
import com.stockalarm.watch.maps.StocksDataMap;
import com.stockalarm.watch.maps.ThreadsMap;
import com.stockalarm.watch.repository.UserRepository;
import com.stockalarm.watch.repository.UserStockRepository;

@Component
public class AddRemoveStock {
	
	@Autowired
	UserStockRepository userStockRepository;
	
	
	public void addStock(String stockName) {
		ThreadsMap.addStockThread(stockName);	
		UserStock  userStock = new UserStock();
		userStock.setStock(stockName);
		userStock.setUser("zakasma");
		userStockRepository.save(userStock);
	}
	
	
	public void removeStock(String stockName) throws InterruptedException {
		ThreadsMap.removeStockThread(stockName);
		StocksDataMap.remove(stockName);
		UserStock  userStock = new UserStock();
		userStock.setStock(stockName);
		userStock.setUser("zakasma");
		userStockRepository.delete(userStock);
	}
	
}
