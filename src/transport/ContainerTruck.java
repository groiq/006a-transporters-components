package transport;

import static transport.CargoType.*;

public class ContainerTruck extends Truck {
	
	final CargoBay cargoBay;

	public ContainerTruck(String id, double maxWeight, double costPerKm, Location firstLocation) {
		super(id, maxWeight, costPerKm, firstLocation);
		this.cargoBay = new CargoBay(maxWeight, solid);
	}

	@Override
	CargoBay getCargoBay() {
		return cargoBay;
	}

}
