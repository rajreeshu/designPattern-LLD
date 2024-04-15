package parking;

import vehicle.Vehicle;
import vehicle.VehicleType;

public class CarSpace extends ParkingSpace{

	@Override
	public boolean fit(Vehicle vehicle) {
		return vehicle.getType() == VehicleType.CAR;
	}
	
}
