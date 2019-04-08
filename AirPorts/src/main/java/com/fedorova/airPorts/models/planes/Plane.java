package com.fedorova.airPorts.models.planes;

import com.fedorova.airPorts.models.Models;



public class Plane extends Models{
	private String planeCondition;
	private Model model;
	private String planeType;

	public String getPlaneCondition() {
		return planeCondition;
	}

	public void setPlaneCondition(String planeCondition) {
		this.planeCondition = planeCondition;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	@Override
	public String toString() {
		return "\r\n"+"Plane [planeCondition=" + planeCondition + ", model=" + model + ", planeType=" + planeType + "]";
	}
	
	
}
