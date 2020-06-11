package com.stockalarm.watch.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.stockalarm.watch.service.StockWatcherStreamThread;


public class ThreadsMap {
	private final static Logger LOGGER = Logger.getLogger(ThreadsMap.class.getName());
	public static Map<String, Thread> threads = new HashMap();
	
	public static void addStockThread(String stockName) {
		if(threads.containsKey(stockName) && threads.get(stockName) != null) { 
		    LOGGER.info("Thread is found and already active: : " + stockName);
			return;
		}
	    StockWatcherStreamThread t = new StockWatcherStreamThread(stockName);
	    threads.put(stockName, t);
	    t.start();
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
