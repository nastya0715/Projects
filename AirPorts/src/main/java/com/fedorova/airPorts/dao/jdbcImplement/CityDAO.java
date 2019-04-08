package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.ICityDAO;
import com.fedorova.airPorts.models.location.City;
import com.fedorova.airPorts.models.location.Country;

public class CityDAO extends AbstractJDBC implements ICityDAO {
	private final static Logger logger= Logger.getLogger(CityDAO.class); 
	private final static String SET_CITY=("INSERT INTO  cities (name, number_of_people, time_zone) VALUES (?,?,?)");
	private final static String UPDATE_CITY=("UPDATE cities SET name=?, number_of_people=?, time_zone=? WHERE id=?");
	private final static String GET_CITY=("SELECT * FROM cities  where id = ?");
	private final static String DELETE_CITY=("DELETE FROM cities WHERE id=?");
	
	@Override
	public void insert(City city) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_CITY);
			ps.setString(1, city.getName());
			ps.setInt(2, city.getNumberOfPeople());
			ps.setString(3, city.getTimeZone());
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
	public City getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		City city = new City();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_CITY);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildCity(rs, city);
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
		return city;
	}
	@Override
	public void update(City city) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_CITY);
			ps.setString(1, city.getName());
			ps.setInt(2, city.getNumberOfPeople());
			ps.setString(3, city.getTimeZone());
			ps.setInt(4, city.getId());
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
	public void delete(City city) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_CITY);
			ps.setInt(1, city.getId());
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
	
	private void buildCity(ResultSet rs, City city) throws SQLException, ParseException {
		city.setId(rs.getInt("id"));
		city.setName(rs.getString("name"));
		Country country =  new Country();
		country.setId(rs.getInt("countries_id"));
		city.setCountry(country);
		city.setNumberOfPeople(rs.getInt("number_of_people"));
		city.setTimeZone(rs.getString("time_zone"));
		
	}
}

