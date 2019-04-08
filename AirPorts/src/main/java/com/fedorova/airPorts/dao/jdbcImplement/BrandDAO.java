package com.fedorova.airPorts.dao.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.fedorova.airPorts.dao.IBrandDAO;
import com.fedorova.airPorts.models.planes.Brand;

public class BrandDAO extends AbstractJDBC implements IBrandDAO {
	private final static Logger logger= Logger.getLogger(BrandDAO.class);
	private final static String SET_BRAND=("INSERT INTO  brands (name) VALUES (?)");
	private final static String UPDATE_BRAND=("UPDATE brands SET name=? WHERE id=?");
	private final static String GET_BRAND=("SELECT * FROM brands  where id = ?");
	private final static String DELETE_BRAND=("DELETE FROM brands WHERE id=?");
	
	@Override
	public void insert(Brand brand) {
		Connection connection =null;
		PreparedStatement ps = null;

		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(SET_BRAND);
			ps.setString(1, brand.getName());
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
	public Brand getById(int id) {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Brand brand = new Brand();
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(GET_BRAND);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildBrand(rs, brand);
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
		return brand;
	}
	@Override
	public void update(Brand brand) {
		Connection connection=null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();			
			ps = connection.prepareStatement(UPDATE_BRAND);
			ps.setString(1, brand.getName());
			ps.setInt(2, brand.getId());
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
	public void delete(Brand brand) {
		Connection connection =null;
		PreparedStatement ps = null;
		try {
			connection = pool.getConnection();
			ps = connection.prepareStatement(DELETE_BRAND);
			ps.setInt(1, brand.getId());
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
	
	private void buildBrand(ResultSet rs, Brand brand) throws SQLException, ParseException {
		brand.setId(rs.getInt("id"));
		brand.setName(rs.getString("name"));
		
	}
}




