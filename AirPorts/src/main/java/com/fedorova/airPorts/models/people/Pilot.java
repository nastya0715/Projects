package com.fedorova.airPorts.models.people;

import com.fedorova.airPorts.models.planes.Plane;

public class Pilot extends People {
	private int age;
	private Double experience;
	private int flightsNum;
	private String specialization;
	private Plane plane;
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getExperience() {
		return experience;
	}
	public void setExperience(Double experience) {
		this.experience = experience;
	}
	public int getFlightsNum() {
		return flightsNum;
	}
	public void setFlightsNum(int flightsNum) {
		this.flightsNum = flightsNum;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	@Override
	public String toString() {
		return "\r\n"+"Pilot [age=" + age + ", experience=" + experience + ", flightsNum=" + flightsNum + ", specialization="
				+ specialization + ", plane=" + plane + "]";
	}
	
	
	
	

}
