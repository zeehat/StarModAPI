package com.gravypod.starmod.plugin.events;

/**
 * Normal {@link Event} that can be cancelled
 * 
 */
public abstract class Event {
	
	private boolean isCancelled = false;
	
	/**
	 * Check to see if this {@link Event} has been cancelled
	 * 
	 * @return - {@link Boolean}, <code>true</code> if has been cancelled,
	 *         <code>false</code> otherwise
	 */
	public boolean isCancelled() {
	
		return isCancelled;
	}
	
	/**
	 * Set an {@link Event} as cancelled
	 * 
	 * @param isCancelled
	 *            - {@link Boolean} representing <code>true</code> for stopping
	 *            the {@link Event}
	 */
	public void setCancelled(final boolean isCancelled) {
	
		this.isCancelled = isCancelled;
	}
	
}
