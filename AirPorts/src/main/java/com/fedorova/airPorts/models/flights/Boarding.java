package com.fedorova.airPorts.models.flights;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fedorova.airPorts.models.Models;

public class Boarding extends Models{
	private Date registrationTime;
	private String terminal;
	private SimpleDateFormat format = new SimpleDateFormat ("HH:mm:ss");
	
	
	public String getRegistrationTime() {
		return format.format(registrationTime);
	}
	public void setRegistrationTime(String registrationTime) throws ParseException {
		this.registrationTime = format.parse(registrationTime);
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	@Override
	public String toString() {
		return "\r\n"+"Boarding [registrationTime=" + registrationTime + ", terminal=" + terminal + "]";
	}
	
		
	
}
