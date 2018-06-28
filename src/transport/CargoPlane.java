package transport;

public class CargoPlane extends Transporter {
	
	final Plane vehicle;
	
	public CargoPlane(String id, double maxWeight, double costPerKm, double airportCost, Location firstLocation) {
		super(id, maxWeight, firstLocation);
		this.vehicle = new Plane(costPerKm, airportCost);
	}

	double getAirportCost() {
		return vehicle.getAirportCost();
	}
	
	@Override
	Vehicle getVehicle() {
		return this.vehicle;
	}


	@Override
	public String toString() {
		return super.toStringStart() + "airport cost: " + this.getAirportCost() + ", " + super.toStringEnd();
	}
	
}
