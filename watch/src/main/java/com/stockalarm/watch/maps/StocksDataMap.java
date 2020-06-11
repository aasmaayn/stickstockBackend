package com.stockalarm.watch.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

public class StocksDataMap {

	private static ConcurrentHashMap<String, StockQuote> stocks = new ConcurrentHashMap();

	public static void put(String key, StockQuote stock) {
		if (!stocks.containsKey(key))
			stocks.put(key, stock);
	}

	public static StockQuote get(String key) {
		if (stocks.containsKey(key))
			return stocks.get(key);
		else
			return null;
	}
	
	
	public static void remove(String key) {
		if (stocks.containsKey(key))
			stocks.remove(key);
	}
	
	public static List<StockQuote>  getStocksData(){
		List<StockQuote> quotes = new ArrayList();
		for (ConcurrentHashMap.Entry<String,StockQuote> entry : stocks.entrySet())  {
			quotes.add(entry.getValue());
    	} 
		
		return quotes;
	}

}
