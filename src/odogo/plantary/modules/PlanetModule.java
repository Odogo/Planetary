package odogo.plantary.modules;

import java.util.ArrayList;
import java.util.List;

import odogo.plantary.Planetary;
import odogo.plantary.data.PAttributes;
import odogo.plantary.object.Planet;

public class PlanetModule {

	private final Planetary plugin;

	private List<Planet> planets;

	public PlanetModule(Planetary plugin) {
		this.plugin = plugin;

		planets = new ArrayList<>();
	}

	@SuppressWarnings("deprecation")
	public Planet createPlanet(String name, PAttributes att) {
		Planet planet = new Planet(plugin, name, att);
		if(!planet.isValid()) return null;
		planets.add(planet); return planet;
	}

	public void deletePlanet(Planet planet) { planets.remove(planet); }

	public void deletePlanet(String name) {
		Planet planet = fetchPlanet(name); if(planet == null) return; planets.remove(planet);
	}

	public Planet fetchPlanet(String name) {
		for(Planet planet : planets)
			if(planet.getName().equals(name)) return planet;
		return null;
	}

	public List<Planet> getPlanets() { return planets; }
}
