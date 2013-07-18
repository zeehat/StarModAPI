package com.gravypod.starmod.plugin;

import com.gravypod.starmod.GameSetting;

public abstract class Plugin {
	
	private String name;
	
	private PluginManager pluginManager;
	
	private String mainClass;
	
	protected void init(final PluginManager pluginManager, final String name, final String mainClass) {
	
		this.mainClass = mainClass;
	}
	
	/**
	 * Get the plugin name
	 * 
	 * @return plugin name
	 */
	public String getName() {
	
		return name;
	}
	
	/**
	 * This method is run for all loaded plugins as soon as the server is
	 * started
	 */
	public void onEnable(final GameSetting setting) {
	
	}
	
	/**
	 * This method is run for all plugins before the server stops
	 */
	public void onDisable(final GameSetting setting) {
	
	}
	
	/**
	 * Get the instance of {@link PluginManager}.
	 * The PluginManager is a plugins main interface to this API.
	 * You can register events, call tasks, and access many other cool utilities.
	 * @return
	 */
	public PluginManager getPluginManager() {
	
		return pluginManager;
	}
	
	/**
	 * Get the classpath to the main class of this plugin
	 * @return
	 */
	public String getMainClass() {
	
		return mainClass;
	}
	
}
