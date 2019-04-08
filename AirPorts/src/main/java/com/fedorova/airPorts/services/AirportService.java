package com.fedorova.airPorts.services;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IAirportDAO;
import com.fedorova.airPorts.dao.jdbcImplement.AirportDAO;
import com.fedorova.airPorts.models.airports.Airport;

public class AirportService {
	private IAirportDAO airportDao = new AirportDAO();
	
	private final static Logger logger= Logger.getLogger(AirportService.class); 
	
	public Airport getInf(int id) {
		Airport airport = airportDao.getById(id);
		CityService cs = new CityService();
		airport.setCity(cs.getInf(airport.getCity().getId()));
		logger.info(airport.toString());
		return airport;
	}
}
