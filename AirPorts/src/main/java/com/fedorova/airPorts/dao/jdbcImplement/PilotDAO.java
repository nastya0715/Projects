package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IPilotDAO;
import com.fedorova.airPorts.models.people.Pilot;
import com.fedorova.airPorts.models.planes.Plane;

public class PilotDAO extends AbstractJDBC implements IPilotDAO{
	private final static Logger logger= Logger.getLogger(PilotDAO.class); 
	private final static String SET_PILOT=("INSERT INTO  pilots (first_name, last_name, age, experience, flights_num, pilot_specialization) VALUES (?,?,?,?,?,?)");
	private final static String UPDATE_PILOT=("UPDATE pilots SET first_name=?, last_name=?, age=?, experience=?, flights_num=?, pilot_specialization=? WHERE id=?");
	private final static String GET_PILOT=("SELECT * FROM pilots  where id = ?");
	private final static String DELETE_PILOT=("DELETE FROM pilots WHERE id=?");
	
	@Override
	public void insert(Pilot pilot) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_PILOT);
			ps.setString(1, pilot.getFirstName());
			ps.setString(2, pilot.getLastName());
			ps.setInt(3, pilot.getAge());
			ps.setDouble(4, pilot.getExperience());
			ps.setInt(5, pilot.getFlightsNum());
			ps.setString(6, pilot.getSpecialization());
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
	public Pilot getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pilot pilot = new Pilot();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_PILOT);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildPilot(rs, pilot);
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
		return pilot;
	}
	@Override
	public void update(Pilot pilot) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_PILOT);
			ps.setString(1, pilot.getFirstName());
			ps.setString(2, pilot.getLastName());
			ps.setInt(3, pilot.getAge());
			ps.setString(4, pilot.getSpecialization());
			ps.setDouble(5, pilot.getExperience());
			ps.setInt(6, pilot.getFlightsNum());
			ps.setInt(8, pilot.getId());
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
	public void delete(Pilot pilot) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_PILOT);
			ps.setInt(1, pilot.getId());
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
	
	private void buildPilot(ResultSet rs, Pilot pilot) throws SQLException, ParseException {
		pilot.setId(rs.getInt("id"));
		pilot.setFirstName(rs.getString("first_name"));
		pilot.setLastName(rs.getString("last_name"));
		pilot.setAge(rs.getInt("age"));
		pilot.setExperience(rs.getDouble("experience"));
		pilot.setFlightsNum(rs.getInt("flights_num"));
		pilot.setSpecialization(rs.getString("pilot_specialization"));
		Plane plane =  new Plane();
		plane.setId(rs.getInt("planes_id"));
		pilot.setPlane(plane);
		
		
	}
}


