package parking;

import vehicle.Vehicle;

public abstract class ParkingSpace {
	private boolean isOccupied;
	private Vehicle vehicle;
	
	public abstract boolean fit(Vehicle vehicle);
	
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
