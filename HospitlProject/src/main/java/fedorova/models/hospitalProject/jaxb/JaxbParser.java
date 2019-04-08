package fedorova.models.hospitalProject.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import fedorova.models.hospitalProject.doctors.Doctor;
import fedorova.models.hospitalProject.hospitalProject.HospitalProject;

public class JaxbParser {
	private final static Logger logger = Logger.getLogger(Doctor.class);
	
	public static void main(String[] args) throws JAXBException {
		File file = new File ("src/main/resources/hospitals.xml");
		
		JAXBContext context = JAXBContext.newInstance(HospitalProject.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		HospitalProject unmarshalled = (HospitalProject) unmarshaller.unmarshal (file);
		logger.info(unmarshalled);
		
	}
}
	
	
	
	