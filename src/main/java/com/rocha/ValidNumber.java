package com.rocha;

public class ValidNumber {

	public boolean check(Object o) {

		if (o instanceof Integer n) {
			if (n <= 10 && n >= 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkZero(Object o) {
		if (o instanceof Integer n) {
			if (n == 0) {
				throw new ArithmeticException("Zero not allowed");
			}
		}
		return true;
	}
	
	
	public int doubleToInt (Object o) {
		
		if (o instanceof Double n) {
			return n.intValue();
		}
		
		return 0;
		
	}

}
