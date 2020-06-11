package com.stockalarm.watch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockalarm.watch.domain.Stock;
import com.stockalarm.watch.loaddbwithstocks.DbLoader;
import com.stockalarm.watch.repository.StockRepository;

@RestController
public class StockController {
	
	@Autowired
	StockRepository stockRepository;
	
	
	@Autowired
	DbLoader dbLoader;
	
	
	@GetMapping("/search")
	public List<Stock> findStock(@RequestParam String stockName, @RequestParam String sector) {
//		dbLoader.writeToDbStocks();
//		return null;
		return stockRepository.findByStocknameEndsWith(stockName.toLowerCase(), sector.toLowerCase(), PageRequest.of(0, 3));
	}
}
