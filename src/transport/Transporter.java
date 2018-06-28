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
	private final double maxWeight;
	private final double costPerKm;
	
	private Location location;
	private Cargo cargo;
	
	public Transporter(String id, double maxWeight, double costPerKm, Location firstLocation) {
		this.id = id;
		this.maxWeight = maxWeight;
		this.costPerKm = costPerKm;
		this.cargo = null;
		this.location = firstLocation;
	}
	
	Location getLocation() {
		return location;
	}

	void setLocation(Location location) {
		this.location = location;
	}

	Cargo getCargo() {
		return cargo;
	}

	void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	String getId() {
		return id;
	}

	double getMaxWeight() {
		return maxWeight;
	}

	double getCostPerKm() {
		return costPerKm;
	}
	
	// A transporter can only load solid or liquid cargo. The type of cargo is designated by a fake getter.
	// The transporter class defaults to solid cargo, this will be overwritten for TankTruck.
	CargoType getCargoType() {
		return solid;
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
		return "max. " + this.getMaxWeight() + " kg, in " + this.getLocation().getName() + ", cargo: " + this.shortCargo() + ".";
	}
	
		private String shortCargo() {
		if (this.getCargo() == null) {
			return "nothing";
		} else {
			return this.getCargo().getWeight() + " kg of " + this.getCargo().getLabel();
		}
	}

		@Override
	public String toString() {
		return this.toStringStart() + this.toStringEnd();
	}
		
	/*
	 * go to a different location, return travel costs.
	 */

	double goTo(Location destination) {
		double result = this.getLocation().getDistance(destination);
		result = result * costPerKm;
		this.setLocation(destination);
		return result;
	}
	
	/*
	 * Load and unload vehicle 
	 */
	
	// Load vehicle with cargo. 
	// First checks whether the vehicle isn't already carrying anything; then whether the cargo is of the right type;
	// finally whether the cargo exceeds max weight.
	void load(Cargo cargo) {
		if (this.getCargo() != null) {
			throw new IllegalStateException("Error: " + this.getId() + " is already carrying cargo.");
		} else if (cargo.getCargoType() != this.getCargoType()) {
			throw new IllegalArgumentException("Error: " + this.getId() + " is made for " + this.getCargoType() + " goods, but "
					+ cargo.getLabel() + " is " + cargo.getCargoType() + ".");
		} else if (cargo.getWeight() > this.getMaxWeight()) {
			throw new IllegalArgumentException("Error: " + cargo.getWeight() + " exceeds the maximum payload for " + this.getId() + ".");
		} else {
			this.setCargo(cargo);
		}
	}
	
	// Unload the vehicle. Returns the cargo. Checks whether vehicle is actually carrying something.
	Cargo unload() {
		Cargo result = this.cargo;
		if (result != null) {
			this.cargo = null;
		} else {
			throw new NullPointerException("Error: " + this.getId() + " isn't carrying anything.");
		}
		return result;
	}
}
