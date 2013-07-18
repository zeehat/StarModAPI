package com.gravypod.starmod.materials;

public class ItemStack {
	
	private final Item item;
	
	private int amount;
	
	public ItemStack(final Item item, final int amount) {
	
		this.item = item;
		this.amount = amount;
	}
	
	public void setAmount(final int amount) {
	
		this.amount = amount;
	}
	
	public int getAmount() {
	
		return amount;
	}
	
	public void remove(final int amount) {
	
		this.amount -= amount;
	}
	
	public Item getItem() {
	
		return item;
	}
	
}
