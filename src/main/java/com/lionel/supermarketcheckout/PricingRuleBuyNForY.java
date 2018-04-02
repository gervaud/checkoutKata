package com.lionel.supermarketcheckout;

/**
 * pricing rule of type : buy N for price Y (discount price)
 * 
 * @author lionelgervaud
 *
 */
public class PricingRuleBuyNForY implements PricingRule {
	
	private int regularPrice ;
	private int nbItemsForDiscount;
	private int discountPrice;

	/**
	 * 
	 * @param regularPrice the regular price without any discount
	 * @param nbItemsForDiscount the number of items needed to get the discountPrice
	 * @param discountPrice the discount price to apply for a nbItemsForDiscount number of items
	 */
	public PricingRuleBuyNForY(int regularPrice, int nbItemsForDiscount, int discountPrice) {
		// Check args
		if(regularPrice <= 0 || discountPrice <= 0) {
			throw new IllegalArgumentException("regularPrice and discountPrice must be greater than zero");
		}
		if(nbItemsForDiscount <= 1) {
			throw new IllegalArgumentException("nbItemsForDiscount must be greater than one");
		}
		
		this.regularPrice = regularPrice;
		this.nbItemsForDiscount = nbItemsForDiscount;
		this.discountPrice = discountPrice;
	}
	
	@Override
	public int calculatesPrice(int nbItems) {
		//calculate the discount price (if there is enough items) + price of remaining items
		return (nbItems/nbItemsForDiscount)*discountPrice + (nbItems%nbItemsForDiscount)*regularPrice;
	}
}
