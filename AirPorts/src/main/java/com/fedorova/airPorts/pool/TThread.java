package com.fedorova.airPorts.pool;

import java.sql.Connection; 
import org.apache.log4j.Logger; 

public class TThread extends Thread{ 
	private final static  Logger logger = Logger.getLogger(TThread.class); 
	

	public void run() { 
		Connection c = null; 
		try { 
			c = ConnectionPool.getInstance().getConnection(); 
			Thread.sleep(10000); 
			logger.info("ext"); 
		} catch (InterruptedException e) { 
			logger.error(e);
		} 
		ConnectionPool.getInstance().releaseConnection(c); 
	} 
}


