package com.fedorova.airPorts.services;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IBoardingDAO;
import com.fedorova.airPorts.dao.ICancellationDAO;
import com.fedorova.airPorts.dao.IFlightDAO;
import com.fedorova.airPorts.dao.jdbcImplement.BoardingDAO;
import com.fedorova.airPorts.dao.jdbcImplement.CancellationDAO;
import com.fedorova.airPorts.dao.jdbcImplement.FlightDAO;
import com.fedorova.airPorts.models.flights.Boarding;
import com.fedorova.airPorts.models.flights.Cancellation;
import com.fedorova.airPorts.models.flights.Flight;

public class FlightService {
	private IFlightDAO flightDao = new FlightDAO();
	private ICancellationDAO cancellationDao = new CancellationDAO();
	private IBoardingDAO boardingDao = new BoardingDAO();
	
	private final static Logger logger= Logger.getLogger(FlightService.class); 
	
	public Flight getInf(int id) {
		Flight flight = flightDao.getById(id);
		Cancellation cancellation = cancellationDao.getById(flight.getCancellation().getId());
		flight.setCancellation(cancellation);
		Boarding boarding = boardingDao.getById(flight.getBoarding().getId());
		flight.setBoarding(boarding); 
		PlaneService ps = new PlaneService();
		flight.setPlane(ps.getInf(flight.getPlane().getId()));
		AirportService cs1 = new AirportService();
		flight.setFrom(cs1.getInf(flight.getFrom().getId()));
		AirportService cs2 = new AirportService();
		flight.setTo(cs2.getInf(flight.getTo().getId()));
		logger.info(flight.toString());
		return flight;
	}
}
