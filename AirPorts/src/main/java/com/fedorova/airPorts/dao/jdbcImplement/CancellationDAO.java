package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.ICancellationDAO;
import com.fedorova.airPorts.models.flights.Cancellation;

public class CancellationDAO extends AbstractJDBC implements ICancellationDAO{
	private final static Logger logger= Logger.getLogger(CancellationDAO.class); 
	private final static String SET_CANCELLATION=("INSERT INTO  cancellation (cancellation_time, reason) VALUES (?,?)");
	private final static String UPDATE_CANCELLATION=("UPDATE cancellation SET cancellation_time=?, reason=? WHERE id=?");
	private final static String GET_CANCELLATION=("SELECT * FROM cancellation  where id = ?");
	private final static String DELETE_CANCELLATION=("DELETE FROM cancellation WHERE id=?");
	
	@Override
	public void insert(Cancellation cancellation) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_CANCELLATION);
			ps.setString(1, cancellation.getDateTime());
			ps.setString(2, cancellation.getReason());
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
	public Cancellation getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cancellation cancellation = new Cancellation();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_CANCELLATION);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildCancellation(rs, cancellation);
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
		return cancellation;
	}
	@Override
	public void update(Cancellation cancellation) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_CANCELLATION);
			ps.setString(1, cancellation.getDateTime());
			ps.setString(2, cancellation.getReason());
			ps.setInt(3, cancellation.getId());
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
	public void delete(Cancellation cancellation) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_CANCELLATION);
			ps.setInt(1, cancellation.getId());
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
	
	private void buildCancellation(ResultSet rs, Cancellation cancellation) throws SQLException, ParseException {
		cancellation.setId(rs.getInt("id"));
		cancellation.setDateTime(rs.getString("cancellation_time"));
		cancellation.setReason(rs.getString("reason"));
		
	}
}




