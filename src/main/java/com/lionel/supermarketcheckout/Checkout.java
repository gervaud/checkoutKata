package com.lionel.supermarketcheckout;

import java.util.HashMap;
import java.util.Map;

/**
 * Main class of checkout kata
 * 
 * @author lionelgervaud
 *
 */
public class Checkout {

	private Map<Item, PricingRule> pricingRules ;
	private Scanner scanner;

	public Checkout() {
		scanner = new Scanner();
		pricingRules = new HashMap<>();
	}
	
	/**
	 * Start a new transaction given a Map of PricingRules
	 * @param pricingRules association between an item and a PricingRule
	 */
	public void startTransaction(Map<Item, PricingRule> pricingRules) {
		this.pricingRules = pricingRules;
	}
	
	/**
	 * Scan an item
	 * @param item must not be null
	 */
	public void scan(Item item) {
		if(pricingRules.get(item) == null) {
			throw new IllegalArgumentException("a scanned item has no pricing rule");
		}
		scanner.scan(item);
	}
	
	/**
	 * 
	 * @return the price of all scanned items
	 */
	public int calculatesTotal() {
		return scanner.getScannedItems().entrySet().stream()
				.mapToInt(itemEntry -> 
					pricingRules.get(itemEntry.getKey()).calculatesPrice(itemEntry.getValue())
					)
				.sum();
	}
	
}
