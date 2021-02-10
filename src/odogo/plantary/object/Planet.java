package odogo.plantary.object;

import java.io.File;

import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import odogo.plantary.Planetary;
import odogo.plantary.data.PAttributes;
import odogo.plantary.util.FileUtil;
import odogo.plantary.util.except.PlanetaryWorldInvalidException;

public class Planet {

	private final Planetary plugin;

	private PAttributes attributes;
	private boolean invalid;

	private String name;
	private World world;

	/**
	 * Creates a new defined planet and it's settings.
	 *
	 * @see PlanetModule.createPlanet()
	 * @deprecated [Use PlanetModule.createPlanet() instead]
	 * @param plugin
	 * @param name
	 * @param attributes
	 */
	@Deprecated
	public Planet(Planetary plugin, String name, PAttributes attributes) {
		this.plugin = plugin;
		this.invalid = false;

		if(!plugin.getModules().getConfigData().validateWorld(name)) {
			if(!name.equals("Moon")) {
				PlanetaryWorldInvalidException e = new PlanetaryWorldInvalidException("World " + name + " is not listed as a world. Any attempt to access the planet will cause an error.");
				e.printStackTrace();
				this.invalid = true; return;
			} else {
				WorldCreator wc = new WorldCreator("Moon");
				wc.environment(Environment.NORMAL).generateStructures(false).hardcore(false);
				this.world = plugin.getServer().createWorld(wc);
			}
		} else this.world = plugin.getServer().getWorld(name);

		this.name = name;
		this.attributes = attributes;
	}

	public boolean isValid() { return !invalid; }

	public String getName() { if(isValid()) return name; return null; }
	public World getPlanetWorld() { if(isValid()) return world; return null;}
	public PAttributes getAttributes() { if(isValid()) return this.attributes; return null; }

	// -- File Management --
	public File getWorldFolder() {
		File folder = new File(plugin.getDataFolder(), "planets" + File.separator);
		if(!folder.exists()) folder.mkdirs();
		return folder;
	}

	public File getWorldFile() {
		if(!isValid()) return null;

		File file = new File(getWorldFolder(), name + ".yml");
		if(!file.exists()) FileUtil.copyFile(plugin.getModules().getConfigData().getAttributeFile(), file);
		return file;
	}

	public FileConfiguration getWorldConfig() { return YamlConfiguration.loadConfiguration(getWorldFile()); }
}
