package parking.parkingLot;

import vehicle.VehicleType;

public class ParkingSpotFactory implements ParkingLotFactory{
	private ParkingLot carParkingLot;
    private ParkingLot motorcycleParkingLot;
	
    public ParkingSpotFactory(ParkingLot carParkingLot, ParkingLot motorcycleParkingLot) {
		this.carParkingLot = carParkingLot;
		this.motorcycleParkingLot = motorcycleParkingLot;
	}

	@Override
	public ParkingLot getParkingLot(VehicleType vehicleType) {
		switch(vehicleType) {
		case CAR:
			return carParkingLot;
		case MOTORCYCLE:
			return motorcycleParkingLot;
		default:
			throw new IllegalArgumentException();
		}
	}
    
    
    
}
