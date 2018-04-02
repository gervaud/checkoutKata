package com.lionel.supermarketcheckout;

import org.junit.Test;

public class ScannerTest {

	@Test(expected=IllegalArgumentException.class)
	public void scanANullItemForbidden() {
		Scanner scanner = new Scanner();
		scanner.scan(null);
	}
	
}
