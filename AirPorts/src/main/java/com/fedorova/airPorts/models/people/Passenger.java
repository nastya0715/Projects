package com.fedorova.airPorts.models.people;

public class Passenger extends People {

	@Override
	public String toString() {
		return "\r\n"+"Passenger [firstName=" + getFirstName() + ", LastName=" + getLastName() + "]";
	}

	
	
}
