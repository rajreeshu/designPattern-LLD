package payment;

import payment.strategy.PerHourPricingStrategy;
import payment.strategy.PerMinutePricingStrategy;
import payment.strategy.PricingStrategy;
import payment.strategy.PricingStrategyFactory;

public class MotorcyclePaymentProcessor implements PaymentProcessor{

	private static final double RATE_PER_MINUTE = 0.06;  // Standard rate
    private static final double RATE_PER_HOUR = 2.5;    // Standard hourly rate
    private static final double DEFAULT_RATE = 15;
    
    private PricingStrategy pricingStrategy;
    
    public MotorcyclePaymentProcessor(long parkedTime) {
		pricingStrategy = new PricingStrategyFactory(parkedTime).getPricingStrategy();
	}
    
	@Override
	public double calculateCharge(long parkedTime) {
		if(pricingStrategy instanceof PerMinutePricingStrategy) {
			return parkedTime*RATE_PER_MINUTE;
		}else if(pricingStrategy instanceof PerHourPricingStrategy) {
			return parkedTime*RATE_PER_HOUR;
		}else {
			return DEFAULT_RATE;
		}
	}

	
}
