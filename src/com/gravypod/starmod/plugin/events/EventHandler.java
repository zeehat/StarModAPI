package com.gravypod.starmod.plugin.events;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
/**
 * EventHandler Annotation
 *
 */
public @interface EventHandler {
	
	/**
	 * When you want to see the {@link Event}. See {@link EventHandlerList} for
	 * details pertaining to when an {@link Event} is run and what
	 * {@link EventPriority} is fired first
	 * 
	 * @return - The {@link EventPriority} of this {@link Annotation}
	 */
	EventPriority priority() default EventPriority.MEDIUM;
	
	/**
	 * Check to see if you receive {@link Event}s that have been cancelled
	 * 
	 * @return - If this {@link Annotation} wants to receive cancelled
	 *         {@link Event}s
	 */
	boolean ignoreCancelled() default false;
}
