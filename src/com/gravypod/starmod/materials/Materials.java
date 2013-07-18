package com.gravypod.starmod.materials;

import java.util.concurrent.ConcurrentHashMap;

import com.gravypod.starmod.materials.blocks.UnknownBlock;

public class Materials {
	
	private final static ConcurrentHashMap<Integer, Material> materials = new ConcurrentHashMap<Integer, Material>();
	
	/*	Universe universe;
		
		public Materials(Universe universe) {
		
			this.universe = universe;
		}*/
	
	public static Material getMaterial(final int id) {
	
		if (!Materials.materials.containsKey(id)) {
			return new UnknownBlock(id/*, universe*/);
		}
		
		return Materials.materials.get(id);
		
	}
	
	public static void pushMaterial(final Material m) {
	
	}
}
