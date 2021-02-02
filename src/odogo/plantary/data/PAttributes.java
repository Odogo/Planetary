package odogo.plantary.data;

import odogo.plantary.Planetary;

public class PAttributes {

	private Planetary plugin;

	public PAttributes(Planetary plugin) {
		this.plugin = plugin;
	}

	public enum EPAttributes {
		ATMO_AIR_BASED, ATMO_AIR_REDUCT,
		DAMAGE_EVERY, DAMAGE_NO_AIR, DAMAGE_HELMET,
		TEMPERATURE,
		ROCKET_TIER
	}

	private boolean atmo_air_based = false;

	private double air_reduction = 1.0;
	private double damage_every = 2.0;
	private double damage_no_air = 2.0;
	private double damage_helmet = 2.0;
	private double temperature = 5.0;
	private double rocket_tier = 1.0;

	public boolean getBooleanValue(EPAttributes att) {
		switch(att) {
			case ATMO_AIR_BASED: return atmo_air_based;

			default: throw new IllegalArgumentException("Value is not a boolean or doesn't exist.");
		}
	}

	public double getDoubledValue(EPAttributes att) {
		switch(att) {
			case ATMO_AIR_REDUCT: return air_reduction;
			case DAMAGE_EVERY: return damage_every;
			case DAMAGE_HELMET: return damage_helmet;
			case DAMAGE_NO_AIR: return damage_no_air;
			case ROCKET_TIER: return rocket_tier;
			case TEMPERATURE: return temperature;

			default: throw new IllegalArgumentException("Value is not a double or doesn't exist.");
		}
	}

	public void setDoubledValue(EPAttributes att, double to) {
		switch(att) {
			case ATMO_AIR_REDUCT: air_reduction = to;
			case DAMAGE_EVERY: damage_every = to;
			case DAMAGE_HELMET: damage_helmet = to;
			case DAMAGE_NO_AIR: damage_no_air = to;
			case ROCKET_TIER: rocket_tier = to;
			case TEMPERATURE: temperature = to;

			default: throw new IllegalArgumentException("Value is a boolean");
		}
	}

	/** Replaces the current values with defaults.
	 * Defaults can be replaced inside the attributes.yml file.
	 */
	public void reloadDefaultFromConfiguration() {
		ConfigData data = plugin.getModules().getConfigData();

		atmo_air_based = data.getAttributeConfig().getBoolean("attributes.atmosphere.air-based");

		air_reduction = data.getAttributeConfig().getDouble("attributes.atmosphere.air-reduction");
		damage_every = data.getAttributeConfig().getDouble("attributes.damage.every");
		damage_helmet = data.getAttributeConfig().getDouble("attributes.damage.helmet-off");
		damage_no_air = data.getAttributeConfig().getDouble("attributes.damage.no-air");
		temperature = data.getAttributeConfig().getDouble("attributes.temperature");
		rocket_tier = data.getAttributeConfig().getDouble("attributes.rocket-tier");
	}

	public void reloadFromConfiguration(String world) {
		// TODO: Create configuration files for each world.
	}
}