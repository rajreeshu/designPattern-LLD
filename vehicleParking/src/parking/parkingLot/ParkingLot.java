package parking.parkingLot;

import java.util.ArrayList;
import java.util.List;

import parking.ParkingSpace;
import parking.strategy.ParkingStrategy;
import ticket.Ticket;
import vehicle.Vehicle;

public abstract class ParkingLot {
	protected List<ParkingSpace> spaces = new ArrayList<>();

	public ParkingLot(ArrayList<ParkingSpace> parkingSpace) {
		spaces.addAll(parkingSpace);
	}
	
	public abstract Ticket parkVehicle(Vehicle vehicle, ParkingStrategy parkingStrategy);
	
	public void releaseSpace(Ticket ticket) {
		ticket.getParkingSpace().setOccupied(false);
		ticket.getParkingSpace().setVehicle(null);
	}
}
