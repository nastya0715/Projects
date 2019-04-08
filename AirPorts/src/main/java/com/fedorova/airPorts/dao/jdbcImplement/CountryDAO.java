package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.ICountryDAO;
import com.fedorova.airPorts.models.location.Country;

public class CountryDAO extends AbstractJDBC implements ICountryDAO {
	private final static Logger logger= Logger.getLogger(CountryDAO.class); 
	private final static String SET_COUNTRY=("INSERT INTO  countries (name) VALUES (?)");
	private final static String UPDATE_COUNTRY=("UPDATE countries SET name=? WHERE id=?");
	private final static String GET_COUNTRY=("SELECT * FROM countries  where id = ?");
	private final static String DELETE_COUNTRY=("DELETE FROM countries WHERE id=?");
	
	@Override
	public void insert(Country country) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_COUNTRY);
			ps.setString(1, country.getName());
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
	public Country getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Country country = new Country();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_COUNTRY);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildCountry(rs, country);
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
		return country;
	}
	@Override
	public void update(Country country) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_COUNTRY);
			ps.setString(1, country.getName());
			ps.setInt(2, country.getId());
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
	public void delete(Country country) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_COUNTRY);
			ps.setInt(1, country.getId());
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
	
	private void buildCountry(ResultSet rs, Country country) throws SQLException, ParseException {
		country.setId(rs.getInt("id"));
		country.setName(rs.getString("name"));
		
	}
}


