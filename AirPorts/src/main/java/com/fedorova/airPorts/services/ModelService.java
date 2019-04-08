package com.fedorova.airPorts.services;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IBrandDAO;
import com.fedorova.airPorts.dao.IModelDAO;
import com.fedorova.airPorts.dao.jdbcImplement.BrandDAO;
import com.fedorova.airPorts.dao.jdbcImplement.ModelDAO;
import com.fedorova.airPorts.models.planes.Brand;
import com.fedorova.airPorts.models.planes.Model;

public class ModelService {
	private IModelDAO modelDao = new ModelDAO();
	private IBrandDAO brandDao = new BrandDAO();
	
	private final static Logger logger= Logger.getLogger(ModelService.class); 
	
	public Model getInf(int id) {
		Model model = modelDao.getById(id);
		Brand brand = brandDao.getById(model.getBrand().getId());
		model.setBrand(brand);
		logger.info(model.toString());
		return model;
	}

}
