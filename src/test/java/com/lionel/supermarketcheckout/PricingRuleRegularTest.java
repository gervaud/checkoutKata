package com.lionel.supermarketcheckout;

import org.junit.Test;

public class PricingRuleRegularTest {

	
	@Test(expected = IllegalArgumentException.class)
	public void priceMustBeGreaterThanZero() {
		@SuppressWarnings("unused")
		PricingRuleRegular pricingRuleRegular = new PricingRuleRegular(0);
	}
	
}
