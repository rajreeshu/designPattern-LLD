package parking.parkingLot;

import vehicle.VehicleType;

public interface ParkingLotFactory {
	ParkingLot getParkingLot(VehicleType vehicleType);
}
