package odogo.plantary;

import org.bukkit.plugin.java.JavaPlugin;

import odogo.plantary.modules.Modules;

public class Planetary extends JavaPlugin {

	private Modules modules;

	@Override public void onLoad() {

	}

	@Override public void onEnable() {
		this.modules = new Modules(this);
		modules.loadModules();
	}

	@Override public void onDisable() {

	}

	public Modules getModules() { return modules; }
}
