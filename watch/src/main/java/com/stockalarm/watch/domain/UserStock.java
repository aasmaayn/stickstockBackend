package com.stockalarm.watch.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.stockalarm.watch.domain.UserStock.UserStockId;

@Entity
@IdClass(UserStockId.class)
@Table(name = "USER_STOCK")
public class UserStock implements Serializable{
	@Id
	@Column(name = "USER")
	private String user;
	@Id
	@Column(name = "STOCK")
	private String stock;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	
	public class UserStockId implements Serializable {
	    protected String user;
	    protected String stock;

	    public UserStockId() {}

	    public UserStockId(String user, String stock) {
	        this.user = user;
	        this.stock = stock;
	    }
	    // equals, hashCode
	}
	
	

}
