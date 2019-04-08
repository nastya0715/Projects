package fedorova.models.hospitalProject.doctors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name="Neurologist")
public class Neurologist extends Doctor implements ICure {
	@XmlElement(name = "electrodynamicsKnowledge")
	private String electrodynamicsKnowledge;
	
	private final static Logger logger = Logger.getLogger(Neurologist.class);
	
	@Override
	public void cure() {
		logger.info("Doing tests");	
	}
	public String getElectrodynamicsKnowledge() {
		return electrodynamicsKnowledge;
	}
	public void setElectrodynamicsKnowledge(String electrodynamicsKnowledge) {
		this.electrodynamicsKnowledge = electrodynamicsKnowledge;
	}
	@Override
	public String toString() {
		return "Neurologist [education= " + getEducation() + ", firstName= " + getFirstName() + ", lastName= " + getLastName() +  ", age= " + getAge() +  ", gender= "
				+ getGender() + ", alive= " + isAlive() + ", docName= " + getDocName() +  " ,specialization=" + getSpecialization() +"]";
	}
	
	
}
