package fedorova.models.hospitalProject.doctors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name="Doctor")
public abstract class Doctor extends Stuff implements IWork {
	@XmlElement(name = "docName")
	private String docName;
	@XmlElement(name = "specialization")
	private String specialization;
	@XmlElement(name = "heal")
	private boolean heal;
	
	private final static Logger logger = Logger.getLogger(Doctor.class);
		
	@Override
	public void work() {
		logger.info(" Cure, make an appointment, prescribe medication");
	}
	public boolean isHeal() {
		return heal;
		}
	public void setHeal(boolean heal) {
		this.heal = heal;
		}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		//logger.info("Doctor specialization - "+docName);
		this.docName = docName;
		
	
	}

	@Override
	public String toString() {
		return "Doctor [docName=" + docName + ", specialization=" + specialization + ", heal=" + heal + "]";
	}
	
	
	
}
