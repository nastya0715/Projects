package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IStewardDAO;
import com.fedorova.airPorts.models.people.Steward;
import com.fedorova.airPorts.models.planes.Plane;

public class StewardDAO extends AbstractJDBC implements IStewardDAO{
	private final static Logger logger= Logger.getLogger(StewardDAO.class); 
	private final static String SET_STEWARD=("INSERT INTO  stewards (first_name, last_name, flights_num) VALUES (?,?,?,?)");
	private final static String UPDATE_STEWARD=("UPDATE stewards SET first_name=?, last_name=?, flights_num=? WHERE id=?");
	private final static String GET_STEWARD=("SELECT * FROM stewards  where id = ?");
	private final static String DELETE_STEWARD=("DELETE FROM stewards WHERE id=?");
	
	@Override
	public void insert(Steward steward) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_STEWARD);
			ps.setString(1, steward.getFirstName());
			ps.setString(2, steward.getLastName());
			ps.setInt(3, steward.getFlightsNum());
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
	public Steward getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Steward steward = new Steward();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_STEWARD);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildSteward(rs, steward);
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
		return steward;
	}
	@Override
	public void update(Steward steward) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_STEWARD);
			ps.setString(1, steward.getFirstName());
			ps.setString(2, steward.getLastName());
			ps.setInt(3, steward.getFlightsNum());	
			ps.setInt(5, steward.getId());
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
	public void delete(Steward steward) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_STEWARD);
			ps.setInt(1, steward.getId());
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
	
	private void buildSteward(ResultSet rs, Steward steward) throws SQLException, ParseException {
		steward.setId(rs.getInt("id"));
		steward.setFirstName(rs.getString("first_name"));
		steward.setLastName(rs.getString("last_name"));
		steward.setFlightsNum(rs.getInt("flights_num"));
		Plane plane =  new Plane();
		plane.setId(rs.getInt("planes_id"));
		steward.setPlane(plane);
		
		
	}

	
}


