package com.stockalarm.watch.controller;

	import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockalarm.watch.loaddbwithstocks.DbLoader;
import com.stockalarm.watch.service.AddRemoveStock;

	@RestController
	public class StockUserController {
		private final static Logger LOGGER = Logger.getLogger(StockController.class.getName());


		
		@Autowired
		private AddRemoveStock addRemoveStock;
		
		@Autowired
		DbLoader dbLoader;
		
		@CrossOrigin
		@GetMapping("userstock/add")
		public void addStock(@RequestParam String stockName) {
			LOGGER.info("adding stock :"+stockName);
			addRemoveStock.addStock(stockName);
			
		}
		
		@CrossOrigin
		@GetMapping("userstock/remove")
		public void removeStock(@RequestParam String stockName) throws InterruptedException {
			addRemoveStock.removeStock(stockName);
			LOGGER.info("removing stock:"+stockName);			
			
		}
	}
