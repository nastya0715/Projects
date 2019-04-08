package fedorova.models.hospitalProject.address;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)

public class Address {
	@XmlElement(name = "country")
	private Country country;
	@XmlElement(name = "city")
	private City city;
	@XmlElement(name = "street")
	private String street;
	@XmlElement(name = "buildingNum")
	private int buildingNum;
		
	public Address() {
		
	}
	public Address(City city, String street, int buildingNum) {
		this.country = city.getCountry();
		this.city = city;
		this.street = street;
		this.buildingNum = buildingNum;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + buildingNum;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (buildingNum != other.buildingNum)
			return false;
		if (this.hashCode()!=obj.hashCode())
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(int buildingNum) {
		this.buildingNum = buildingNum;
		
	}
	@Override
	public String toString() {
		return "Address [country=" + city.getCountry() + ", city=" + city + ", street=" + street + ", buildingNum=" + buildingNum
				+ "]";
	}
	
	
}