package com.stockalarm.watch.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Scheduled;

import com.stockalarm.watch.maps.StocksDataMap;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

public class StockWatcherStreamThread implements Runnable {
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

	@Override
	public void run () {
		while(true) {
			
			 try {
				 Thread.sleep(2000);
					stock = YahooFinance.get(stockName);
				} catch (IOException | InterruptedException e) {
					LOGGER.info("Error occured while calling Yahoo finance API : "+ e.getMessage());
				}
//				 price = stock.getQuote().getPrice();
//				 change = stock.getQuote().getChangeInPercent();
//				 peg = stock.getStats().getPeg();
//				 dividend = stock.getDividend().getAnnualYieldPercent();
				 StocksDataMap.put(stockName, stock.getQuote());
				 LOGGER.info("Thread running : "+ stock.getQuote());
		}
	
	}


}
