package org.sameer;

public class InvalidCardComparisonException extends Exception{
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		System.out.println("InvalidCardComparisonException: Cards of Different suit might be getting comparfed");
		super.printStackTrace();
	}
}
