package com.stockalarm.sotckuser;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
	 Logger logger = LoggerFactory.getLogger(App.class);
	    

	    public static void main(String[] args) {
	    	SpringApplication app = new SpringApplication(App.class);
	    	app.setDefaultProperties(Collections
	    	          .singletonMap("server.port", "8081"));
	    	        app.run(args);
	    }
}
