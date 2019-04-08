package com.fedorova.airPorts.services;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IPlaneDAO;
import com.fedorova.airPorts.dao.jdbcImplement.PlaneDAO;
import com.fedorova.airPorts.models.planes.Plane;

public class PlaneService {
	private IPlaneDAO planeDao = new PlaneDAO();
	
	private final static Logger logger= Logger.getLogger(PlaneService.class);
	
	public Plane getInf(int id) {
		Plane plane = planeDao.getById(id);
		ModelService ms = new ModelService();
		plane.setModel(ms.getInf(plane.getModel().getId()));
		logger.info(plane.toString());
		return plane;
	}

}
