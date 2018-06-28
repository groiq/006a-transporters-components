package transport;

import static transport.CargoType.*;

class CargoBay {
	
	private final double maxWeight;
	private final CargoType cargoType;
	private Cargo cargo;

	public CargoBay(double maxWeight, CargoType cargoType) {
		this.maxWeight = maxWeight;
		this.cargoType = cargoType;
	}

	CargoType getCargoType() {
		return cargoType;
	}

	Cargo getCargo() {
		return cargo;
	}

	void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	double getMaxWeight() {
		return maxWeight;
	}
	
	String shortCargo() {
		if (this.getCargo() == null) {
			return "nothing";
		} else {
			return this.getCargo().getWeight() + " kg of " + this.getCargo().getLabel();
		}
	}
	

	void load(Cargo cargo) {
		if (this.getCargo() != null) {
			throw new IllegalStateException("Error: This transporter is already carrying cargo.");
		} else if (cargo.getCargoType() != this.getCargoType()) {
			throw new IllegalArgumentException("Error: This transporter is made for " + this.getCargoType() + " goods, but "
					+ cargo.getLabel() + " is " + cargo.getCargoType() + ".");
		} else if (cargo.getWeight() > this.getMaxWeight()) {
			throw new IllegalArgumentException("Error: " + cargo.getWeight() + " exceeds the maximum payload for this transporter.");
		} else {
			this.setCargo(cargo);
		}
	}

	Cargo unload() {
		Cargo result = this.cargo;
		if (result != null) {
			this.cargo = null;
		} else {
			throw new NullPointerException("Error: This transporter isn't carrying anything.");
		}
		return result;
	}

}
