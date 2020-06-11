package com.stockalarm.watch.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.stockalarm.watch.domain.Stock;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StockRepository extends CrudRepository<Stock, Integer> {
	
	  //@Query("select s from Stock s where lower(s.name) like %?1 and lower(s.sector) like ?2")
//	  
	  @Query(
			  value = "SELECT * FROM stock s WHERE s.name like ?% and s.sector like ?", 
			  nativeQuery = true)
	  
	  //@Query("select s from Stock u where s.firstname = :firstname or u.lastname = :lastname")
	  List<Stock> findByStocknameEndsWith(String stockName, String sector, Pageable page);

}
