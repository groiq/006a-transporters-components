package transport;

import static transport.CargoType.*;

public class TankTruck extends ContainerTruck {
	
	/*
	 * A subclass of ContainerTruck for transporting liquid cargo.
	 * Overrides the getCargoType() method.
	 */
	
	public TankTruck(String id, double maxWeight, double costPerKm, Location firstLocation) {
		super(id, maxWeight, costPerKm, firstLocation);
	}

	@Override
	CargoType getCargoType() {
		return liquid;
	}
}
