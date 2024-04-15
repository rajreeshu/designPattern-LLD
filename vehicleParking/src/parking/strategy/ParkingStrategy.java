package parking.strategy;

import java.util.List;

import parking.ParkingSpace;
import ticket.Ticket;
import vehicle.Vehicle;

public interface ParkingStrategy {
	
	public Ticket park(List<ParkingSpace> spaces, Vehicle vehicle);
}
