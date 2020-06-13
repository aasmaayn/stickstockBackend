package com.stockalarm.watch.maps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.stockalarm.watch.service.StockWatcherStreamThread;

import yahoofinance.quotes.stock.StockQuote;


public class ThreadsMap {
	private final static Logger LOGGER = Logger.getLogger(ThreadsMap.class.getName());
	public static Map<String, Thread> threads = new HashMap();
	
	public static HashSet<String> symbols = new HashSet();
	private static  ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
	
	public static void addStockThread(String stockName) {
//		if(threads.containsKey(stockName) && threads.get(stockName) != null) { 
//		    LOGGER.info("Thread is found and already active: : " + stockName);
//			return;
//		}
		
		if(symbols.contains(stockName)) {
		    LOGGER.info("Thread is found and already active: : " + stockName);
		    return;
		}
		
		
	    StockWatcherStreamThread t = new StockWatcherStreamThread(stockName);
	    new Thread(t).start();
	   
	    
//	    threads.put(stockName, t);
//	    t.start();
	    LOGGER.info("Thread has been added and started : " + stockName);
	}
	
	
	public static void removeStockThread(String stockName) throws InterruptedException {
		if(threads.containsKey(stockName)){
			threads.get(stockName).join();;
		    LOGGER.info("Thread stopped : " + stockName);


		}else {
		    LOGGER.info("No Thread found for stock name: : " + stockName);

		}
		
	}
	


}
