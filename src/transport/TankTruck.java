package transport;

import static transport.CargoType.*;

public class TankTruck extends Truck {
	
	final CargoBay cargoBay;

	
	public TankTruck(String id, double maxWeight, double costPerKm, Location firstLocation) {
		super(id, maxWeight, costPerKm, firstLocation);
		this.cargoBay = new CargoBay(maxWeight, liquid);
	}

	@Override
	CargoBay getCargoBay() {
		return cargoBay;
	}

}
