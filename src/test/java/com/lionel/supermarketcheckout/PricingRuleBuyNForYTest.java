package com.lionel.supermarketcheckout;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PricingRuleBuyNForYTest {

	@Test(expected = IllegalArgumentException.class)
	public void regularPriceMustBeGreaterThanZero() {
		@SuppressWarnings("unused")
		PricingRuleBuyNForY pricingRuleBuyNForY = new PricingRuleBuyNForY(0, 2, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void regularPriceMustBePositive() {
		@SuppressWarnings("unused")
		PricingRuleBuyNForY pricingRuleBuyNForY = new PricingRuleBuyNForY(-1, 2, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void discountPriceMustBeGreaterThanZero() {
		@SuppressWarnings("unused")
		PricingRuleBuyNForY pricingRuleBuyNForY = new PricingRuleBuyNForY(1, 1, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nbItemsForDiscountMustBeGreaterThanOne() {
		@SuppressWarnings("unused")
		PricingRuleBuyNForY pricingRuleBuyNForY = new PricingRuleBuyNForY(1, 1, 1);
	}

	@Test
	public void calculatePriceForZeroItemReturnZero() {
		PricingRuleBuyNForY pricingRuleBuyNForY = new PricingRuleBuyNForY(1, 2, 1);
		assertEquals(Long.valueOf(0), Long.valueOf(pricingRuleBuyNForY.calculatesPrice(0)));
	}
	
}
