package transport;

import static transport.CargoType.*;

/**
 * 
 * @author HAL
 *
 * Represents a cargo vehicle.
 */
abstract class Transporter {
	
	/*
	 * Fields, constructor, getters, setters
	 */
	
	private final String id;
	private Location location;
	
	public Transporter(String id, double maxWeight, Location firstLocation) {
		this.id = id;
		this.location = firstLocation;
	}
	
	Location getLocation() {
		return location;
	}

	void setLocation(Location location) {
		this.location = location;
	}

	String getId() {
		return id;
	}

	double getCostPerKm() {
		return getVehicle().getCostPerKm();
	}
	
	Vehicle getVehicle() {
		return null;
	}
	
	CargoBay getCargoBay() {
		return null;
	}
	
	// A transporter can only load solid or liquid cargo. The type of cargo is designated by a fake getter.
	// The transporter class defaults to solid cargo, this will be overwritten for TankTruck.
	CargoType getCargoType() {
		return this.getCargoBay().getCargoType();
	}
	
	/* 
	 * toString()
	 */
	
	// toString() gives the most important stats. It's assembled from some helper methods to make output more flexible.
	// (Specifically, for CargoPlane the airport cost is spliced in in the middle.)
	
	String toStringStart() {
		return this.id + ": " + this.getCostPerKm() + " E/km, ";
	}
	
	String toStringEnd() {
		return "max. " + this.getCargoBay().getMaxWeight() + " kg, in " + this.getLocation().getName() 
				+ ", cargo: " + getCargoBay().shortCargo() + ".";
	}
	

		@Override
	public String toString() {
		return this.toStringStart() + this.toStringEnd();
	}
		
	/*
	 * go to a different location, return travel costs.
	 */

	double goTo(Location destination) {
		this.setLocation(destination);
		return getVehicle().getTravelCost(this.getLocation(),destination);
	}
	
	/*
	 * Load and unload vehicle 
	 */
	
	void load(Cargo cargo) {
		this.getCargoBay().load(cargo);
	}
	
	
	// Unload the vehicle. Returns the cargo. Checks whether vehicle is actually carrying something.
	Cargo unload() {
		return this.getCargoBay().unload();
	}
	
}
