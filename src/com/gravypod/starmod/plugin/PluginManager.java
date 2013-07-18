package com.gravypod.starmod.plugin;

import java.util.Collection;
import java.util.HashMap;

import com.gravypod.starmod.GameSetting;
import com.gravypod.starmod.Server;
import com.gravypod.starmod.plugin.events.EventHandler;
import com.gravypod.starmod.plugin.events.EventManager;
import com.gravypod.starmod.plugin.events.Listener;

public class PluginManager {
	
	/** Main {@link EventManager} */
	private final EventManager eventManager = new EventManager();
	
	/**
	 * {@link HashMap} of all loaded plugins
	 */
	private final HashMap<String, Plugin> plugins = new HashMap<String, Plugin>();
	
	private final GameSetting gameSetting;
	
	private final Server server;
	
	public PluginManager(GameSetting gameSetting, Server server) {
	
		this.gameSetting = gameSetting;
		this.server = server;
	}
	
	/**
	 * Get a plugin by name
	 * 
	 * @param name
	 *            - The name of the plugin
	 * @return the {@link Plugin} instance with the same name as provided or
	 *         null if none exist
	 */
	public Plugin getPlugin(final String name) {
	
		return plugins.get(name);
	}
	
	/**
	 * Add a newly loaded plugin to the {@link PluginManager}
	 * 
	 * @param p
	 *            - {@link Plugin} instance that you have
	 * @param name
	 *            - name of the plugin
	 */
	public void enablePlugin(final Plugin p, final String name) {
	
		p.onEnable(gameSetting);
		
		plugins.put(name, p);
	}
	
	/**
	 * Unload a plugin by name
	 * 
	 * @param name
	 *            - The name of the plugin
	 */
	public void disablePlugin(String name) {
	
		if (!plugins.containsKey(name)) {
			throw new IllegalStateException("No such plugin");
		}
		
		Plugin p = plugins.get(name);
		
		p.onEnable(gameSetting);
		
		eventManager.unregisterEvents(p);
		
		plugins.remove(name);
		
	}
	
	public void disableAllPlugins() {
	
		for (String name : plugins.keySet()) {
			disablePlugin(name);
		}
		
	}
	
	/**
	 * Register events to a listener. This will register all events to a class
	 * implementing {@link Listener}. The {@link Listener} must have a method
	 * that is annotated with {@link EventHandler}. The method must also take
	 * the event it wants to listen to as an argument. ex: public void
	 * helloWorld(ExampleEvent event) { }
	 * 
	 * @param p
	 *            - {@link Plugin} the listener belongs to
	 * @param eventListener
	 *            - {@link Listener} instance that will be registered to
	 */
	public void registerEvent(final Plugin p, final Listener eventListener) {
	
		try {
			eventManager.registerEvents(p, eventListener);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get a collection of loaded plugins
	 * 
	 * @return
	 */
	public Collection<Plugin> getLoadedPlugins() {
	
		return plugins.values();
	}
	
	/**
	 * Check to see if a plugin is loaded
	 * 
	 * @param name
	 *            - name of the plugin
	 * @return true if the plugin by the name provided is loaded
	 */
	public boolean isPluginLoaded(final String name) {
	
		return plugins.containsKey(name);
	}
	
	/**
	 * Get the instance of the server
	 * 
	 * @return {@link Server} instance
	 */
	public Server getServer() {
	
		return server;
	}
	
}
