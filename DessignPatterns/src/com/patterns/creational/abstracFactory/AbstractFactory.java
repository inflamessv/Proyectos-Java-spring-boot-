package com.patterns.creational.abstracFactory;

public interface AbstractFactory<T> {
	T create(String type);
}
