package com.fedorova.airPorts.dao;

public interface IDAO<T>{
	void insert (T entity);
	T getById(int id);
	void update (T entity);
	void delete (T entity);
		

}
