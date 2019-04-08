package fedorova.models.hospitalProject.doctors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name="Podiatrist")
public class Podiatrist extends Doctor implements ICure {
	@XmlElement(name = "mechanicsKnowledge")
	private String mechanicsKnowledge;
	
	private final static Logger logger = Logger.getLogger(Podiatrist.class);
	
	@Override
	public void cure() {
		logger.info("Conduct a survey");
		logger.info("Assign procedures");
	}

	public String getMechanicsKnowledge() {
		return mechanicsKnowledge;
	}
	public void setMechanicsKnowledge(String mechanicsKnowledge) {
		this.mechanicsKnowledge = mechanicsKnowledge;
	}
	@Override
	public String toString() {
		return "Podiatrist [education= " + getEducation() + ", firstName= " + getFirstName() + ", lastName= " + getLastName() +  ", age= " + getAge() 
		+ " , gender= "+ getGender() + ", alive= " + isAlive() + ", docName= " + getDocName() +  " ,specialization= " + getSpecialization() +"]";
	}
	
}
