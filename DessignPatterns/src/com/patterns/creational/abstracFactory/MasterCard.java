package com.patterns.creational.abstracFactory;

public class MasterCard implements Card{

	@Override
	public String getCardNumber() {
		// TODO Auto-generated method stub
		return "MASTERCARD";
	}

	@Override
	public String getCardType() {
		// TODO Auto-generated method stub
		return "000 000 MASTER CARD";
	}

}
