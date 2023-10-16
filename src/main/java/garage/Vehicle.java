package garage;

public class Vehicle {
	
	private String make;
	private String model;
	private String vehiclePlate;
	private String engineType;
	
	public Vehicle(String make, String model, String vehiclePlate, String engineType) {
		super();
		this.make = make;
		this.model = model;
		this.vehiclePlate = vehiclePlate;
		this.engineType = engineType;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVehiclePlate() {
		return vehiclePlate;
	}

	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	

	
}
