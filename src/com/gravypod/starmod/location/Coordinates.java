package com.gravypod.starmod.location;

/**
 * TODO: Validate that locations are in ints and that there is no more data
 * needing to be stored
 * 
 */
public class Coordinates {
	
	private int sectorX, sectorY, sectorZ;
	
	private int systemX, systemY, systemZ;
	
	/**
	 * Coordinates of a system and sector
	 * 
	 * @param sectorX
	 *            - Sector x
	 * @param sectorY
	 *            - Sector Y
	 * @param sectorZ
	 *            - Sector Z
	 * @param systemX
	 *            - Sector X
	 * @param systemY
	 *            - Sector Y
	 * @param systemZ
	 *            - Sector Z
	 */
	public Coordinates(final int sectorX, final int sectorY, final int sectorZ, final int systemX, final int systemY, final int systemZ) {
	
		this.sectorX = sectorX;
		this.sectorY = sectorY;
		this.sectorZ = sectorZ;
		this.systemX = systemX;
		this.systemY = systemY;
		this.systemZ = systemZ;
	}
	
	public int getSectorX() {
	
		return sectorX;
	}
	
	public int getSectorY() {
	
		return sectorY;
	}
	
	public int getSectorZ() {
	
		return sectorZ;
	}
	
	public int getSystemX() {
	
		return systemX;
	}
	
	public int getSystemY() {
	
		return systemY;
	}
	
	public int getSystemZ() {
	
		return systemZ;
	}
	
	public void setSectorX(final int sectorX) {
	
		this.sectorX = sectorX;
	}
	
	public void setSectorY(final int sectorY) {
	
		this.sectorY = sectorY;
	}
	
	public void setSectorZ(final int sectorZ) {
	
		this.sectorZ = sectorZ;
	}
	
	public void setSystemX(final int systemX) {
	
		this.systemX = systemX;
	}
	
	public void setSystemY(final int systemY) {
	
		this.systemY = systemY;
	}
	
	public void setSystemZ(final int systemZ) {
	
		this.systemZ = systemZ;
	}
	
}
