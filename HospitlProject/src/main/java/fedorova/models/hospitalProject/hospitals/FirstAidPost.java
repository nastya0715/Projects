package fedorova.models.hospitalProject.hospitals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import fedorova.models.hospitalProject.doctors.Nurse;


@XmlRootElement (name="FirstAidPost")
@XmlAccessorType(XmlAccessType.FIELD)
public class FirstAidPost extends MedicalInstitutes {
	@XmlElement(name = "nurse")
	private Nurse nurse = new Nurse();
	@XmlElement(name = "medicine")
	private String medicine;
	
	private final static Logger logger = Logger.getLogger(FirstAidPost.class);
	
	public FirstAidPost() {
	}

	public void getCure( double temperatute) {
		if (temperatute>=37.0) {
			logger.info("Take medicine");
			logger.info("Go home");
		}
		else {
			logger.info("You are healthy");
		}
	}
	
	public void getVaccination() {
		
	}
	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	@Override
	public String toString() {
		return "FirstAidPost [name= " +getName() + ", " +getAddress() + ", medicine=" + medicine + "]";
	}
	
	
}