package fedorova.models.hospitalProject.hospitals;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import fedorova.models.hospitalProject.doctors.Doctor;
import fedorova.models.hospitalProject.doctors.Nurse;



@XmlRootElement(name = "Hospital")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hospital extends MedicalInstitutes {
	@XmlElement(name = "doctorsQualification")
	private String doctorsQualification;
	@XmlElement(name = "chambersNum")
	private int chambersNum;
	@XmlElement(name = "chambersPlacesNum")
	private int chambersPlacesNum;
	@XmlElement(name = "patientNum")
	private int patientNum;
	@XmlElement(name = "specialization")
	private String specialization;
	@XmlElement(name = "departments")
	private String departments;
	@XmlElementWrapper(name="doctors", nillable = true)
	private List <Doctor> doctors;
	@XmlElementWrapper(name="nurses", nillable = true)
	private List <Nurse> nurses;
	

	public Hospital() {
		
	}
	public void typeOfEntrance() {
		
	}
	public String getDoctorsQualification() {
		return doctorsQualification;
	}
	public void setDoctorsQualification(String doctorsQualification) {
		this.doctorsQualification = doctorsQualification;
	}
	public int getChambersNum() {
		return chambersNum;
	}
	public void setChambersNum(int chambersNum) {
		this.chambersNum = chambersNum;
	}
	public int getChambersPlacesNum() {
		return chambersPlacesNum;
	}
	public void setChambersPlacesNum(int chambersPlacesNum) {
		this.chambersPlacesNum = chambersPlacesNum;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getPatientNum() {
		return patientNum;
	}
	public void setPatientNum(int patientNum) {
		this.patientNum = patientNum;
	}
	public String getDepartments() {
		return departments;
	}
	public void setDepartments(String departments) {
		this.departments = departments;
	}
	
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	public List<Nurse> getNurses() {
		return nurses;
	}
	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}

	@Override
	public String toString() {
		return "Hospital [name= " +getName() + ", " +getAddress() + ", doctorsQualification=" + doctorsQualification + ", chambersNum=" + chambersNum
				+ ", chambersPlacesNum=" + chambersPlacesNum + ", patientNum=" + patientNum +", specialization="
				+ specialization + "]";
	}
	
	
}
	

