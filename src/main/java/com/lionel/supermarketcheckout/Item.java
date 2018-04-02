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
		this.sku = sku;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
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
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}
	
	
	
}
