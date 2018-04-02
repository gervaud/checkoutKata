package com.lionel.supermarketcheckout;

/**
 * Interface for a pricing rule
 * 
 * @author lionelgervaud
 */
public interface PricingRule {

	/**
	 * Calculate the price of nbItems items
	 * @param nbItems number of items 
	 * @return a price
	 */
	public int calculatesPrice(int nbItems);
	
}
