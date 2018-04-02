package com.lionel.supermarketcheckout;

/**
 * An item is identied by a SKU (stock keeping unit)
 * 
 * @author lionelgervaud
 *
 */
public class Item {

	private String sku;
	
	public Item(String sku) {
		if(sku == null) {
			throw new IllegalArgumentException("An item is identied by a SKU (stock keeping unit)");
		}
		this.sku = sku;
	}

	@Override
	public int hashCode() {
		return 31 + sku.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return sku.equals(other.sku);
	}
	
	
	
}
