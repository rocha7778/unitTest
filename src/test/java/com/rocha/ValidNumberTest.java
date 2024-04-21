package com.rocha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidNumberTest {

	private ValidNumber validNumber;

	@Before
	public void setUp() {
		validNumber = new ValidNumber();
	}

	@After
	public void tearDown() {
		validNumber = null;
	}

	@Test
	public void checkWhenTheParameterIsANumberandIsBetWeen0And10() {

		Object o = 1;
		boolean result = validNumber.check(o);
		assertTrue(result);
	}

	@Test
	public void checkWhenTheParameterIsANegativeNumber() {

		Object o = -1;
		boolean result = validNumber.check(o);
		assertFalse(result);
	}

	@Test
	public void checkWhenTheParameterIsAString() {

		Object o = "hola";
		boolean result = validNumber.check(o);
		assertFalse(result);
	}

	@Test
	public void checkZeroTrue() {
		ArithmeticException ae = null;
		try {
			validNumber.checkZero(0);
		} catch (Exception e) {

			ae = (ArithmeticException) e;
		}
		
		assertEquals("Zero not allowed", ae.getMessage());
	}

	@Test
	public void checkZeroTrowException() {
		assertThrows(ArithmeticException.class, () -> validNumber.checkZero(0));
	}

	@Test
	public void doubleToIntTest() {
		assertEquals(3, validNumber.doubleToInt(Double.valueOf(3.33)));
	}

	@Test
	public void doubleToInRetunZero() {
		assertEquals(0, validNumber.doubleToInt("a"));
	}

}
