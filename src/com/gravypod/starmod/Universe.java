package com.gravypod.starmod;

import com.gravypod.starmod.location.Coordinates;
import com.gravypod.starmod.location.SectorCoordinates;
import com.gravypod.starmod.materials.Block;
import com.gravypod.starmod.materials.Material;

public interface Universe {
	
	/**
	 * Get a block from a material
	 * 
	 * @param m
	 *            - {@link Material}
	 * @return
	 */
	public Block getBlock(final Material m);
	
	/**
	 * Get a block from coords
	 * 
	 * @param coods
	 * @param localCoords
	 * @return
	 */
	public Block getBlock(final Coordinates coods, final SectorCoordinates localCoords);
	
	/**
	 * Place a block in the universe
	 * 
	 * @param coods
	 * @param localCoords
	 * @param block
	 */
	public void place(final Coordinates coods, final SectorCoordinates localCoords, final Block block);
	
}
