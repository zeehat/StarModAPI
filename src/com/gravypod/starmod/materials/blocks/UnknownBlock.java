package com.gravypod.starmod.materials.blocks;

import com.gravypod.starmod.materials.Material;

public class UnknownBlock implements Material {
	
	public int price;
	
	int id;
	
	public UnknownBlock(final int id) {
	
		this.id = id;
	}
	
	@Override
	public String getName() {
	
		return "UnkownBlock";
	}
	
	@Override
	public int getMass() {
	
		return 0;
	}
	
	@Override
	public boolean isOpaque() {
	
		return false;
	}
	
	@Override
	public int getID() {
	
		return id;
	}
	
	@Override
	public int getPrice() {
	
		return price;
	}
	
	@Override
	public void setPrice(final int price) {
	
		this.price = price;
	}
	
}
