package com.gravypod.starmod.plugin;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Credit goes to the bukkit team on this one!
 * 
 * @author BukkitTeam
 */
public final class JARClassLoader extends URLClassLoader {
	
	private final Map<String, Class<?>> classes = new HashMap<String, Class<?>>();
	
	/**
	 * Create a new class loader
	 * 
	 * @param urls
	 *            - {@link URL} array of all the classes
	 * @param classLoader
	 */
	public JARClassLoader(final URL[] urls, final ClassLoader classLoader) {
	
		super(urls, classLoader);
		
	}
	
	@Override
	public void addURL(final URL url) { // Override for access level!
	
		super.addURL(url);
	}
	
	@Override
	/**
	 * Get a class file with a name
	 * @return {@link Class}
	 */
	protected Class<?> findClass(final String name) throws ClassNotFoundException {
	
		return findClass(name, true);
	}
	
	protected Class<?> findClass(final String name, final boolean checkGlobal) throws ClassNotFoundException {
	
		Class<?> result = classes.get(name);
		
		if (result == null) {
			
			result = super.findClass(name);
			
			classes.put(name, result);
			
		}
		
		return result;
	}
	
	/**
	 * Get all loaded classes
	 * 
	 * @return - Set of classes
	 */
	public Set<String> getClasses() {
	
		return classes.keySet();
	}
	
}
