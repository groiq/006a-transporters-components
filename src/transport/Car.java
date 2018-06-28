package transport;

public class Car extends Vehicle {

	public Car(double costPerKm) {
		super(costPerKm);
		
	}
	
	@Override
	double getTravelCost(Location location, Location destination) {
		if (destination.reachableOverland(location)) {
			return super.getTravelCost(location, destination);
		} else {
			throw new IllegalArgumentException("Error: This is a truck and cannot go overseass.");
		}
	}

}
