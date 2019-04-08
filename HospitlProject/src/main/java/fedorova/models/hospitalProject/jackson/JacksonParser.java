package fedorova.models.hospitalProject.jackson;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import fedorova.models.hospitalProject.hospitalProject.HospitalProject;

public class JacksonParser {	
	
	private final static Logger logger = Logger.getLogger(JacksonParser.class);
	
	private void run() {
		ObjectMapper mapper = new ObjectMapper();
		 
		HospitalProject value = null;
		try {
			value = mapper.readValue(new File("src/main/resources/hospitals.json"), HospitalProject.class);
	        
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		logger.info(value);
	}
	
	public static void main(String[] args) {
		JacksonParser obj = new JacksonParser();
		obj.run();
	}
	


}
