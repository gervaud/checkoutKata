package com.lionel.supermarketcheckout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;


public class ItemTest {

	@Test
	public void itemSkuAEqualsItemSkuA() {
		Item itemA = new Item("A");
		Item itemA2 = new Item("A");
		assertEquals(itemA, itemA2);
	}

	@Test
	public void itemSkuANotEqualsItemSkuB() {
		Item itemA = new Item("A");
		Item itemB = new Item("B");
		assertNotEquals(itemA, itemB);
	}
	
	@Test
	public void itemSkuANotEqualsOtherObject() {
		Item itemA = new Item("A");
		Object object = new Object();
		assertNotEquals(itemA, object);
	}
}
