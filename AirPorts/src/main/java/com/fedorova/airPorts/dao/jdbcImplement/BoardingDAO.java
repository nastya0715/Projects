package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IBoardingDAO;
import com.fedorova.airPorts.models.flights.Boarding;

public class BoardingDAO extends AbstractJDBC implements IBoardingDAO{
	private final static Logger logger= Logger.getLogger(BoardingDAO.class); 
	private final static String SET_BOARDING=("INSERT INTO  boarding (registration_start, terminal) VALUES (?,?)");
	private final static String UPDATE_BOARDING=("UPDATE boarding SET registration_start=?, terminal=? WHERE id=?");
	private final static String GET_BOARDING=("SELECT * FROM boarding  where id = ?");
	private final static String DELETE_BOARDING=("DELETE FROM boarding WHERE id=?");
	
	@Override
	public void insert(Boarding boarding) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_BOARDING);
			ps.setString(1, boarding.getRegistrationTime());
			ps.setString(2, boarding.getTerminal());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			pool.releaseConnection(connection);
			try {
				ps.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	
	@Override
	public Boarding getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Boarding boarding = new Boarding();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_BOARDING);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildBoarding(rs, boarding);
			}
		} catch (SQLException e) {
			logger.error(e);
		} catch (ParseException e) {
			logger.error(e);
		} finally {
			pool.releaseConnection(connection);
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				logger.error(e);
			}
			
		}
		return boarding;
	}
	@Override
	public void update(Boarding boarding) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_BOARDING);
			ps.setString(1, boarding.getRegistrationTime());
			ps.setString(2, boarding.getTerminal());
			ps.setInt(3, boarding.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.error(e);
		} finally {
			pool.releaseConnection(connection);
			try {
				ps.close();
			} catch (SQLException e) {				
				logger.error(e);
			}
		}		
	}
	@Override
	public void delete(Boarding boarding) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_BOARDING);
			ps.setInt(1, boarding.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.error(e);
		} finally {
			pool.releaseConnection(connection);
			try {
				ps.close();
			} catch (SQLException e) {				
				logger.error(e);
			}
		}		
	} 
	
	private void buildBoarding(ResultSet rs, Boarding boarding) throws SQLException, ParseException {
		boarding.setId(rs.getInt("id"));
		boarding.setRegistrationTime(rs.getString("registration_start"));
		boarding.setTerminal(rs.getString("terminal"));
		
	}
}


