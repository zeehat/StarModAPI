package com.gravypod.starmod.plugin.events;

/**
 * Event priorities that we allow
 * 
 */
public enum EventPriority {
	/**
	 * Last event to be fired
	 */
	LOW,
	/**
	 * Normal event priority, fired after high
	 */
	MEDIUM,
	/**
	 * Fired first
	 */
	HIGH,
	/**
	 * Fired so plugins can see if the event is cancelled 
	 */
	MONITOR;
}
