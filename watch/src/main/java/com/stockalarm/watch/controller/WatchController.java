package com.stockalarm.watch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.stockalarm.watch.domain.Greeting;
import com.stockalarm.watch.domain.HelloMessage;
import com.stockalarm.watch.loaddbwithstocks.DbLoader;
import com.stockalarm.watch.service.AddRemoveStock;

@Controller
public class WatchController {
	@Autowired
	private AddRemoveStock addRemoveStock;
	public static Map<String, Thread> threads = new HashMap();
	
	
	

  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  public Greeting greeting(HelloMessage message) throws Exception {
    System.out.print(message.getName());
    //addRemoveStock.addStock(message.getName());
    return new Greeting("Stock received ==> , " + HtmlUtils.htmlEscape(message.getName()) + "!");
  }
  
  
//  @SendTo("/topic/greetings")
//  public Greeting fireGreeting() {
//      System.out.println("Fire");
//      return new Greeting("Fire");
//  }

}