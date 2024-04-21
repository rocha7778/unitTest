package com.rocha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Nested;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class AddTestAnnotation {

	@InjectMocks
	private Add add;

	@Mock
	private ValidNumber validNumber;
	
	@Mock
	private Print print;
	
	@Mock
	private List<Integer> list = new ArrayList<>();
	
	@Spy
	private List<Integer> listSpy = new ArrayList<>();
	
	
	
	
	@Captor
	private ArgumentCaptor<Integer> captor;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		add = new Add(validNumber, print);
	}

	@After
	public void tearDown() {
		validNumber = null;
	}
	
	@Test
	public void addElementToList() {
		when(list.size()).thenReturn(3);
		
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		
		assertEquals(3, list.size());
	}
	
	@Test
	public void addElementToListSpy() {
		
		listSpy.add(1);
		listSpy.add(1);
		listSpy.add(1);
		listSpy.add(1);
		listSpy.add(1);
		
		assertEquals(5, listSpy.size());
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

	@Test
	public void addTest() {

		when(validNumber.check(3)).thenReturn(true);
		when(validNumber.check(2)).thenReturn(true);

		add.add(3, 2);
		Mockito.verify(validNumber).check(3);
		Mockito.verify(validNumber).check(2);

	}

	@Test
	public void addTestZero() {

		when(validNumber.check(3)).thenReturn(true);
		when(validNumber.check(2)).thenReturn(true);

		add.add(3, 2);
		Mockito.verify(validNumber).check(3);
		Mockito.verify(validNumber).check(2);

	}

	@Test
	public void addMockExceptionTest() {

		when(validNumber.check(0)).thenThrow(new ArithmeticException());
		assertThrows(ArithmeticException.class, () -> add.add(0, 2));

	}

	@Test
	public void addMockExceptionTest2() {

		when(validNumber.check(0)).thenThrow(new ArithmeticException());
		try {
			add.add(0, 2);
		} catch (Exception e) {
			assertNotNull(e);
		}

	}

	@Test
	public void addDoubleToInt() {

		Answer<Integer> answer = new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				return 7;
			}

		};

		when(validNumber.doubleToInt(7.77)).then(answer);
		assertEquals(14, add.addInt(7.77));
	}
	
	@Test
	public void addDoubleToIntZero() {

		Answer<Integer> answer = new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				return 0;
			}

		};

		when(validNumber.doubleToInt(7.77)).then(answer);
		
		assertEquals(0, add.addInt("a"));
	}
	
	@Test
	public void addTestAnyMatcher() {

		when(validNumber.check(anyInt())).thenReturn(true);

		add.add(3, 2);
		Mockito.verify(validNumber).check(2);
		Mockito.verify(validNumber).check(3);

	}
	
	@Test
	public void addTestPrint() {
		when(validNumber.check(anyInt())).thenReturn(true);
		add.addPrint(4, 4);
		
		Mockito.verify(validNumber, Mockito.times(2)).check(4);
		Mockito.verify(print, Mockito.times(1)).showMessage(8);
		Mockito.verify(print, Mockito.never()).showError();
		
	}
	
	@Test
	public void addTestPrintCaptor() {
		when(validNumber.check(anyInt())).thenReturn(true);
		add.addPrint(4, 4);
		
		Mockito.verify(validNumber, Mockito.times(2)).check(4);
		Mockito.verify(print, Mockito.times(1)).showMessage(captor.capture());
		Mockito.verify(print, Mockito.never()).showError();
		
	}
	
	@Nested
	public class Rocha {
		
	}

}
