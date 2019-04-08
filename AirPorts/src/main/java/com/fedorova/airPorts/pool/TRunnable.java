package com.fedorova.airPorts.pool;

import java.sql.Connection;

import org.apache.log4j.Logger;

public class TRunnable implements Runnable{
	
private final static  Logger logger = Logger.getLogger(TRunnable.class); 
	
	public void run() { 
		Connection c = null; 
		try { 
			c = ConnectionPool.getInstance().getConnection();
			Thread.sleep(20000);
			logger.info("impl"); 
		} catch (Exception e) { 
			logger.error(e);
		} 
		ConnectionPool.getInstance().releaseConnection(c); 
	} 
}
