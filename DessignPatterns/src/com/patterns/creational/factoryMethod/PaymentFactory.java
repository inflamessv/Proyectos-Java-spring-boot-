package com.patterns.creational.factoryMethod;

public class PaymentFactory  {

	public static Payment buildPayment(TypePayment typePayment) {
		switch (typePayment) {
	
		case GooglePayment: {
			
			return new GooglePayment();
		}
		case CreditCardPayment: {
			
			return new CreditCardPayment();
		}
		default:
			
			return new CreditCardPayment();
		}
		
	}
}
