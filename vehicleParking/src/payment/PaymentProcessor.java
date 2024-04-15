package payment;

public interface PaymentProcessor {
	public abstract double calculateCharge(long parkedTime);

}
