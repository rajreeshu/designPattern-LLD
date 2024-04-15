package main;

import java.util.ArrayList;
import java.util.logging.Logger;

import gates.EntryGate;
import gates.ExitGate;
import parking.CarSpace;
import parking.MotorcycleSpace;
import parking.ParkingSpace;
import parking.parkingLot.CarParkingLot;
import parking.parkingLot.MotorcycleParkingLot;
import parking.parkingLot.ParkingLot;
import parking.parkingLot.ParkingLotFactory;
import parking.parkingLot.ParkingSpotFactory;
import parking.strategy.NearToElevatorStrategy;
import parking.strategy.NearToEntranceStrategy;
import ticket.Ticket;
import vehicle.Car;
import vehicle.Motorcycle;
import vehicle.Vehicle;

public class ParkingSimulation {
		public static void main(String[] args) {
			Logger logger = Logger.getLogger(ParkingSimulation.class.getName());
			// Create a parking lot
			ArrayList<ParkingSpace> carSpaceList = new ArrayList<>();
			carSpaceList.add(new CarSpace());
			carSpaceList.add(new CarSpace());
			
			ArrayList<ParkingSpace> motorcycleSpaceList = new ArrayList<>();
			motorcycleSpaceList.add(new MotorcycleSpace());
			motorcycleSpaceList.add(new MotorcycleSpace());
			
			ParkingLot carParkingLot = new CarParkingLot(carSpaceList);
			ParkingLot motorcycleParkingLot = new MotorcycleParkingLot(motorcycleSpaceList);

			ParkingSpotFactory parkingSpotFactory = new ParkingSpotFactory(carParkingLot, motorcycleParkingLot);
			
			// Create an entry gate
			EntryGate entryGate = new EntryGate(parkingSpotFactory);

			// Create an exit gate
			ExitGate exitGate = new ExitGate(carParkingLot, motorcycleParkingLot);

			// Simulate vehicle entry
			Vehicle car = new Car("CAR123");
			Vehicle motorcycle = new Motorcycle("BIKE456");
			
			logger.warning("Car and Bike Added.");

			// Park the vehicles
			Ticket carTicket = entryGate.enter(car, new NearToElevatorStrategy());
			Ticket bikeTicket = entryGate.enter(motorcycle, new NearToEntranceStrategy());

			// Simulate some time passing (this example uses fixed time)
			try {
				Thread.sleep(400); // Sleep for 3 seconds to simulate parking duration
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}

			// Process vehicle exits
			double carCharge = exitGate.exitVehicle(carTicket);
			double bikeCharge = exitGate.exitVehicle(bikeTicket);

			// Display the charges
			System.out.println("Charge for car (CAR123): $" + String.format("%.2f", carCharge));
			System.out.println("Charge for motorcycle (BIKE456): $" + String.format("%.2f", bikeCharge));
		}

}
