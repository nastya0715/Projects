package com.fedorova.airPorts.services;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.ICityDAO;
import com.fedorova.airPorts.dao.ICountryDAO;
import com.fedorova.airPorts.dao.jdbcImplement.CityDAO;
import com.fedorova.airPorts.dao.jdbcImplement.CountryDAO;
import com.fedorova.airPorts.models.location.City;
import com.fedorova.airPorts.models.location.Country;

public class CityService {
	private ICityDAO cityDao = new CityDAO();
	private ICountryDAO countryDao = new CountryDAO();
	
	private final static Logger logger= Logger.getLogger(CityService.class); 
	
	public City getInf(int id) { 
		City city = cityDao.getById(id); 
		Country country = countryDao.getById(city.getCountry().getId());
		city.setCountry(country); 
		logger.info(city.toString()); 
		return city; 
	} 
}
	

