package com.rocha;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AddTest2 {
	
	private Add2 add;
	private ValidNumber validNumber;
	private Print print;
	
	
	@Before
	public void setUp() {
		
		validNumber = Mockito.mock(ValidNumber.class);
		print = Mockito.mock(Print.class);
		add = new Add2();
	}
	
	@After
	public void tearDown() {
		add = null;
		
	}
	
	
	@Test
	public void addShuldREturn5AsaResult() {
		
		when(validNumber.check(any())).thenReturn(true);
		int result = add.add(3, 2);
		assertEquals(5, result);
		
	}
	
	@Test
	public void addVerifyCallMethod() {
		add.add(3, 2);
		Mockito.verify(validNumber).check(3);
	}

}
