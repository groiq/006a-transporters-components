package transport;

public abstract class Truck extends Transporter {
	
	final Car vehicle;

	public Truck(String id, double maxWeight, double costPerKm, Location firstLocation) {
		super(id, maxWeight, firstLocation);
		this.vehicle = new Car(costPerKm);
	}
	
	@Override
	Vehicle getVehicle() {
		return this.vehicle;
	}
	

}
