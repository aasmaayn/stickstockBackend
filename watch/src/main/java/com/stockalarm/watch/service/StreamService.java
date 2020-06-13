package com.stockalarm.watch.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.stockalarm.watch.maps.StocksDataMap;

import yahoofinance.Stock;
import yahoofinance.quotes.stock.StockQuote;

@Component
public class StreamService {
	private final static Logger LOGGER = Logger.getLogger(StreamService.class.getName());

	BigDecimal price ;
	BigDecimal change ;
	BigDecimal peg ;
	BigDecimal dividend ;
	Stock stock;
	List<StockQuote> stocksquotes;

	@Autowired
	private SimpMessagingTemplate template;

	@Scheduled(fixedRate = 1000)
	public void fireGreeting() throws IOException {
		if(StocksDataMap.getStocksData().isEmpty()) return;
		LOGGER.info(StocksDataMap.getStocksData().toString());
		this.template.convertAndSend("/topic/greetings", StocksDataMap.getStocksData());
	}
}
