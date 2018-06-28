package transport;

abstract class Vehicle {
	
	private final double costPerKm;
	
	public Vehicle(double costPerKm) {
		this.costPerKm = costPerKm;
	}
	
	double getCostPerKm() {
		return costPerKm;
	}

	double getTravelCost(Location location, Location destination) {
		double result = location.getDistance(destination);
		return result * this.getCostPerKm();
	}

}
