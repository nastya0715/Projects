package com.fedorova.airPorts.services;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IBoardingPassDAO;
import com.fedorova.airPorts.dao.IPassengerDAO;
import com.fedorova.airPorts.dao.jdbcImplement.BoardingPassDAO;
import com.fedorova.airPorts.dao.jdbcImplement.PassengerDAO;
import com.fedorova.airPorts.models.flights.BoardingPass;
import com.fedorova.airPorts.models.people.Passenger;

public class BoardingPassService {
	private IBoardingPassDAO boardingPassDao = new BoardingPassDAO();
	private IPassengerDAO passengerDao = new PassengerDAO();
	
	private final static Logger logger= Logger.getLogger(BoardingPassService.class); 
	
	public BoardingPass getInf(int id) { 
		BoardingPass boardingPass = boardingPassDao.getById(id); 
		Passenger passenger = passengerDao.getById(boardingPass.getPassenger().getId());
		boardingPass.setPassenger(passenger);
		FlightService fs = new FlightService();
		boardingPass.setFlight(fs.getInf(boardingPass.getFlight().getId()));
		logger.info(boardingPass.toString()); 
		return boardingPass; 
	
	}
	

}
