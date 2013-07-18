package com.gravypod.starmod.permissions;

import java.util.ArrayList;
import java.util.List;

public abstract class PermissionableObject implements Permissionalbe {
	
	private final List<String> permissions = new ArrayList<String>();
	
	private final List<PermissionSource> sources = new ArrayList<PermissionSource>();
	
	@Override
	public boolean hasPermissions(String permission) {
	
		if (hasPermission(permission)) {
			
			return true;
			
		} else {
			
			StringBuilder stringBuilder = new StringBuilder();
			String[] permissionSegments = permission.split("\\.");
			
			for (String s : permissionSegments) {
				
				stringBuilder.append("*"); // allow for "*" permission
				
				if (hasPermission(stringBuilder.toString())) { // Check to see if they have a wild card nodes
					return true;
				}
				
				stringBuilder.setLength(stringBuilder.length() - 1); // Remove the "*"
				
				stringBuilder.append(s); // Append next segment
				
				stringBuilder.append("."); // Append fake wild node
				
			}
			
		}
		
		return false;
		
	}
	
	private boolean hasPermission(String s) {
	
		for (PermissionSource source : sources) {
			
			if (source.hasPermissions(getName(), s)) {
				return true;
			}
			
		}
		
		if (permissions.contains(s)) {
			return true;
		}
		
		return false;
		
	}
	
	@Override
	public void givePermission(String permission) {
	
		permissions.add(permission);
	}
	
	@Override
	public void addPermissionSource(PermissionSource source) {
	
		sources.add(source);
	}
	
}
