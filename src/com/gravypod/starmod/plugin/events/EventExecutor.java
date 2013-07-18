package com.gravypod.starmod.plugin.events;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * {@link EventExecutor} created for every {@link Method} found in a
 * {@link Listener} with the {@link EventManager} {@link Annotation}
 * 
 * 
 */
public class EventExecutor {
	
	private final Listener listener;
	
	private final Method method;
	
	private final boolean ignore;
	
	/**
	 * Create an {@link EventExecutor}
	 * 
	 * @param listener
	 *            - {@link Listener} object instance
	 * @param method
	 *            - {@link Method} to pass the {@link Event}s to.
	 * @param ignore
	 *            - {@link Boolean} to signify you have do/nt want to listen to
	 *            an {@link Event} if it is cancelled
	 */
	public EventExecutor(final Listener listener, final Method method, final boolean ignore) {
	
		this.listener = listener;
		
		this.method = method;
		
		this.ignore = ignore;
		
	}
	
	/**
	 * Execute an event on this listener
	 * 
	 * @param event
	 *            - {@link Event} object
	 */
	public void execute(final Event event) {
	
		try {
			
			if (ignore && event.isCancelled()) { // Dont pass events that are cancelled if you ignore them
				return;
			}
			
			method.invoke(listener, event);
			
		} catch (final IllegalAccessException e) {
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}
