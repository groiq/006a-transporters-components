package transport;

public class CargoPlane extends Transporter {
	
	/*
	 * Represents a cargo plane.
	 * Has an additional field named airportCost that represents a fixed cost per journey.
	 * Constructor and toString() are expanded accordingly.
	 * The goTo() method adds the airportCost to the result of super.goTo().
	 */
	
	private final double airportCost;

	public CargoPlane(String id, double maxWeight, double costPerKm, double airportCost, Location firstLocation) {
		super(id, maxWeight, costPerKm, firstLocation);
		this.airportCost = airportCost;
	}

	double getAirportCost() {
		return airportCost;
	}

	@Override
	double goTo(Location destination) {
		return super.goTo(destination) + this.getAirportCost();
	}

	@Override
	public String toString() {
		return super.toStringStart() + "airport cost: " + this.getAirportCost() + ", " + super.toStringEnd();
	}
	
}
