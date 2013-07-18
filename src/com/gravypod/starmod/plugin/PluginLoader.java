package com.gravypod.starmod.plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

import com.gravypod.starmod.GameSetting;
import com.gravypod.starmod.Server;

/**
 * Manages everyday {@link Plugin} functionality. EX Loading, And disabling a
 * plugin
 * 
 * @author gravypod
 * 
 */
public class PluginLoader {
	
	/** {@link Logger} instance */
	private final Logger log;
	
	private final PluginManager pluginManager;
	
	/**
	 * Create a new {@link PluginLoader}
	 * 
	 * @param logger
	 *            - {@link Logger} instance from the server
	 */
	public PluginLoader(final Logger logger, final GameSetting gameSetting, Server server) {
	
		log = logger;
		
		log.info("Started plugin handler");
		
		pluginManager = new PluginManager(gameSetting, server);
		
	}
	
	/**
	 * Load all of the .jar files in ./plugins/ into {@link Plugin} objects This
	 * also runs onEnabled() and init()
	 */
	public void loadPlugins() {
	
		final File pluginFolder = new File("./plugins/");
		
		if (!pluginFolder.exists()) {
			pluginFolder.mkdir();
			return;
		}
		
		final File[] pluginFiles = pluginFolder.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(final File arg0, final String arg1) {
			
				return arg1.endsWith(".jar");
				
			}
			
		});
		
		for (final File plugin : pluginFiles) {
			
			loadPluginFile(plugin);
			
		}
		
	}
	
	/**
	 * Load a jar {@link File} into a {@link Plugin}
	 * 
	 * @param jar
	 *            - {@link File} to load into a {@link Plugin}. Must contain a
	 *            plugin.prop with name and main
	 */
	public void loadPluginFile(final File jar) {
	
		try {
			
			final JarFile jarFile = new JarFile(jar);
			
			final JarEntry jarEntry = jarFile.getJarEntry("plugin.prop");
			
			final InputStream is = jarFile.getInputStream(jarEntry);
			
			final Properties prop = new Properties();
			
			final URL urls = jar.toURI().toURL();
			
			prop.load(is);
			
			final String main = prop.getProperty("main");
			
			final String name = prop.getProperty("name");
			
			if (main == "" || name == "") {
				throw new Exception("Your plugin did not contain a name or a main in plugin.prop");
			}
			
			final Class<?> jarClass = Class.forName(main, true, new JARClassLoader(new URL[] {urls}, getClass().getClassLoader()));
			
			final Class<? extends Plugin> plugin = jarClass.asSubclass(Plugin.class);
			
			final Constructor<? extends Plugin> constructor = plugin.getConstructor();
			
			final Plugin result = constructor.newInstance();
			
			result.init(pluginManager, name, main);
			
			pluginManager.enablePlugin(result, name);
			
		} catch (final Exception e) {
			e.printStackTrace();
			log.info(e.getStackTrace().toString());
		}
		
	}
	
	public PluginManager getPluginManager() {
	
		return pluginManager;
	}
	
}
