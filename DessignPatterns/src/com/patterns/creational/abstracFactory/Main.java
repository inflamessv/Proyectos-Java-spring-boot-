package com.patterns.creational.abstracFactory;

import com.patterns.creational.factoryMethod.Payment;
import com.patterns.creational.factoryMethod.PaymentFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		probarAbstractFactory();
	}

	public static void probarAbstractFactory() {
		AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
		Card tarjeta=(Card)abstractFactory.create("VISA");
		
		AbstractFactory abstractFactory2 = FactoryProvider.getFactory("PaymentMethod");
		PaymentMethod payment = (PaymentMethod)abstractFactory2.create("DEBIT");
		
		System.out.println("Una tarjeta de tipo: "+tarjeta.getCardType() +"con el metodo pago: "+payment.doPayment());
	} 
	
	
	
}
