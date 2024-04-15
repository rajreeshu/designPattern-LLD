package parking.parkingLot;

import java.util.ArrayList;

import parking.ParkingSpace;
import parking.strategy.ParkingStrategy;
import ticket.Ticket;
import vehicle.Vehicle;

public class CarParkingLot extends ParkingLot{
	
	public CarParkingLot(ArrayList<ParkingSpace> spaces) {
		super(spaces);
	}

	@Override
	public Ticket parkVehicle(Vehicle vehicle, ParkingStrategy parkingStrategy) {
		return parkingStrategy.park(spaces, vehicle);
	}
}
