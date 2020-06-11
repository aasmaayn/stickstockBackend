package com.stockalarm.watch.repository;

import org.springframework.data.repository.CrudRepository;

import com.stockalarm.watch.domain.UserStock;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserStockRepository extends CrudRepository<UserStock, Integer> {

}
