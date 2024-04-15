package parking;

import vehicle.Vehicle;
import vehicle.VehicleType;

public class MotorcycleSpace extends ParkingSpace{

	@Override
	public boolean fit(Vehicle vehicle) {
		return vehicle.getType()==VehicleType.MOTORCYCLE;
	}

	
}
