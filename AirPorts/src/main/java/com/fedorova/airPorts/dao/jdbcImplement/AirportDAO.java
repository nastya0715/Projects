package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IAirportDAO;
import com.fedorova.airPorts.models.airports.Airport;
import com.fedorova.airPorts.models.location.City;

public class AirportDAO extends AbstractJDBC implements IAirportDAO {
	private final static String SET_AIRPORT=("INSERT INTO  airports (name, airport_class) VALUES (?,?)");
	private final static String UPDATE_AIRPORT=("UPDATE airports SET name=?, airport_class=? WHERE id=?");
	private final static String GET_AIRPORT=("SELECT * FROM airports  where id = ?");
	private final static String DELETE_AIRPORT=("DELETE FROM airports WHERE id=?");
	private final static Logger logger= Logger.getLogger(AirportDAO.class);
	
	@Override
	public void insert(Airport airport) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_AIRPORT);
			ps.setString(1, airport.getName());
			ps.setString(2, airport.getAirportClass());
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
	public Airport getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Airport airport = new Airport();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_AIRPORT);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildAirport(rs, airport);
			}
		} catch (SQLException e) {
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
		return airport;
	}
	@Override
	public void update(Airport airport) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_AIRPORT);
			ps.setString(1, airport.getName());
			ps.setString(2, airport.getAirportClass());
			ps.setInt(3, airport.getId());
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
	public void delete(Airport airport) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_AIRPORT);
			ps.setInt(1, airport.getId());
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
	
	private void buildAirport(ResultSet rs, Airport airport) throws SQLException {
		airport.setId(rs.getInt("id"));
		airport.setName(rs.getString("name"));
		airport.setAirportClass(rs.getString("airport_class"));
		City city =  new City();
		city.setId(rs.getInt("city_id"));
		airport.setCity(city);
		
	}
	


}
