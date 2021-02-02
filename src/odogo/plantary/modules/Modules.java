package odogo.plantary.modules;

import odogo.plantary.Planetary;
import odogo.plantary.data.ConfigData;

public class Modules {

	private Planetary plugin;
	private boolean loaded;

	private ConfigData data;

	public Modules(Planetary plugin) {
		this.plugin = plugin;
		loaded = false;
	}

	public void loadModules() {
		if(!loaded) return;
		loaded = true;

		this.data = new ConfigData(plugin);
	}

	public ConfigData getConfigData() { return data; }
}
