package com.stockalarm.watch.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.stockalarm.watch.service.StockWatcherStreamThread;

import io.netty.util.concurrent.ScheduledFuture;

public class Scheduling {

	public void trigger() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        
        List<ScheduledFuture<String>> results = new ArrayList<ScheduledFuture<String>>();
 
        for (int i = 1; i <= 5; i++) 
        {
        	StockWatcherStreamThread task = new StockWatcherStreamThread("Task-" + i);
            ScheduledFuture<String> result = (ScheduledFuture<String>) executor.schedule((Runnable) task, i*2, TimeUnit.SECONDS);
            results.add(result);
        }
         
        executor.shutdown();
         
        try { 
            executor.awaitTermination(1, TimeUnit.DAYS); 
             
            for(ScheduledFuture<String> result : results) {
                System.out.println(result.get());
            }
             
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
	}
}
