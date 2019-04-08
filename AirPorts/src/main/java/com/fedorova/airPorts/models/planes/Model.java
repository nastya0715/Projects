package com.fedorova.airPorts.models.planes;

import com.fedorova.airPorts.models.Models;

public class Model extends Models{
	private Brand brand;
	private String name;
	
	
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "\r\n"+"Model [brand=" + brand + ", name=" + name + "]";
	}
	
	
	
}
