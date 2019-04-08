package fedorova.models.hospitalProject.doctors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name="Dentist")
public class Dentist extends Doctor implements ICure {
	@XmlElement(name = "pulledOutTeethNum")
	private int pulledOutTeethNum;
	
	private final static Logger logger = Logger.getLogger(Dentist.class);
	
	public void putBraces() {
		
	}
	public void makeWhitening() {
		
	}
	
	@Override
	public void cure() {
		int a = (int) (Math.random()*2); // 0 - light form; 1- severe form
		if (a == 1) {
			logger.info("Make injection of anesthesia");	
			logger.info("Pull out a tooth");
			}
			else { 
				logger.info("Heal tooth");		
				
			}
	}

	public int getPulledOutTeethNum() {
		return pulledOutTeethNum;
	}
	public void setPulledOutTeethNum(int pulledOutTeethNum) {
		this.pulledOutTeethNum = pulledOutTeethNum;
	}
	@Override
	public String toString() {
		return "Dentist [education= " + getEducation() + ", firstName= " + getFirstName() + ", lastName= " + getLastName() +  ", age= " + getAge() +  ", gender= " + getGender()    
				+ ", alive= " + isAlive() + ", docName= " + getDocName() +  " ,specialization=" + getSpecialization() + ", pulledOutTeethNum=" + pulledOutTeethNum + "]";
	}
	
	

}
