package com.gravypod.starmod.materials;

public interface Material {
	
	/**
	 * Get the name of the material
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * The mass points the block is worth.
	 * 
	 * @return int for the mass of the block
	 */
	public int getMass();
	
	/**
	 * This will return if the block is opaque meaning if you can see through
	 * the block
	 * 
	 * @return true if you CANNOT see through the block
	 */
	public boolean isOpaque();
	
	/**
	 * Get the item ID of the material
	 * 
	 * @return item id
	 */
	public int getID();
	
	/**
	 * Get the price of the object
	 * 
	 * @return
	 */
	public int getPrice();
	
	/**
	 * Set the price of the material
	 * 
	 * @param price
	 */
	public void setPrice(final int price);
	
}
