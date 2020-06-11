package com.stockalarm.watch.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Scheduled;

import com.stockalarm.watch.maps.StocksDataMap;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockWatcherStreamThread extends Thread {
	private final static Logger LOGGER = Logger.getLogger(StockWatcherStreamThread.class.getName());

	String stockName;
	BigDecimal price ;
	BigDecimal change ;
	BigDecimal peg ;
	BigDecimal dividend ;
	Stock stock;
	
	public StockWatcherStreamThread(String stockName) {
		super();
		this.stockName = stockName;
	}

	@Scheduled(fixedRate = 3000)
	@Override
	public void run() {
		 try {
			stock = YahooFinance.get(stockName);
		} catch (IOException e) {
			LOGGER.info("Error occured while calling Yahoo finance API : "+ e.getMessage());
		}
		 price = stock.getQuote().getPrice();
		 change = stock.getQuote().getChangeInPercent();
		 peg = stock.getStats().getPeg();
		 dividend = stock.getDividend().getAnnualYieldPercent();
		 StocksDataMap.put(stockName, stock.getQuote());
		 LOGGER.info("Thread running : "+ StocksDataMap.get(stockName));
	}



}
