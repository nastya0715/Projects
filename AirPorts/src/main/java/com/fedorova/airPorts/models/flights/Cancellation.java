package com.fedorova.airPorts.models.flights;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fedorova.airPorts.models.Models;

public class Cancellation extends Models{	
	private Date dateTime;
	private String reason;
	private SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
	
	
	public String getDateTime() {
		return format.format(dateTime);
	}
	public void setDateTime(String dateTime) throws ParseException {
		this.dateTime = format.parse(dateTime);
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "\r\n"+"Cancellation [dateTime=" + dateTime + ", reason=" + reason + "]";
	}
	
	
	
}
