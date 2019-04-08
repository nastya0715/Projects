package com.fedorova.airPorts.services;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IStewardDAO;
import com.fedorova.airPorts.dao.jdbcImplement.StewardDAO;
import com.fedorova.airPorts.models.people.Steward;

public class StewardService {
private IStewardDAO stewardDao = new StewardDAO();
	
	private final static Logger logger= Logger.getLogger(StewardService.class);
	
	public Steward getInf(int id) {
		Steward steward = stewardDao.getById(id);
		PlaneService ps = new PlaneService();
		steward.setPlane(ps.getInf(steward.getPlane().getId()));
		logger.info(steward.toString());
		return steward;
	}
}
