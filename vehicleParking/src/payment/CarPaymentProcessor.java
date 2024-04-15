package payment;

import payment.strategy.PerHourPricingStrategy;
import payment.strategy.PerMinutePricingStrategy;
import payment.strategy.PricingStrategy;
import payment.strategy.PricingStrategyFactory;

public class CarPaymentProcessor implements PaymentProcessor{
	private static final double RATE_PER_MINUTE = 0.10;  // Standard rate
    private static final double RATE_PER_HOUR = 4.00;    // Standard hourly rate
    private static final double DEFAULT_RATE = 25;
    
    private PricingStrategy pricingStrategy;
    
    public CarPaymentProcessor(long parkedTime) {
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
