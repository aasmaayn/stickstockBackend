package com.stockalarm.watch.loaddbwithstocks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockalarm.watch.domain.Stock;
import com.stockalarm.watch.repository.StockRepository;

@Component
public class DbLoader {
	
	@Autowired
	private StockRepository stockRepository;
	
	private final static Logger LOGGER = Logger.getLogger(DbLoader.class.getName());

	public void writeToDbStocks() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"/Users/hp/Downloads/companylist.txt"));
			String line = reader.readLine();
			int i = 0;
			while (line != null) {
				// read next line
				String[] values = line.split("\",\"");
				Stock s = new Stock();
				s.setSymbol(values[0].replace("\"", ""));
				s.setName(values[1]);
				
				s.setSector(values[5]);
				stockRepository.save(s);
				line = reader.readLine();
				i++;
				LOGGER.info(i+": record "+i+ " saved to db");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LOGGER.info("Loading done.");
		
	}

}
