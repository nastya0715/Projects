package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IPlaneDAO;
import com.fedorova.airPorts.models.planes.Model;
import com.fedorova.airPorts.models.planes.Plane;

public class PlaneDAO extends AbstractJDBC implements IPlaneDAO {
	private final static Logger logger= Logger.getLogger(PlaneDAO.class); 
	private final static String SET_PLANE=("INSERT INTO  planes (plane_condition, planes_types) VALUES (?,?)");
	private final static String UPDATE_PLANE=("UPDATE planes SET plane_condition=?, planes_types=? WHERE id=?");
	private final static String GET_PLANE=("SELECT * FROM planes  where id = ?");
	private final static String DELETE_PLANE=("DELETE FROM planes WHERE id=?");
	
	@Override
	public void insert(Plane plane) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_PLANE);
			ps.setString(1, plane.getPlaneCondition());
			ps.setString(2, plane.getPlaneType());
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
	public Plane getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Plane plane = new Plane();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_PLANE);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildPlane(rs, plane);
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
		return plane;
	}
	@Override
	public void update(Plane plane) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_PLANE);
			ps.setString(1, plane.getPlaneCondition());
			ps.setString(2, plane.getPlaneType());
			ps.setInt(3, plane.getId());
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
	public void delete(Plane plane) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_PLANE);
			ps.setInt(1, plane.getId());
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
	
	private void buildPlane(ResultSet rs, Plane plane) throws SQLException, ParseException {
		plane.setId(rs.getInt("id"));
		Model model =  new Model();
		model.setId(rs.getInt("models_id"));
		plane.setModel(model);
		plane.setPlaneCondition(rs.getString("plane_condition"));
		plane.setPlaneType(rs.getString("planes_types"));
		
	}
}
