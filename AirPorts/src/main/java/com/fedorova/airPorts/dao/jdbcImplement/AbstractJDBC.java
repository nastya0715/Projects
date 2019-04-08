package com.fedorova.airPorts.dao.jdbcImplement;

import com.fedorova.airPorts.pool.ConnectionPool;

public abstract class AbstractJDBC {
	protected static final ConnectionPool pool = ConnectionPool.getInstance();

}
