package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IPassengerDAO;
import com.fedorova.airPorts.models.people.Passenger;

public class PassengerDAO extends AbstractJDBC implements IPassengerDAO {
	private final static Logger logger= Logger.getLogger(PassengerDAO.class); 
	private final static String SET_PASSENGER=("INSERT INTO  passengers (first_name, last_name) VALUES (?,?)");
	private final static String UPDATE_PASSENGER=("UPDATE passengers SET first_name=?, last_name=? WHERE id=?");
	private final static String GET_PASSENGER=("SELECT * FROM passengers  where id = ?");
	private final static String DELETE_PASSENGER=("DELETE FROM passengers WHERE id=?");
	
	@Override
	public void insert(Passenger passenger) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_PASSENGER);
			ps.setString(1, passenger.getFirstName());
			ps.setString(2, passenger.getLastName());
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
	public Passenger getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Passenger passenger = new Passenger();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_PASSENGER);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildPassenger(rs, passenger);
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
		return passenger;
	}
	@Override
	public void update(Passenger passenger) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_PASSENGER);
			ps.setString(1, passenger.getFirstName());
			ps.setString(2, passenger.getLastName());
			ps.setInt(3, passenger.getId());
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
	public void delete(Passenger passenger) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_PASSENGER);
			ps.setInt(1, passenger.getId());
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
	
	private void buildPassenger(ResultSet rs, Passenger passenger) throws SQLException, ParseException {
		passenger.setId(rs.getInt("id"));
		passenger.setFirstName(rs.getString("first_name"));
		passenger.setLastName(rs.getString("last_name"));
		
	}
}



