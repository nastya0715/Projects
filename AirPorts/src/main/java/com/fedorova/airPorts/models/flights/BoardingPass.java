package com.fedorova.airPorts.models.flights;

import com.fedorova.airPorts.models.Models;
import com.fedorova.airPorts.models.people.Passenger;

public class BoardingPass extends Models{
	private Passenger passenger;
	private Flight flight;
	private String seatNum;
	private Double cost;
	private String flightClass;
	private String ageCategory;
	private String wayOfSelling;
	private String gate;
	
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public String getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(String ageCategory) {
		this.ageCategory = ageCategory;
	}
	public String getWayOfSelling() {
		return wayOfSelling;
	}
	public void setWayOfSelling(String wayOfSelling) {
		this.wayOfSelling = wayOfSelling;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	@Override
	public String toString() {
		return "BoardingPass [passenger=" + passenger +", flight=" + flight + ", seatNum=" + seatNum + ", cost=" + cost
				+ ", flightClass=" + flightClass + ", ageCategory=" + ageCategory + ", wayOfSelling=" + wayOfSelling
				+ ", gate=" + gate + "]";
	}
	
	
	
}
