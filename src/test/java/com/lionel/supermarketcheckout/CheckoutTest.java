package com.lionel.supermarketcheckout;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {
	
	Checkout checkout ;

	@Before
	public void setup() {
		checkout = new Checkout();
		Map<Item, PricingRule> priceRules = new HashMap<>();
		priceRules.put(new Item("A"), new PricingRuleBuyNForY(50, 3, 130));
		priceRules.put(new Item("B"), new PricingRuleBuyNForY(30, 2, 45));
		priceRules.put(new Item("C"), new PricingRuleRegular(20));
		priceRules.put(new Item("D"), new PricingRuleRegular(15));
		priceRules.put(new Item("X"), new PricingRuleRegular(150));
		checkout.startTransaction(priceRules);
	}
	
	@Test
	public void whenNoItemIsScannedThenTotalIs0() {
		int expectedTotal = 0;
		int total = checkout.calculatesTotal();
		assertEquals(expectedTotal, total);
	}
	
	@Test
	public void whenItemAIsScannedThenTotalIs50() {
		int expectedTotal = 50;
		checkout.scan(new Item("A"));
		int total = checkout.calculatesTotal();
		assertEquals(expectedTotal, total);
	}
	
	
	@Test
	public void whenItemBIsScannedThenTotalIs30() {
		int expectedTotal = 30;
		checkout.scan(new Item("B"));
		int total = checkout.calculatesTotal();
		assertEquals(expectedTotal, total);
	}
	
	@Test
	public void whenItemAAndBAreScannedThenTotalIs80() {
		int expectedTotal = 80;
		checkout.scan(new Item("A"));
		checkout.scan(new Item("B"));
		int total = checkout.calculatesTotal();
		assertEquals(expectedTotal, total);
	}
	
	
	@Test
	public void when3ItemsAAreScannedThenTotalIs130() {
		int expectedTotal = 130;
		checkout.scan(new Item("A"));
		checkout.scan(new Item("A"));
		checkout.scan(new Item("A"));
		int total = checkout.calculatesTotal();
		assertEquals(expectedTotal, total);
	}
	
	@Test
	public void whenBthenAthenBAreScannedThenTotalIs95() {
		int expectedTotal = 95;
		checkout.scan(new Item("B"));
		checkout.scan(new Item("A"));
		checkout.scan(new Item("B"));
		int total = checkout.calculatesTotal();
		assertEquals(expectedTotal, total);
	}
	
	@Test
	public void when3ItemsAAndBAndCAreScannedThenTotalIs165() {
		int expectedTotal = 165;
		checkout.scan(new Item("A"));
		checkout.scan(new Item("A"));
		checkout.scan(new Item("A"));
		checkout.scan(new Item("C"));
		checkout.scan(new Item("D"));
		int total = checkout.calculatesTotal();
		assertEquals(expectedTotal, total);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void scanItemWithNoPricingRule() {
		checkout.scan(new Item("Z"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void startToScanWithoutTransactionStarted() {
		Checkout checkout = new Checkout();
		checkout.scan(new Item("A"));
	}
	
}
