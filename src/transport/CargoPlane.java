package transport;

import static transport.CargoType.*;

public class CargoPlane extends Transporter {
	
	final Plane vehicle;
	final CargoBay cargoBay;
	
	public CargoPlane(String id, double maxWeight, double costPerKm, double airportCost, Location firstLocation) {
		super(id, maxWeight, firstLocation);
		this.vehicle = new Plane(costPerKm, airportCost);
		this.cargoBay = new CargoBay(maxWeight, solid);
	}

	double getAirportCost() {
		return vehicle.getAirportCost();
	}
	
	@Override
	Vehicle getVehicle() {
		return this.vehicle;
	}

	@Override
	CargoBay getCargoBay() {
		return cargoBay;
	}

	@Override
	public String toString() {
		return super.toStringStart() + "airport cost: " + this.getAirportCost() + ", " + super.toStringEnd();
	}
	
}
