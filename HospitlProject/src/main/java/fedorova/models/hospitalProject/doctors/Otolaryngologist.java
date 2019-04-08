package fedorova.models.hospitalProject.doctors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;


@XmlRootElement (name="Otolaryngologist")
@XmlAccessorType(XmlAccessType.FIELD)
public class Otolaryngologist extends Doctor implements ICure {
	@XmlElement(name = "hydraulicsKnowledge")
	private String hydraulicsKnowledge;
	
	private final static Logger logger = Logger.getLogger(Otolaryngologist.class);
	
	@Override
	public void cure() {
		logger.info("Check ears");
		logger.info("Check nose");
		logger.info("Check throat");
		logger.info("Take a pills");
		
	}

	public String getHydraulicsKnowledge() {
		return hydraulicsKnowledge;
	}
	public void setHydraulicsKnowledge(String hydraulicsKnowledge) {
		this.hydraulicsKnowledge = hydraulicsKnowledge;
	}
	@Override
	public String toString() {
		return "Otolaryngologist [education= " + getEducation() + ", firstName= " + getFirstName() + ", lastName= " + getLastName() +  ", age= " + getAge()  + 
			 ", gender= "+ getGender() + ", alive= " + isAlive() + ", docName= " + getDocName() +  " ,specialization= " + getSpecialization() +"]";
	}
	
	
}
