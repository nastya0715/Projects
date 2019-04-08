package fedorova.models.hospitalProject.hospitals;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import fedorova.models.hospitalProject.address.Address;
import fedorova.models.hospitalProject.doctors.Doctor;
import fedorova.models.hospitalProject.doctors.Stuff;
import fedorova.models.hospitalProject.patients.Patient;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MedicalInstitutes")
public abstract class MedicalInstitutes {
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "address")
	private Address address = new Address();
	@XmlElement(name = "stuff")
	private Stuff stuff;
	@XmlElementWrapper(name="doctors", nillable = true)
	private List <Doctor> doctors;
	@XmlElementWrapper(name="patients", nillable = true)
	private List <Patient> patients;	
	
	private final static Logger logger = Logger.getLogger(MedicalInstitutes.class);

	public MedicalInstitutes() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}
	public Stuff getStuff() {
		return stuff;
	}
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors( Doctor doctor) {
		this.doctors = new ArrayList <Doctor>();
		logger.info(doctors.size());
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

	
	

}
