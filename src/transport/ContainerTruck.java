package transport;

public class ContainerTruck extends Transporter {
	
	/*
	 * ContainerTruck is the default for all trucks. 
	 * Trucks can only travel over land, so the goTo() method is extended by a check whether 
	 * origin and destination are on the same continent.
	 */

	public ContainerTruck(String id, double maxWeight, double costPerKm, Location firstLocation) {
		super(id, maxWeight, costPerKm, firstLocation);
	}

	@Override
	double goTo(Location destination) {
		if (this.getLocation().reachableOverland(destination)) {
			return super.goTo(destination);
		} else {
			throw new IllegalArgumentException("Error: " + this.getId() + " is a truck and cannot travel overseas.");
		}
	}
}
