package transport;

public class Cargo {
	
	/**
	 * A cargo to be transported. 
	 * This class has the following fields:
	 * 	@param label
	 * 		String. A label designating the cargo.
	 *  @param cargoType
	 *  	CargoType (a self-defined enum with values "liquid" and "solid"). The type of the cargo.
	 *  @param weight
	 *  	double. Weight of the cargo.
	 *  
	 *  All fields are final. This class includes a constructor, getters and a toString() method.
	 */
	
	private final String label;
	private final CargoType cargoType;
	private final double weight;
	
	public Cargo(String label, CargoType cargoType, double weight) {
		this.label = label;
		this.cargoType = cargoType;
		this.weight = weight;
	}

	public String getLabel() {
		return label;
	}

	public CargoType getCargoType() {
		return cargoType;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Cargo [label=" + label + ", state=" + cargoType + ", weight=" + weight + "]";
	}
	
}
