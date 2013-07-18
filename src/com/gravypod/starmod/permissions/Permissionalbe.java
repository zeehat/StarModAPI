package com.gravypod.starmod.permissions;

/**
 * A Permissionalbe is an object that can have permissions appended or removed
 * from them. They can also be asked if they have a permissions. The permission
 * format goes as follows, All permissions are delimited by "."s. A correct
 * permission format is as follows "this.is.a.permission". If you check if a
 * permissionalbe has "this.is.a.permission" and it returns true it can mean a
 * few things. Anyone with "this.is.a.*" will return true for
 * "this.is.a.permission", the same goes for anything like "this.is.*".
 * 
 * @author gravypod
 * 
 */
public interface Permissionalbe {
	
	/**
	 * Check to see if a {@link Permissionalbe} has a permission
	 * 
	 * @param permission
	 *            - the permission string
	 * @return
	 */
	boolean hasPermissions(String permission);
	
	/**
	 * Give the {@link Permissionalbe} a permission
	 * 
	 * @param permission
	 *            - String delimited by "."s to identify rights
	 * @return true if they have the permission, false if not
	 */
	void givePermission(String permission);
	
	/**
	 * Add a permission source to the {@link Permissionable}
	 * 
	 * @param source
	 */
	void addPermissionSource(PermissionSource source);
	
	/**
	 * Get the name of the Permissionalbe
	 * 
	 * @return
	 */
	String getName();
	
}
