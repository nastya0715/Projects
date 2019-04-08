package com.fedorova.airPorts.models.location;

public class Country {
	private int id; 
	private String name; 
	
	public Country () {} 
	
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

	@Override
	public String toString() {
		return "\r\n"+"Country [id=" + id + ", name=" + name + "]";
	} 
	

}
