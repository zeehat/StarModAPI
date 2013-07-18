package com.gravypod.starmod;

public interface Server {
	
	/**
	 * Get the servers host name
	 * 
	 * @return host name serving on
	 */
	public String getHost();
	
	/**
	 * Get the port the server is running on
	 * 
	 * @return Port the server is running on
	 */
	public int getPort();
	
	/**
	 * Get the amount of players connected to the server
	 * 
	 * @return Amount of players connected
	 */
	public int getPlayers();
	
	/**
	 * Get the instance of the universe
	 * 
	 * @return - an instance of the universe
	 */
	public Universe getUniverse();
	
}
