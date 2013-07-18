package com.gravypod.starmod.materials;

import com.gravypod.starmod.Universe;
import com.gravypod.starmod.location.Coordinates;
import com.gravypod.starmod.location.SectorCoordinates;

public interface Block extends Material {
	
	/**
	 * Gets the {@link Universe} the block is in
	 * 
	 * @return
	 */
	Universe getUniverse();
	
	/**
	 * Gets the {@link Coordinates}
	 * 
	 * @return
	 */
	Coordinates getCoordinates();
	
	/**
	 * Gets the internal sector coordinates
	 * 
	 * @return
	 */
	SectorCoordinates getLocalCoordinates();
	
}
