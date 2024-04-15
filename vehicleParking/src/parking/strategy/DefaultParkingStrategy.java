package parking.strategy;

import java.util.List;

import parking.ParkingSpace;
import ticket.Ticket;
import vehicle.Vehicle;

public class DefaultParkingStrategy implements ParkingStrategy {

	@Override
	public Ticket park(List<ParkingSpace> spaces, Vehicle vehicle) {
		for (ParkingSpace space : spaces) {
			if (!space.isOccupied() && space.fit(vehicle)) {
				return new Ticket(vehicle, space);
			}
		}
		return null; // No available space
	}

}
