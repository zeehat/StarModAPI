package com.gravypod.starmod.plugin.events;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import com.gravypod.starmod.plugin.Plugin;

/**
 * Handle event functionality TODO: Clean up
 * 
 * @author gravypod
 * 
 */
public class EventManager {
	
	/**
	 * {@link HashMap} of handlers we know about. The Key is a {@link Class}
	 * that extends {@link Event}, The Value is a {@link EventHandlerList}
	 */
	private final ConcurrentHashMap<Class<? extends Event>, EventHandlerList> handlers = new ConcurrentHashMap<Class<? extends Event>, EventHandlerList>();
	
	/**
	 * Start an {@link EventManager} And initiate the {@link Events} class
	 */
	public EventManager() {
	
		Events.init(this);
		
	}
	
	/**
	 * Fire an {@link Event} to all listening plugins
	 * 
	 * @param event
	 *            - {@link Event} instance
	 */
	public void fireEvent(final Event event) {
	
		fireEvent(event.getClass(), event);
		
	}
	
	/**
	 * Fire an {@link Event} Do not use this, might change in functionality, use
	 * <code>fireEvent(Event event)</code>
	 * 
	 * @param clazz
	 *            - {@link Class} of the {@link Event}
	 * @param event
	 *            - instance of the {@link Event}
	 */
	private void fireEvent(final Class<? extends Event> clazz, final Event event) {
	
		if (!handlers.containsKey(clazz)) {
			return;
		}
		
		handlers.get(clazz).fireEvent(event);
	}
	
	/**
	 * Register a {@link Plugin}'s {@link Listener} to hear {@link Event}s
	 * 
	 * @param p
	 *            - Instance of the {@link Plugin}
	 * @param listener
	 *            - Instance of the {@link Listener}
	 * @throws Exception
	 *             - Thrown if the {@link Plugin}'s listener isn't correctly set
	 *             up.
	 */
	public void registerEvents(final Plugin p, final Listener listener) throws Exception {
	
		registerEvents(p, listener, listener.getClass());
		
	}
	
	private void registerEvents(final Plugin p, final Listener listener, final Class<? extends Listener> clazz) throws Exception {
	
		final Method[] methods = clazz.getMethods(); // Find all the methods of the class
		
		for (final Method m : methods) {
			
			if (!m.isAccessible()) {
				m.setAccessible(true); // Let us be able to use these methods
			}
			
			final Annotation[] anotations = m.getAnnotations(); // Find all Annotations on this method
			
			for (final Annotation annotation : anotations) {
				
				if (!(annotation instanceof EventHandler)) { // Find/Check to see if there is an EventHandler
					continue;
				}
				
				@SuppressWarnings("unchecked")
				final Class<? extends Event>[] params = (Class<? extends Event>[]) m.getParameterTypes(); // Get the event they are listening to
				
				if (params.length != 1) {
					throw new Exception("Incorrect arguments on an event handler"); // Throw an error if the listener is not setup correctly
				}
				
				final Class<? extends Event> c = params[0]; // Get the event they listen on
				
				EventHandlerList preRegistered;
				
				if (handlers.containsKey(c)) {
					preRegistered = handlers.get(c); // Get the EventHandlerList
					handlers.remove(c);
				} else {
					preRegistered = new EventHandlerList(); // Make and EventHandlerLis
				}
				
				final EventHandler eventHandler = (EventHandler) annotation; // Get info from annotation start
				
				final EventPriority eventPriority = eventHandler.priority();
				
				final boolean ignore = eventHandler.ignoreCancelled(); // Get info from annotation end
				
				preRegistered.addListener(p, new EventExecutor(listener, m, ignore), eventPriority); // Register listener
				
				handlers.put(c, preRegistered);
				
				break; // Go to the next Method after we find the annotation
				
			}
			
		}
		
	}
	
	/**
	 * Unregister events from a {@link Plugin}
	 * 
	 * @param p
	 *            - {@link Plugin} Instance
	 */
	public void unregisterEvents(final Plugin p) {
	
		for (final EventHandlerList l : handlers.values()) {
			
			if (l.isRgistered(p)) {
				
				l.unregisterEvents(p);
				
			}
			
		}
		
	}
	
}
