package com.patterns.creational.factoryMethod;

public class Main {

	public static void main(String[] args) {
		probarFactoryMethod();
	}
	
	public static void probarFactoryMethod() {
		Payment payment=PaymentFactory.buildPayment(TypePayment.GooglePayment);
		payment.payment();
	}

}
