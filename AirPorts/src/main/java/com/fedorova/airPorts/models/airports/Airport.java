package com.fedorova.airPorts.models.airports;

import com.fedorova.airPorts.models.Models;
import com.fedorova.airPorts.models.location.City;

public class Airport extends Models{
	private String airportClass;
	private String name;
	private City city;
	
	public String getAirportClass() {
		return airportClass;
	}
	public void setAirportClass(String airportClass) {
		this.airportClass = airportClass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "\r\n"+"Airport [airportClass=" + airportClass + ", name=" + name + ", city=" + city + "]";
	}

	
	
	
	
	

}
