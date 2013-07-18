package com.gravypod.starmod.entity;

import com.gravypod.starmod.location.Coordinates;

public interface Entity {
	
	/**
	 * Get the name of the entity
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * Get the coordinates of the entity detailing the sector and system
	 * 
	 * @return
	 */
	public Coordinates getCoordinates();
	
}
