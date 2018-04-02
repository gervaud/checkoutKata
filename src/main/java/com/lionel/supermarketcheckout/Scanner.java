package com.lionel.supermarketcheckout;

import java.util.HashMap;
import java.util.Map;

/**
 * Class used to manage the scanning process of Items
 * 
 * @author lionelgervaud
 */
public class Scanner {

	private Map<Item, Integer> scannedItems = new HashMap<>();
	
	/**
	 * Scan an item
	 * @param item
	 */
	public void scan(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null");
		}
		Integer nbScannedItems = scannedItems.get(item);
		if(nbScannedItems == null) {
			nbScannedItems = 0;
		}
		scannedItems.put(item, nbScannedItems + 1);
	}
	
	/**
	 * 
	 * @return a map of Item associated with the number of this Item scanned
	 */
	public Map<Item, Integer> getScannedItems() {
		return scannedItems;
	}
	
}
