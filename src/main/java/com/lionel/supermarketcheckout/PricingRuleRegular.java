package com.lionel.supermarketcheckout;

/**
 * 
 * @author lionelgervaud
 */
public class PricingRuleRegular implements PricingRule {
	private int price;
	
	public PricingRuleRegular(int price) {
		if(price <= 0) {
			throw new IllegalArgumentException("price must be greater than zero");
		}
		this.price = price;
	}
	
	@Override
	public int calculatesPrice(int nbItems) {
		return nbItems * price;
	}
}
