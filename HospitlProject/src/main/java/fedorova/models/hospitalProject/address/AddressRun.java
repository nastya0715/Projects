package fedorova.models.hospitalProject.address;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class AddressRun {
	private final static Logger logger = Logger.getLogger(AddressRun.class);

	public static void main(String[] args)  {
		
		Address a = new Address (City.ATLANTA,"Maple", 7);
		logger.info (a.toString());
		logger.info (a.hashCode());
		logger.info (a.equals("Maple"));
		
		try{ 
			Class<?> c = Class.forName("fedorova.models.hospitalProject.patients.People");
		
			Method [] methods = c.getDeclaredMethods();
			logger.info(methods[5].getName()+" - "+methods[5].getReturnType()+" - "+methods[5].getModifiers()+" - "+methods[5].getParameters()[0].getName());
			
			Field [] fields = c.getDeclaredFields();
			logger.info(fields[0].getName()+" - "+fields[0].getModifiers()+" - "+fields[0].getType());
		} catch (ClassNotFoundException e) {
			
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error("Error: Repeat Run of application");
		
		}finally {
			
		}	
		
		
	}
}

