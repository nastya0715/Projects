package com.fedorova.airPorts.pool;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger; 

public class ConnectionPool { 
	private String url; 
	private String user; 
	private String password;  
	private String driver; 
	private Properties properties; 
	private static int countConnection;
	private int connections; 
	private BlockingQueue <Connection> pool; 
	private final static ConnectionPool INSTANCE = new ConnectionPool(); 
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private final static Logger logger = Logger.getLogger(ConnectionPool.class);
	
	private ConnectionPool() { 
		properties = new Properties(); 
		try (FileInputStream fi = new FileInputStream("src/main/resources/database.properties")){ 
			properties.load(fi); 
		} catch (IOException e) { 
			logger.error(e);  
		} 
		connections=Integer.valueOf(properties.getProperty("size")); 
		url = properties.getProperty("url"); 
		user = properties.getProperty("user"); 
		password = properties.getProperty("password"); 
		pool = new ArrayBlockingQueue<Connection>(connections); 
	} 
	
	public static ConnectionPool getInstance() { 
		return INSTANCE; 
	} 
	
	private Connection createConnection() throws InterruptedException{ 
		driver = properties.getProperty("driver");
		Connection connection = pool.poll(10L, TimeUnit.MILLISECONDS);
		if (connection==null&&connections>0) {
			try {
				Class.forName(driver);
				connections--;
			} catch (ClassNotFoundException e) {
				logger.error(e);
			}
			try {
				connection = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				logger.error(e);
			}
		}return connection; 
	} 
	
	public Connection getConnection()   {
		Connection connection = pool.poll();
		if (connection!=null)
			return connection;
		lock.writeLock().lock();
		if (countConnection < connections) {
			try {
				pool.add(createConnection());
				countConnection++;
				connection = pool.take();
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			
		}
		lock.writeLock().unlock();
		return connection;
	}
	
	public void releaseConnection(Connection connection) { 
		pool.add(connection); 
	} 
	
}