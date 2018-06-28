package transport;

public class Plane extends Vehicle {
	
	

	private final double airportCost;

	public Plane(double costPerKm, double airportCost) {
		super(costPerKm);
		this.airportCost = airportCost;
	}
	
	double getAirportCost() {
		return airportCost;
	}
	
	@Override
	double getTravelCost(Location location, Location destination) {
		return super.getTravelCost(location, destination) + this.getAirportCost();
	}

}
