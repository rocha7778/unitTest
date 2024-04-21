package com.rocha.email.service;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class MyApplicationTest {
	
	private MyApplication myApplication;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		myApplication = new MyApplication();
	}
	
	

}
