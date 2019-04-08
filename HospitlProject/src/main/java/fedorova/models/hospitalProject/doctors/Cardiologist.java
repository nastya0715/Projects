package fedorova.models.hospitalProject.doctors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name="Cardiologist")
public class Cardiologist extends Doctor implements ICure {
	@XmlElement(name = "hydraulicsKnowledge")
	private String hydraulicsKnowledge;
	
	private final static Logger logger = Logger.getLogger(Cardiologist.class);
	
	@Override
	public void cure() {
		logger.info("Make heart survey, take a heartpills");		
	}

	public String getHydraulicsKnowledge() {
		return hydraulicsKnowledge;
	}
	public void setHydraulicsKnowledge(String hydraulicsKnowledge) {
		this.hydraulicsKnowledge = hydraulicsKnowledge;
	}
	@Override
	public String toString() {
		return "Cardiologist [education= " + getEducation() + ", firstName= " + getFirstName() + ", lastName= " + getLastName() +  ", age= " + getAge() +  ", gender= " + getGender()  

		+ ", alive= " + isAlive() + ", docName= " + getDocName() +  ", specialization=" + getSpecialization() +"]";
	}
	
	

}
