package com.gravypod.starmod.utils;

public abstract class SyncTask {
	
	private long timePassed = 0;
	
	private final long waitTime;
	
	public SyncTask(long time) {
	
		this.waitTime = time;
	}
	
	public void update(long delta) {
	
		timePassed += delta;
		
		if (timePassed > waitTime) {
			run(delta, timePassed - waitTime);
			timePassed = 0;
		} else if (timePassed == waitTime) {
			run(delta, 0);
			timePassed = 0;
		}
		
	}
	
	public abstract void run(long delta, long overDue);
	
}
