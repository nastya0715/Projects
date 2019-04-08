package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IBoardingPassDAO;
import com.fedorova.airPorts.models.flights.BoardingPass;
import com.fedorova.airPorts.models.flights.Flight;
import com.fedorova.airPorts.models.people.Passenger;

public class BoardingPassDAO extends AbstractJDBC implements IBoardingPassDAO {
	private final static Logger logger= Logger.getLogger(BoardingPassDAO.class);
	private final static String SET_BOARDINGPASS=("INSERT INTO  tickets (seat_num, cost, flight_class, age_category, way_of_selling, gate) VALUES (?,?,?,?,?,?)");
	private final static String UPDATE_BOARDINGPASS=("UPDATE tickets SET seat_num=?, cost=?, flight_class=?, age_category=?, way_of_selling=?, gate=? WHERE id=?");
	private final static String GET_BOARDINGPASS=("SELECT * FROM tickets  where id = ?");
	private final static String DELETE_BOARDINGPASS=("DELETE FROM tickets WHERE id=?");
	
	@Override
	public void insert(BoardingPass boardingPass) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_BOARDINGPASS);
			ps.setString(1, boardingPass.getSeatNum());
			ps.setDouble(2, boardingPass.getCost());
			ps.setString(3, boardingPass.getFlightClass());
			ps.setString(4, boardingPass.getAgeCategory());
			ps.setString(5, boardingPass.getWayOfSelling());
			ps.setString(6, boardingPass.getGate());
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
	public BoardingPass getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardingPass boardingPass = new BoardingPass();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_BOARDINGPASS);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildBoardingPass(rs, boardingPass);
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
		return boardingPass;
	}
	@Override
	public void update(BoardingPass boardingPass) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_BOARDINGPASS);
			ps.setString(1, boardingPass.getSeatNum());
			ps.setDouble(2, boardingPass.getCost());
			ps.setString(3, boardingPass.getFlightClass());
			ps.setString(4, boardingPass.getAgeCategory());
			ps.setString(5, boardingPass.getWayOfSelling());
			ps.setString(6, boardingPass.getGate());
			ps.setInt(7, boardingPass.getId());
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
	public void delete(BoardingPass boardingPass) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_BOARDINGPASS);
			ps.setInt(1, boardingPass.getId());
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
	
	private void buildBoardingPass(ResultSet rs, BoardingPass boardingPass) throws SQLException, ParseException {
		boardingPass.setId(rs.getInt("id"));
		boardingPass.setSeatNum(rs.getString("seat_num"));
		Passenger passenger =  new Passenger();
		passenger.setId(rs.getInt("passengers_id"));
		boardingPass.setPassenger(passenger);
		Flight flight =  new Flight();
		flight.setId(rs.getInt("flights_id"));
		boardingPass.setFlight(flight);
		boardingPass.setCost(rs.getDouble("passengers_id"));
		boardingPass.setFlightClass(rs.getString("flight_class"));
		boardingPass.setAgeCategory(rs.getString("age_category"));
		boardingPass.setWayOfSelling(rs.getString("way_of_selling"));
		boardingPass.setGate(rs.getString("gate"));
		
	}
}





