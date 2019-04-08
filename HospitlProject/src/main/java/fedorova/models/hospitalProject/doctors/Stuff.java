package fedorova.models.hospitalProject.doctors;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fedorova.models.hospitalProject.patients.People;

@XmlRootElement (name="Stuff")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Stuff extends People  {
	@XmlElement(name = "education")
	private String education;
	@XmlElement(name = "knowledge")
	private String knowledge; 
	@XmlElement(name = "qualification")
	private String qualification;
	
	public Stuff() {
		
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String toString() {
		return "Stuff [education=" + education + ", knowledge=" + knowledge + ", qualification=" + qualification + "]";
	}


	
	
}
