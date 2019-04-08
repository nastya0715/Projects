package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IModelDAO;
import com.fedorova.airPorts.models.planes.Brand;
import com.fedorova.airPorts.models.planes.Model;

public class ModelDAO extends AbstractJDBC implements IModelDAO {
	private final static Logger logger= Logger.getLogger(ModelDAO.class); 
	private final static String SET_MODEL=("INSERT INTO  models (name) VALUES (?)");
	private final static String UPDATE_MODEL=("UPDATE models SET name=? WHERE id=?");
	private final static String GET_MODEL=("SELECT * FROM models  where id = ?");
	private final static String DELETE_MODEL=("DELETE FROM models WHERE id=?");
	
	@Override
	public void insert(Model model) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_MODEL);
			ps.setString(1, model.getName());
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
	public Model getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Model model = new Model();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_MODEL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildModel(rs, model);
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
		return model;
	}
	@Override
	public void update(Model model) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_MODEL);
			ps.setString(1, model.getName());
			ps.setInt(2, model.getId());
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
	public void delete(Model model) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_MODEL);
			ps.setInt(1, model.getId());
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
	
	private void buildModel(ResultSet rs, Model model) throws SQLException, ParseException {
		model.setId(rs.getInt("id"));
		model.setName(rs.getString("name"));
		Brand brand =  new Brand();
		brand.setId(rs.getInt("brands_id"));
		model.setBrand(brand);
		
		
	}
}

