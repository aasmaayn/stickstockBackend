package com.stockalarm.watch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockalarm.watch.domain.User;
import com.stockalarm.watch.maps.StocksDataMap;
import com.stockalarm.watch.maps.ThreadsMap;
import com.stockalarm.watch.repository.UserRepository;

@Component
public class AddRemoveStock {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void addStock(String stockName) {
		ThreadsMap.addStockThread(stockName);
		
		User user = new User();
		
		user.setRole("BASIC");
		user.setUser("ZAKASMA");
		user.setPass("VOITURE");
		userRepository.save(user);
	}
	
	
	public void removeStock(String stockName) throws InterruptedException {
		ThreadsMap.removeStockThread(stockName);
		StocksDataMap.remove(stockName);
	}
	
}
