package com.stockalarm.sotckuser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockUserController {
	@GetMapping("/search")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
