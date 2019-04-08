package fedorova.models.hospitalProject.doctors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name="Ophthalmologist")
public class Ophthalmologist extends Doctor implements ICure {
	@XmlElement(name = "opticsKnowledge")
	private String opticsKnowledge;
	
	private final static Logger logger = Logger.getLogger(Ophthalmologist.class);
	
	public void checkEyesVision () {
		
	}
	@Override
	public void cure() {
			logger.info("Write an appointment for glasses");
		
	}
	
	public String getOpticsKnowledge() {
		return opticsKnowledge;
	}
	public void setOpticsKnowledge(String opticsKnowledge) {
		this.opticsKnowledge = opticsKnowledge;
	}
	@Override
	public String toString() {
		return "Ophthalmologist [education= " + getEducation() + ", firstName= " + getFirstName() + ", lastName= " + getLastName() +  ", age= " + getAge() 
		+  ", gender= "+ getGender() + ", alive= " + isAlive() + ", docName= " + getDocName() +  " ,specialization= " + getSpecialization() +"]";
	}
	
	
}
