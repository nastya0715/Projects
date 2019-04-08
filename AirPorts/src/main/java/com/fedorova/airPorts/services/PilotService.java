package com.fedorova.airPorts.services;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IPilotDAO;
import com.fedorova.airPorts.dao.jdbcImplement.PilotDAO;
import com.fedorova.airPorts.models.people.Pilot;

public class PilotService {
	private IPilotDAO pilotDao = new PilotDAO();
	
	private final static Logger logger= Logger.getLogger(PilotService.class);
	
	public Pilot getInf(int id) {
		Pilot pilot = pilotDao.getById(id);
		PlaneService ps = new PlaneService();
		pilot.setPlane(ps.getInf(pilot.getPlane().getId()));
		logger.info(pilot.toString());
		return pilot;
	}
}
