package parking.parkingLot;

import java.util.ArrayList;

import parking.ParkingSpace;
import parking.strategy.ParkingStrategy;
import ticket.Ticket;
import vehicle.Vehicle;

public class MotorcycleParkingLot extends ParkingLot{

	public MotorcycleParkingLot(ArrayList<ParkingSpace> parkingSpace) {
		super(parkingSpace);
	}

	@Override
	public Ticket parkVehicle(Vehicle vehicle, ParkingStrategy parkingStrategy) {
		return parkingStrategy.park(spaces, vehicle);
	}

}
