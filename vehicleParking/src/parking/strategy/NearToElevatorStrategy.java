package parking.strategy;

import java.util.List;

import parking.ParkingSpace;
import ticket.Ticket;
import vehicle.Vehicle;

public class NearToElevatorStrategy implements ParkingStrategy {

	@Override
	public Ticket park(List<ParkingSpace> spaces, Vehicle vehicle) {
		for (int i = spaces.size() - 1; i >= 0; i--) {
			ParkingSpace space = spaces.get(i);
			if (!space.isOccupied() && space.fit(vehicle)) {
				return new Ticket(vehicle, space);
			}
		}
		return null; // No available space
	}

}
