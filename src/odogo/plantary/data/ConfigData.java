package odogo.plantary.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import odogo.plantary.Planetary;

public class ConfigData {

	private Planetary plugin;

	private File attFile;
	private FileConfiguration attConfig;

	public ConfigData(Planetary plugin) {
		this.plugin = plugin;
	}

	public boolean usingDefaultAttributes() { return plugin.getConfig().getBoolean("use-default-attributes"); }
	public boolean usingBuiltInAttributes() { return plugin.getConfig().getBoolean("use-built-in-attributes"); }

	/** Returns all natural strings from the "worlds" section in the config.
	 * @return List<String> names */
	public List<String> getWorldNames() {
		List<?> objs = plugin.getConfig().getList("worlds");
		List<String> list = new ArrayList<>();

		for(Object obj : objs) {
			if(!(obj instanceof String)) continue;
			list.add((String) obj);
		}

		return list;
	}

	/** Validate the existence of the world folder
	 * @param name - The name of a world.
	 * @return true, if exists | false, if not. */
	public boolean validateWorld(String name) {
		World world = plugin.getServer().getWorld(name);
		if(world != null) return true;

		NullPointerException e = new NullPointerException("'" + name + "' does not exist. Rename or check it's case.");
		e.printStackTrace(); return false;
	}

	public void reloadAttributeFile() {
		File file = new File(plugin.getDataFolder(), "attributes.yml");
		if(!plugin.getDataFolder().exists()) file.mkdirs();
		if(!file.exists()) plugin.saveResource("attributes.yml", true);

		attFile = file;
		attConfig = YamlConfiguration.loadConfiguration(file);
	}

	public FileConfiguration getAttributeConfig() { return attConfig; }
	public File getAttributeFile() { return attFile; }
}
