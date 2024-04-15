package gates;

import parking.parkingLot.ParkingLot;
import parking.parkingLot.ParkingLotFactory;
import parking.strategy.ParkingStrategy;
import ticket.Ticket;
import vehicle.Vehicle;

public class EntryGate {
	private ParkingLotFactory parkingLotFactory;

	public EntryGate(ParkingLotFactory parkingLotFactory) {
		this.parkingLotFactory=parkingLotFactory;
	}
	
	public Ticket enter(Vehicle vehicle, ParkingStrategy parkingStrategy) {
		ParkingLot parkingLot = parkingLotFactory.getParkingLot(vehicle.getType());
		return parkingLot.parkVehicle(vehicle, parkingStrategy);
	}
	
}
