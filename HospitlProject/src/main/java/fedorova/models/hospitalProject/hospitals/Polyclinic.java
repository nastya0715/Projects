package fedorova.models.hospitalProject.hospitals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fedorova.models.hospitalProject.doctors.Doctor;
import fedorova.models.hospitalProject.doctors.Nurse;


@XmlRootElement(name = "Polyclinic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Polyclinic extends MedicalInstitutes {
	@XmlElement(name = "doctorsQualification")
	private String doctorsQualification;
	@XmlElement(name = "districtAffiliation")
	private String districtAffiliation;
	@XmlElement(name = "doctorsAppointment")
	private String doctorsAppointment;
	@XmlElement(name = "registry")
	private String registry;
	@XmlElement(name = "cabinetNum")
	private int cabinetNum;
	@XmlElement(name = "doctor")
	private Doctor doctor;
	@XmlElement(name = "nurse")
	private Nurse nurse = new Nurse();
	
	
	public Polyclinic() {
	}
	
	public void preventiveWork () {
		
	}
	public void medicalExamination () {
		
	}
	public String getDoctorsQualification() {
		return doctorsQualification;
	}
	public void setDoctorsQualification(String doctorsQualification) {
		this.doctorsQualification = doctorsQualification;
	}
	public String getDistrictAffiliation() {
		return districtAffiliation;
	}
	public void setDistrictAffiliation(String districtAffiliation) {
		this.districtAffiliation = districtAffiliation;
	}
	public String getDoctorsAppointment() {
		return doctorsAppointment;
	}
	public void setDoctorsAppointment(String doctorsAppointment) {
		this.doctorsAppointment = doctorsAppointment;
	}
	
	public String getRegistry() {
		return registry;
	}
	public void setRegistry(String registry) {
		this.registry = registry;
	}
	public int getCabinetNum() {
		return cabinetNum;
	}
	public void setCabinetNum(int cabinetNum) {
		this.cabinetNum = cabinetNum;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Nurse getNurse() {
		return nurse;
	}
	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}
	@Override
	public String toString() {
		return "Polyclinic [name= " +getName() + ", " +getAddress()   
				+",doctorsQualification=" + doctorsQualification + ", districtAffiliation="
				+ districtAffiliation + ", registry=" + registry + ", cabinetNum=" + cabinetNum + "]";
	}
	
	

}
