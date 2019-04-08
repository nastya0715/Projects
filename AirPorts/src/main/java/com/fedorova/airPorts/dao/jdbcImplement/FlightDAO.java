package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IFlightDAO;
import com.fedorova.airPorts.models.airports.Airport;
import com.fedorova.airPorts.models.flights.Boarding;
import com.fedorova.airPorts.models.flights.Cancellation;
import com.fedorova.airPorts.models.flights.Flight;
import com.fedorova.airPorts.models.planes.Plane;

public class FlightDAO extends AbstractJDBC implements IFlightDAO {
	private final static Logger logger= Logger.getLogger(FlightDAO.class); 
	private final static String SET_FLIGHT=("INSERT INTO  flights (distance, boarding_time, departure_time, arrival_time) VALUES (?,?,?,?)");
	private final static String UPDATE_FLIGHT=("UPDATE flights SET distance=?, boarding_time=?, departure_time=?, arrival_time=? WHERE id=?");
	private final static String GET_FLIGHT=("SELECT * FROM flights  where id = ?");
	private final static String DELETE_FLIGHT=("DELETE FROM flights WHERE id=?");
	
	@Override
	public void insert(Flight flight) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_FLIGHT);
			ps.setDouble(1, flight.getDistance());
			ps.setString(2, flight.getBoardingTime());
			ps.setString(3, flight.getDeparture());
			ps.setString(4, flight.getArrival());
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
	public Flight getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Flight flight = new Flight();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_FLIGHT);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildFlight(rs, flight);
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
		return flight;
	}
	@Override
	public void update(Flight flight) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_FLIGHT);
			ps.setDouble(1, flight.getDistance());
			ps.setString(2, flight.getBoardingTime());
			ps.setString(3, flight.getDeparture());
			ps.setString(4, flight.getArrival());
			ps.setInt(5, flight.getId());
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
	public void delete(Flight flight) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_FLIGHT);
			ps.setInt(1, flight.getId());
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
	
	private void buildFlight(ResultSet rs, Flight flight) throws SQLException, ParseException {
		flight.setId(rs.getInt("id"));
		flight.setDistance(rs.getDouble("distance"));
		flight.setBoardingTime(rs.getString("boarding_time"));
		Cancellation cancellation =  new Cancellation();
		cancellation.setId(rs.getInt("cancellation_id"));
		flight.setCancellation(cancellation);
		Boarding boarding =  new Boarding();
		boarding.setId(rs.getInt("boarding_id"));
		flight.setBoarding(boarding);
		Plane plane =  new Plane();
		plane.setId(rs.getInt("plane_id"));
		flight.setPlane(plane);		
		flight.setDeparture(rs.getString("departure_time"));
		flight.setArrival(rs.getString("arrival_time"));
		
		Airport from =  new Airport();
		from.setId(rs.getInt("from_id"));
		flight.setFrom(from);
		
		Airport to =  new Airport();
		to.setId(rs.getInt("to_id"));
		flight.setTo(to);

	}
}





