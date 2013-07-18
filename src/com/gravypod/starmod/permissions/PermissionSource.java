package com.gravypod.starmod.permissions;


public interface PermissionSource {
	
	boolean hasPermissions(String playerName, String permission);
	
}
