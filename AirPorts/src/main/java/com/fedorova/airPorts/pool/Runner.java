package com.fedorova.airPorts.pool;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fedorova.airPorts.dao.IBoardingPassDAO;
import com.fedorova.airPorts.models.flights.BoardingPass;

public class Runner {
	

	public static void main(String[] args) throws SQLException { 
		/*Thread mt = new Thread(new TRunnable(),"TRunnable1");
		mt.start();
		TThread tt = new TThread();
		tt.start();		
		Thread mt1 = new Thread(new TRunnable(),"TRunnable2");
		mt1.start();
		Thread mt2 = new Thread(new TRunnable(),"TRunnable3");
		mt2.start();*/
		
		//BoardingPassService bps = new BoardingPassService();
		//bps.getInf(2);
		
		Reader reader = null; 
		try { 
			reader = Resources.getResourceAsReader("config.xml"); 
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader); 
			SqlSession s = factory.openSession(); 
			//ICountryDAO c = s.getMapper(ICountryDAO.class); 
			//Country country= c.getById(4); 
			
			//ICityDAO ct = s.getMapper(ICityDAO.class); 
			//City city = ct.getById(3); 
			
			//IAirportDAO br = s.getMapper(IAirportDAO.class); 
			//Airport steward= br.getById(4); 
			
			//IBrandDAO br = s.getMapper(IBrandDAO.class); 
			//Brand brand= br.getById(4);
			
			IBoardingPassDAO br = s.getMapper(IBoardingPassDAO.class); 
			BoardingPass steward= br.getById(1); 
			System.out.println(steward.toString()); 
			s.close();
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
	}
		

}
	
