package com.rocha;

public class Add2 {

	private final ValidNumber validNumber;
	private final Print print;
	

	public Add2() {
		super();
		this.validNumber = new ValidNumber();
		this.print = new Print();
	}


	public int add(Object a, Object b) {

		if (validNumber.check(a) && validNumber.check(b)) {
			return ((Integer) a) + (Integer) b;
		}

		return 0;

	}

	public int addInt(Object a) {
		return validNumber.doubleToInt(a) + validNumber.doubleToInt(a);
	}
	
	public void addPrint(Object a, Object b) {
		
		if (validNumber.check(a) && validNumber.check(b)) {
			int result =  ((Integer) a) + (Integer) b;
			print.showMessage(result);
			
		}else {
			print.showError();
			
		}

		
		
	}
}
