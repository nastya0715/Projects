package fedorova.models.hospitalProject.doctors;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name="Surgeon")
public class Surgeon extends Doctor implements ICure {
	@XmlElement(name = "operationNum")
	private int operationNum;
	@XmlElement(name = "deadNum")
	private int deadNum;
	
	private final static Logger logger = Logger.getLogger(Surgeon.class);
	
	@Override
	public void cure() {
		logger.info("Make operation");
		
	}

	public int getOperationNum() {
		return operationNum;
	}

	public void setOperationNum(int operationNum) {
		this.operationNum = operationNum;
	}

	public int getDeadNum() {
		return deadNum;
	}

	public void setDeadNum(int deadNum) {
		this.deadNum = deadNum;
	}

	@Override
	public String toString() {
		return "Surgeon [education= " + getEducation() + ", firstName= " + getFirstName() + ", lastName= " + getLastName() +  ", age= " + getAge() 
				+ " , gender= "+ getGender() + ", alive= " + isAlive() + ", docName= " + getDocName() +  " ,specialization= " + getSpecialization() + ", operationNum=" + operationNum 
				+ ", deadNum=" + deadNum + "]";
	}

	
}
