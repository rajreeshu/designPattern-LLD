package payment.strategy;

public class PricingStrategyFactory implements PricingFactory{
	private long parkedTime;
	
	public PricingStrategyFactory(long parkedTime) {
		this.parkedTime = parkedTime;
	}
	
	@Override
	public PricingStrategy getPricingStrategy() {
		if(parkedTime<10) {
			return new DefaultPricingStrategy();
		}else if(parkedTime<120) {
			return new PerMinutePricingStrategy();
		}else {
			return new PerHourPricingStrategy();
		}
	}

	
	
}
