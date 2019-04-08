package fedorova.models.hospitalProject.patients;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import fedorova.models.hospitalProject.address.Address;



@XmlRootElement (name="Patient")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient extends People {
	@XmlElement(name = "address")
	private Address address = new Address(); 
	@XmlElement(name = "complaint")
	private String complaint;
	@XmlElement(name = "analysis")
	private String analysis;
	
	private final static Logger logger = Logger.getLogger(Patient.class);
	
	public Integer toComplain() {
		String [] arr = {"toothAche", "heartAche", "LegAche", "snot", "sore throat", "earAche", "runny eyes", "depression", "headAche", "badVision", "appendicitis"};
		Map <Integer, String> map = new HashMap<Integer, String>();
		Integer i = 1;
		for (String m: arr) {
			map.put(i++, m);}
		i = (1+(int)(Math.random()*11));
		logger.info(map.get(i));
		return i;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	@Override
	public String toString() {
		return "Patient [firstName= " + getFirstName() + ", lastName= " + getLastName() +  ", age= " + getAge() +  ", gender= " + getGender() 
				+ ", birthDate= " + getBirthDate() +  ", alive= " + isAlive() +  ", " + address + ", complaint=" + complaint + ", analysis=" + analysis + "]";
	}

	
	
	
			
}
