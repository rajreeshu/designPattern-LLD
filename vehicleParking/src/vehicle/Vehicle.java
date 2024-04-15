package vehicle;

public abstract class Vehicle {
	private String vehicleNumber;
	private VehicleType vehicleType;
	
	public Vehicle(String vehicleNumber, VehicleType vehicleType) {
		this.vehicleNumber=vehicleNumber;
		this.vehicleType=vehicleType;
	}
	
	
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}



	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}



	public VehicleType getType() {
		return this.vehicleType;
	}
}

