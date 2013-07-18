package com.gravypod.starmod;

/**
 * Allow for events/loading to be fired only when the developer wants them to
 * 
 */
public enum GameSetting {
	/**
	 * The code is being run client side while they are connected to a server
	 */
	CLIENT, 
	/**
	 * The code is being run server side
	 */
	SERVER,
	/**
	 * The code is being run in single player
	 */
	SINGLEPLAYER;
}
