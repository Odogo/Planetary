package odogo.plantary.object;

import org.bukkit.World;

import odogo.plantary.data.PAttributes;

public class Planet {

	private World containingWorld;
	private PAttributes attributes;

	public Planet(World containingWorld, PAttributes attributes) {
		this.containingWorld = containingWorld;
		this.attributes = attributes;
	}

	public World getPlanetWorld() { return this.containingWorld; }
	public PAttributes getAttributes() { return this.attributes; }


}
