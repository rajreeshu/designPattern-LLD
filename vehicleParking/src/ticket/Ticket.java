package ticket;

import parking.ParkingSpace;
import vehicle.Vehicle;

public class Ticket {
	private Vehicle vehicle;
	private long entryTime;
	private ParkingSpace parkingSpace;
	
	public Ticket(Vehicle vehicle, ParkingSpace parkingSpace) {
		this.vehicle=vehicle;
		this.entryTime=System.currentTimeMillis();
		this.parkingSpace=parkingSpace;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public long getEntryTime() {
		return entryTime;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	
	
	
	
}
