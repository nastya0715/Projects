package com.fedorova.airPorts.models.flights;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fedorova.airPorts.models.Models;
import com.fedorova.airPorts.models.airports.Airport;
import com.fedorova.airPorts.models.planes.Plane;

public class Flight extends Models{
	private Double distance;
	private Date boardingTime;
	private Date departure;
	private Date arrival;
	private Cancellation cancellation;
	private Boarding boarding;
	private Airport from;
	private Airport to;
	
	private Plane plane;
	private SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");	
	private SimpleDateFormat form = new SimpleDateFormat ("HH:mm:ss");	
	
	
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public String getBoardingTime() {
		return form.format(boardingTime);
	}
	public void setBoardingTime(String boardingTime) throws ParseException {
		this.boardingTime = form.parse(boardingTime);
	}
	public String getDeparture() {
		return format.format(departure);
	}
	public void setDeparture(String departure) throws ParseException {
		this.departure = format.parse(departure);
	}
	public String getArrival() {
		return format.format(arrival);
	}
	public void setArrival(String arrival) throws ParseException {
		this.arrival = format.parse(arrival);
	}
	
	public Cancellation getCancellation() {
		return cancellation;
	}
	public void setCancellation(Cancellation cancellation) {
		this.cancellation = cancellation;
	}
	public Boarding getBoarding() {
		return boarding;
	}
	public void setBoarding(Boarding boarding) {
		this.boarding = boarding;
	}
	
	
	public Airport getFrom() {
		return from;
	}
	public void setFrom(Airport from) {
		this.from = from;
	}
	public Airport getTo() {
		return to;
	}
	public void setTo(Airport to) {
		this.to = to;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	@Override
	public String toString() {
		return "\r\n"+"Flight [distance=" + distance + ", boardingTime=" + boardingTime + ", departure=" + departure
				+ ", arrival=" + arrival + ", cancellation=" + cancellation + ", boarding=" + boarding + ", from="
				+ from + ", to=" + to + ", plane=" + plane + "]";
	}
	
	
	
	
	
	

}
