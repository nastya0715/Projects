package com.fedorova.airPorts.models.planes;

import com.fedorova.airPorts.models.Models;

public class Brand extends Models{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\r\n"+"Brand [name=" + name + "]";
	}
	
	

}
