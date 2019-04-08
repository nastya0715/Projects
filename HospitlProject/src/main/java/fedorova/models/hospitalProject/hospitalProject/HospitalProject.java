package fedorova.models.hospitalProject.hospitalProject;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import fedorova.models.hospitalProject.doctors.Allergist;
import fedorova.models.hospitalProject.doctors.Cardiologist;
import fedorova.models.hospitalProject.doctors.Dentist;
import fedorova.models.hospitalProject.doctors.Neurologist;
import fedorova.models.hospitalProject.doctors.Ophthalmologist;
import fedorova.models.hospitalProject.doctors.Otolaryngologist;
import fedorova.models.hospitalProject.doctors.Podiatrist;
import fedorova.models.hospitalProject.doctors.Surgeon;
import fedorova.models.hospitalProject.hospitals.FirstAidPost;
import fedorova.models.hospitalProject.hospitals.Hospital;
import fedorova.models.hospitalProject.hospitals.Laboratory;
import fedorova.models.hospitalProject.hospitals.MedicalInstitutes;
import fedorova.models.hospitalProject.hospitals.Polyclinic;
import fedorova.models.hospitalProject.patients.Patient;
import fedorova.models.hospitalProject.patients.People;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement (name="HospitalProject")
@XmlAccessorType(XmlAccessType.FIELD)
public class HospitalProject {
	//@XmlElementWrapper(name="MedicalInstitutes", nillable = true)
	private List <MedicalInstitutes> medicalInsitutes;
	//@XmlElementWrapper(name="People", nillable = true)
	private List <People> peoples ;
	
	@XmlElement(name = "Hospital")
	@JsonProperty(value = "Hospital")
	private Hospital hospital = new Hospital();
	@XmlElement(name = "Polyclinic")
	@JsonProperty(value = "Polyclinic")
	private Polyclinic polyclinic = new Polyclinic();
	@XmlElement(name = "FirstAidPost")
	@JsonProperty(value = "FirstAidPost")
	private FirstAidPost firstAidPost = new FirstAidPost();
	@XmlElement(name = "Laboratory")
	@JsonProperty(value = "Laboratory")
	private Laboratory laboratory  = new Laboratory();
	@XmlElement(name = "Patient")
	@JsonProperty(value = "Patient")
	private Patient patient = new Patient();
	@XmlElement(name = "Allergist")
	@JsonProperty(value = "Allergist")
	private Allergist allergist = new Allergist();
	@XmlElement(name = "Cardiologist")
	@JsonProperty(value = "Cardiologist")
	private Cardiologist cardiologist = new Cardiologist();
	@XmlElement(name = "Dentist")
	@JsonProperty(value = "Dentist")
	private Dentist dentist = new Dentist();
	@XmlElement(name = "Neurologist")
	@JsonProperty(value = "Neurologist")
	private Neurologist neurologist = new Neurologist();
	@XmlElement(name = "Ophthalmologist")
	@JsonProperty(value = "Ophthalmologist")
	private Ophthalmologist ophthalmologist = new Ophthalmologist();
	@XmlElement(name = "Otolaryngologist")
	@JsonProperty(value = "Otolaryngologist")
	private Otolaryngologist otolaryngologist = new Otolaryngologist();
	@XmlElement(name = "Podiatrist")
	@JsonProperty(value = "Podiatrist")
	private Podiatrist podiatrist = new Podiatrist();
	@XmlElement(name = "Surgeon")
	@JsonProperty(value = "Surgeon")
	private Surgeon surgeon = new Surgeon();


	
	public HospitalProject() {
	
	}


	@Override
	public String toString() {
		return "HospitalProject [ " + hospital + ", "+"\r\n" + polyclinic +",  "+"\r\n" + firstAidPost +",  "+"\r\n" + laboratory 
				+ ",  "+"\r\n" + patient + ",  "+"\r\n" + allergist +",  "+"\r\n" + cardiologist +",  "+"\r\n" + dentist 
				+",  "+"\r\n" + neurologist +",  "+"\r\n" + ophthalmologist +",  "+"\r\n" + otolaryngologist +",  "+"\r\n" + podiatrist 
				+",  "+"\r\n" + surgeon +"]";
	}
	
	
	public List<MedicalInstitutes> getMedicalInsitutes() {
		return medicalInsitutes;
	}
	
	

	public void setMedicalInsitutes(List<MedicalInstitutes> medicalInsitutes) {
		this.medicalInsitutes = medicalInsitutes;
	}
	public List<People> getPeoples() {
		return peoples;
	}
	public void setPeoples(List<People> peoples) {
		this.peoples = peoples;
	}
	
	
}
