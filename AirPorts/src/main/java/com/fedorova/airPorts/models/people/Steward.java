package com.fedorova.airPorts.models.people;

import com.fedorova.airPorts.models.planes.Plane;

public class Steward extends People {
	private int flightsNum;
	private Plane plane;

	public int getFlightsNum() {
		return flightsNum;
	}

	public void setFlightsNum(int flightsNum) {
		this.flightsNum = flightsNum;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	@Override
	public String toString() {
		return "\r\n"+"Steward [flightsNum=" + flightsNum + ", plane=" + plane + "]";
	}

	
	
	
	
	
}
