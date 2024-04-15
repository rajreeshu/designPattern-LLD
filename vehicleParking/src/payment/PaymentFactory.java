package payment;

import vehicle.VehicleType;

public class PaymentFactory implements PaymentProcessorFactory {

	@Override
	public PaymentProcessor getPaymentProcessor(VehicleType vehicleType, long parkedTime) {
		switch (vehicleType) {
		case CAR:
			return new CarPaymentProcessor(parkedTime);
		case MOTORCYCLE:
			return new MotorcyclePaymentProcessor(parkedTime);
		default:
			throw new IllegalArgumentException();
		}
	}

}
