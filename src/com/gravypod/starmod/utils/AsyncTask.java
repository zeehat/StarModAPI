package com.gravypod.starmod.utils;

import java.util.concurrent.atomic.AtomicBoolean;

public class AsyncTask extends Thread {
	
	private final long time;
	
	private final Runnable r;
	
	private final AtomicBoolean running = new AtomicBoolean(true);
	
	public AsyncTask(long time, Runnable r) {
	
		this("AsyncTask", time, r);
		
	}
	
	public AsyncTask(String name, long time, Runnable r) {
	
		setName(name);
		
		this.time = time;
		
		this.r = r;
		
	}
	
	@Override
	public void run() {
	
		while(running.get()) {
			
			try {
				
				Thread.sleep(time);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
			r.run();
			
		}
		
	}
	
	public void toggleRunning() {
	
		running.set(!running.get());
		
		if (running.get()) {
			this.start();
		}
		
	}
	
}
