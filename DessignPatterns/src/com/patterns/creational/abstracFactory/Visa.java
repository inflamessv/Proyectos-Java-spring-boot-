package com.patterns.creational.abstracFactory;

public class Visa implements Card{

	@Override
	public String getCardNumber() {
		// TODO Auto-generated method stub
		return "VISA";
	}

	@Override
	public String getCardType() {
		// TODO Auto-generated method stub
		return "000 000 000 VISA";
	}

}
