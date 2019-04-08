package fedorova.models.hospitalProject.patients;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.log4j.Logger;

import fedorova.models.hospitalProject.exceptions.AgeOutOfRangeException;
import fedorova.models.hospitalProject.exceptions.GenderOutOfNameException;
import fedorova.models.hospitalProject.exceptions.NameNullException;
import fedorova.models.hospitalProject.jaxb.DateAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public abstract class People  {
	@XmlElement(name = "firstName")
	private String firstName;
	@XmlElement(name = "lastName")
	private String lastName;
	@XmlAttribute(name = "age")
	private int age;
	@XmlElement(name = "gender")
	private String gender;
	@XmlElement(name = "birthDate")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date birthDate;
	@XmlElement(name = "alive")
	private boolean alive;
	private SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
	
	private final static Logger logger = Logger.getLogger(People.class);
		
	public People() {
	}
	
	public String getBirthDate () {
		return format.format(birthDate);
	}
	public void setBirthDate (String birthDate) throws Exception {
		this.birthDate = format.parse(birthDate);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) throws NameNullException {
		if (firstName == null) throw new NameNullException("Error: write name!");
		//logger.info ("FirstName - "+firstName);
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) throws NameNullException {
		if (lastName == null) throw new NameNullException("Error: write name!");
		//logger.info ("Last Name - "+lastName);
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws AgeOutOfRangeException {
		if (age<0) throw new AgeOutOfRangeException("Error: Wrong age!");
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if (gender.equals("male") || gender.equals("female")) {
			//logger.info ("Gender - "+gender);
		this.gender = gender;
		} else {
			try {
				logger.info("Incorrect gender name error handling");
				throw new GenderOutOfNameException ();
				
			} catch (GenderOutOfNameException e) {
				logger.debug("Gender incorrect name", e);
			}finally {}
		}	
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	
	
}
