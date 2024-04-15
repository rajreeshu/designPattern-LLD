package payment;

import vehicle.VehicleType;

public interface PaymentProcessorFactory {
	PaymentProcessor getPaymentProcessor(VehicleType vehicleType, long parkedTime);
}
