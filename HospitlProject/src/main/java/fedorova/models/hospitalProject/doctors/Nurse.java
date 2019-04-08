package fedorova.models.hospitalProject.doctors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name="Nurse")
public class Nurse extends Stuff implements IWork {
	@XmlElement(name = "emotionalStability")
	private String emotionalStability;
	@XmlElement(name = "interpersonalSkills")
	private String interpersonalSkills;
	@XmlElement(name = "observation")
	private String observation;
	
	private final static Logger logger = Logger.getLogger(Nurse.class);
	
	public void doProcedures () {
		
	}
	
	public void givePills () {
		
	}
	public void makeInjections () {
		
	}
	public void sanitationControl () {
		
	}
	public void colectAnalyzes () {
		
	}
	
	@Override
	public void work() {
		logger.info("Perform a doctor's appointments, refer to a doctor");
	}

	public String getEmotionalStability() {
		return emotionalStability;
	}
	public void setEmotionalStability(String emotionalStability) {
		this.emotionalStability = emotionalStability;
	}
	public String getInterpersonalSkills() {
		return interpersonalSkills;
	}
	public void setInterpersonalSkills(String interpersonalSkills) {
		this.interpersonalSkills = interpersonalSkills;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Override
	public String toString() {
		return "Nurse [firstName=" + getFirstName() + ", lastName= " + getLastName() + ", age= " + getAge()
		+ ", gender= " + getGender() +", alive= " + isAlive() + ", emotionalStability= " + emotionalStability 
		+ ", interpersonalSkills=" + interpersonalSkills + "]";
	}


	
	
}
