package com.fedorova.airPorts.models.location;

public class City {
	private int id;
	private String name;
	private int numberOfPeople;
	private String timeZone;
	private Country country;
	
	public City() {
	}
	
	public City(int id) {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "\r\n"+"City [id=" + id + ", name=" + name + ", numberOfPeople=" + numberOfPeople + ", timeZone=" + timeZone
				+ ", country=" + country + "]";
	}


	
	


}
