package fedorova.models.hospitalProject.doctors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;


@XmlRootElement (name="Allergist")
@XmlAccessorType(XmlAccessType.FIELD)
public class Allergist extends Doctor implements ICure {
	@XmlElement(name = "alergicDeadNum")
	private int alergicDeadNum;
	
	private final static Logger logger = Logger.getLogger(Allergist.class);
	
	@Override
	public void cure () {
		int a = (int) (Math.random()); // 0 - light form; 1- severe form
		int time = (int) (Math.random()*20) ;
		if (a == 1 && time <= 10) {
			logger.info("Take an antiallergic pills");	
			logger.info("You will live");
			}
			else { 
				if (a == 1 && time > 10) {
				logger.info("Patient is dead");}
				else {
				logger.info("Take an antiallergic pills");		
				}
			}
	}


	public int getAlergicDeadNum() {
		return alergicDeadNum;
	}

	public void setAlergicDeadNum(int alergicDeadNum) {
		this.alergicDeadNum = alergicDeadNum;
	}

	@Override
	public String toString() {
		return "Allergist [education= " + getEducation() + ", firstName= " + getFirstName() + ", lastName= " + getLastName() +  ", age= " + getAge() +  ", gender= " + getGender()  + 	
	 ", alive= " + isAlive() + ", docName= " + getDocName() +  ", specialization=" + getSpecialization() + ", alergicDeadNum=" + alergicDeadNum + "]";
	}
	
	
}
