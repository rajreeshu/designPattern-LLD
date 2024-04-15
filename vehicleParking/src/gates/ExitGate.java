package gates;

import parking.parkingLot.ParkingLot;
import payment.PaymentFactory;
import payment.PaymentProcessor;
import ticket.Ticket;

public class ExitGate {
	private ParkingLot carParkingLot;
	private ParkingLot motorcycleParkingLot;
	private PaymentFactory paymentFactory;

	public ExitGate(ParkingLot carParkingLot, ParkingLot motorcycleParkingLot) {
		this.carParkingLot = carParkingLot;
		this.motorcycleParkingLot = motorcycleParkingLot;
		this.paymentFactory = new PaymentFactory();
	}

	public double exitVehicle(Ticket ticket) {
		long parkedTime = (System.currentTimeMillis() - ticket.getEntryTime()) / 60;
		double amountDue = paymentFactory.getPaymentProcessor(ticket.getVehicle().getType(), parkedTime).calculateCharge(parkedTime);
		switch (ticket.getVehicle().getType()) {
		case CAR:
			carParkingLot.releaseSpace(ticket);
		case MOTORCYCLE:
			motorcycleParkingLot.releaseSpace(ticket);
		}
		return amountDue;
	}

}
