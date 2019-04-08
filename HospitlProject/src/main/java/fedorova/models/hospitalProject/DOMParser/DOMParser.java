package fedorova.models.hospitalProject.DOMParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fedorova.models.hospitalProject.address.City;
import fedorova.models.hospitalProject.doctors.Allergist;
import fedorova.models.hospitalProject.doctors.Cardiologist;
import fedorova.models.hospitalProject.doctors.Dentist;
import fedorova.models.hospitalProject.doctors.Neurologist;
import fedorova.models.hospitalProject.doctors.Ophthalmologist;
import fedorova.models.hospitalProject.doctors.Otolaryngologist;
import fedorova.models.hospitalProject.doctors.Podiatrist;
import fedorova.models.hospitalProject.doctors.Surgeon;
import fedorova.models.hospitalProject.exceptions.AgeOutOfRangeException;
import fedorova.models.hospitalProject.exceptions.NameNullException;
import fedorova.models.hospitalProject.hospitals.FirstAidPost;
import fedorova.models.hospitalProject.hospitals.Hospital;
import fedorova.models.hospitalProject.hospitals.Laboratory;
import fedorova.models.hospitalProject.hospitals.Polyclinic;
import fedorova.models.hospitalProject.patients.Patient;


public class DOMParser {
	private final static Logger logger = Logger.getLogger(DOMParser.class);
	private  Document domBuilder;
	
	
	public Document domBuilderFile(File f) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(f);
		domBuilder = document;
		return domBuilder;
	}


	public void placeHospital ()  {
	NodeList hospitalNodeList =domBuilder.getElementsByTagName("Hospital");
	List<Hospital> hospitalsList = new ArrayList<>();
	int i = 0;
		if(hospitalNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
			Element hospitalElement = (Element) hospitalNodeList.item(i);
			Hospital hospital = new Hospital();
		
			NodeList hFieldsNodes = hospitalElement.getChildNodes();
			for (int j = 0; j< hFieldsNodes.getLength(); j++) {
				if(hFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
					Element hFieldsElement = (Element) hFieldsNodes.item(j);
					
					
					switch (hFieldsElement.getNodeName()) {
						case "name": {
							hospital.setName (hFieldsElement.getTextContent());
						} break;
						case "address": {
							
							NodeList addressNodeList = domBuilder.getElementsByTagName("address");
							int l = 0;
								if(addressNodeList.item(l).getNodeType()==Node.ELEMENT_NODE) {
									Element addressElement = (Element) addressNodeList.item(l);
									
									NodeList addressFieldsNodes = addressElement.getChildNodes();
									for (int m = 0; m< addressFieldsNodes.getLength(); m++) {
										if(addressFieldsNodes.item(m).getNodeType()==Node.ELEMENT_NODE) {
											Element addressFieldsElement = (Element) addressFieldsNodes.item(m);
											switch (addressFieldsElement.getNodeName()) {
												case "city":{
													hospital.getAddress().setCity(City.valueOf(addressFieldsElement.getTextContent().toUpperCase()));
												}break;
												case "country":{
													hospital.getAddress().getCountry();
												}break;
												case "street":{
													hospital.getAddress().setStreet(addressFieldsElement.getTextContent());
												}break;
												case "buildingNum":{
													hospital.getAddress().setBuildingNum(Integer.valueOf(addressFieldsElement.getTextContent()));
												}break;
											
											}
										}
									}
								}						
						}break;
						case "doctorsQualification": {
							hospital.setDoctorsQualification (hFieldsElement.getTextContent());
						}break;
						case "chambersNum": {
							hospital.setChambersNum (Integer.valueOf(hFieldsElement.getTextContent()));
						}break;
						case "chambersPlacesNum": {
							hospital.setChambersPlacesNum (Integer.valueOf(hFieldsElement.getTextContent()));
						}break;
						case "patientNum": {
							hospital.setPatientNum (Integer.valueOf(hFieldsElement.getTextContent()));
						}break;
						case "specialization": {
							hospital.setSpecialization (hFieldsElement.getTextContent());
						}break;
						case "departments": {
							hospital.setDepartments (hFieldsElement.getTextContent());
						}break;
						
					}
						
				}
			}hospitalsList.add(hospital); 
			 hospitalsList.forEach(logger::info);
		}
	}
	
	public void placeFirstAidPost () {
		NodeList firstAidNodeList = domBuilder.getElementsByTagName("FirstAidPost");
		List<FirstAidPost> firstAidList = new ArrayList<>();
		int i = 0;	
		if(firstAidNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
			Element firstAidPostElement = (Element) firstAidNodeList.item(i);
			FirstAidPost firstAid = new FirstAidPost();
	
			NodeList faFieldsNodes = firstAidPostElement.getChildNodes();
			for (int j = 0; j< faFieldsNodes.getLength(); j++) {
				if(faFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
					Element faFieldsElement = (Element) faFieldsNodes.item(j);
					
					
					switch (faFieldsElement.getNodeName()) {
						case "name": {
							firstAid.setName (faFieldsElement.getTextContent());
						} break;
						case "address": {
							NodeList addressNodeList = domBuilder.getElementsByTagName("address");
							int l = 2;
								if(addressNodeList.item(l).getNodeType()==Node.ELEMENT_NODE) {
									Element addressElement = (Element) addressNodeList.item(l);
									
									NodeList addressFieldsNodes = addressElement.getChildNodes();
									for (int m = 0; m< addressFieldsNodes.getLength(); m++) {
										if(addressFieldsNodes.item(m).getNodeType()==Node.ELEMENT_NODE) {
											Element addressFieldsElement = (Element) addressFieldsNodes.item(m);
											switch (addressFieldsElement.getNodeName()) {
												case "city":{
													firstAid.getAddress().setCity(City.valueOf(addressFieldsElement.getTextContent().toUpperCase()));
												}break;
												case "country":{
													firstAid.getAddress().getCountry();
												}break;
												case "street":{
													firstAid.getAddress().setStreet(addressFieldsElement.getTextContent());
												}break;
												case "buildingNum":{
													firstAid.getAddress().setBuildingNum(Integer.valueOf(addressFieldsElement.getTextContent()));
												}break;
											
											}
										}
									}
								}							
						}break;
						case "medicine": {
							firstAid.setMedicine (faFieldsElement.getTextContent());
						}break;
												
					}
					
				}
				
			}
		firstAidList.add(firstAid);
		firstAidList.forEach(logger::info);
		}
	}

	public void placePolyclinic () {
	NodeList polyclinicNodeList = domBuilder.getElementsByTagName("Polyclinic");
	List<Polyclinic> polyclinicList = new ArrayList<>();
	int i = 0;
		if(polyclinicNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
			Element polyclinicElement = (Element) polyclinicNodeList.item(i);
			Polyclinic polyclinic = new Polyclinic();
		
			NodeList polyclinicFieldsNodes = polyclinicElement.getChildNodes();
			for (int j = 0; j< polyclinicFieldsNodes.getLength(); j++) {
				if(polyclinicFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
					Element polyclinicFieldsElement = (Element) polyclinicFieldsNodes.item(j);
					
					
					switch (polyclinicFieldsElement.getNodeName()) {
						case "name": {
							polyclinic.setName (polyclinicFieldsElement.getTextContent());
						} break;
						case "address": {
							
							NodeList addressNodeList = domBuilder.getElementsByTagName("address");
							int l = 1;
								if(addressNodeList.item(l).getNodeType()==Node.ELEMENT_NODE) {
									Element addressElement = (Element) addressNodeList.item(l);
								
									NodeList addressFieldsNodes = addressElement.getChildNodes();
									for (int m = 0; m< addressFieldsNodes.getLength(); m++) {
										if(addressFieldsNodes.item(m).getNodeType()==Node.ELEMENT_NODE) {
											Element addressFieldsElement = (Element) addressFieldsNodes.item(m);
											switch (addressFieldsElement.getNodeName()) {
												case "city":{
													polyclinic.getAddress().setCity(City.valueOf(addressFieldsElement.getTextContent().toUpperCase()));
												}break;
												case "country":{
													polyclinic.getAddress().getCountry();
												}break;
												case "street":{
													polyclinic.getAddress().setStreet(addressFieldsElement.getTextContent());
												}break;
												case "buildingNum":{
													polyclinic.getAddress().setBuildingNum(Integer.valueOf(addressFieldsElement.getTextContent()));
												}break;
											
											}
										}
									}
								}							
															
						}break;
						case "doctorsQualification": {
							polyclinic.setDoctorsQualification (polyclinicFieldsElement.getTextContent());
						}break;
						case "districtAffiliation": {
							polyclinic.setDistrictAffiliation (polyclinicFieldsElement.getTextContent());
						}break;
						case "doctorsAppointment": {
							polyclinic.setDoctorsAppointment (polyclinicFieldsElement.getTextContent());
						}break;
						case "registry": {
							polyclinic.setRegistry (polyclinicFieldsElement.getTextContent());
						}break;
						case "cabinetNum": {
							polyclinic.setCabinetNum (Integer.valueOf(polyclinicFieldsElement.getTextContent()));
						}break;
					}
					
				}
				
			}
			polyclinicList.add(polyclinic);
			polyclinicList.forEach(logger::info);
		}
	}
	
	public void placeLaboratory () {
	NodeList laboratoryNodeList = domBuilder.getElementsByTagName("Laboratory");
	List<Laboratory> laboratoryList = new ArrayList<>();
	int i = 0;
		if(laboratoryNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
			Element laboratoryElement = (Element) laboratoryNodeList.item(i);
			Laboratory laboratory = new Laboratory();
		
			NodeList laboratoryFieldsNodes = laboratoryElement.getChildNodes();
			for (int j = 0; j< laboratoryFieldsNodes.getLength(); j++) {
				if(laboratoryFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
					Element laboratoryFieldsElement = (Element) laboratoryFieldsNodes.item(j);
					
					
					switch (laboratoryFieldsElement.getNodeName()) {
						case "name": {
							laboratory.setName (laboratoryFieldsElement.getTextContent());
						} break;
						case "address": {
	
							NodeList addressNodeList = domBuilder.getElementsByTagName("address");
							int l = 3;
								if(addressNodeList.item(l).getNodeType()==Node.ELEMENT_NODE) {
									Element addressElement = (Element) addressNodeList.item(l);
								
									NodeList addressFieldsNodes = addressElement.getChildNodes();
									for (int m = 0; m< addressFieldsNodes.getLength(); m++) {
										if(addressFieldsNodes.item(m).getNodeType()==Node.ELEMENT_NODE) {
											Element addressFieldsElement = (Element) addressFieldsNodes.item(m);
											switch (addressFieldsElement.getNodeName()) {
												case "city":{
													laboratory.getAddress().setCity(City.valueOf(addressFieldsElement.getTextContent().toUpperCase()));
												}break;
												case "country":{
													laboratory.getAddress().getCountry();
												}break;
												case "street":{
													laboratory.getAddress().setStreet(addressFieldsElement.getTextContent());
												}break;
												case "buildingNum":{
													laboratory.getAddress().setBuildingNum(Integer.valueOf(addressFieldsElement.getTextContent()));
												}break;
											
											}
										}
									}
								}			
						}break;
						case "analysis": {
							laboratory.setAnalysis (laboratoryFieldsElement.getTextContent());
						}break;
						case "analysisType": {
							laboratory.setAnalysisType (laboratoryFieldsElement.getTextContent());
						}break;
						
					}
					
				}
				
			}
		laboratoryList.add(laboratory);
		laboratoryList.forEach(logger::info);
		}
	}	
	
	public void placePatient () throws Exception {	
	NodeList patientNodeList = domBuilder.getElementsByTagName("Patient");
	List<Patient> patientList = new ArrayList<>();
	int i = 0;
		if(patientNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
			Element patientElement = (Element) patientNodeList.item(i);
			Patient patient = new Patient();
			patient.setAge (Integer.valueOf(patientElement.getAttribute("age")));
		
			NodeList patientFieldsNodes = patientElement.getChildNodes();
			for (int j = 0; j< patientFieldsNodes.getLength(); j++) {
				if(patientFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
					Element patientFieldsElement = (Element) patientFieldsNodes.item(j);
					
					switch (patientFieldsElement.getNodeName()) {
						case "firstName": {
							patient.setFirstName (patientFieldsElement.getTextContent());
						} break;
						case "lastName": {
							patient.setLastName (patientFieldsElement.getTextContent());
						} break;
						case "gender": {
							patient.setGender (patientFieldsElement.getTextContent());
						} break;
						case "birthDate": {
							patient.setBirthDate (patientFieldsElement.getTextContent());
						} break;
						case "alive": {
							patient.setAlive (Boolean.valueOf(patientFieldsElement.getTextContent()));
						} break;
						case "address": {
	
							NodeList addressNodeList = domBuilder.getElementsByTagName("address");
							int l = 3;
								if(addressNodeList.item(l).getNodeType()==Node.ELEMENT_NODE) {
									Element addressElement = (Element) addressNodeList.item(l);
								
									NodeList addressFieldsNodes = addressElement.getChildNodes();
									for (int m = 0; m< addressFieldsNodes.getLength(); m++) {
										if(addressFieldsNodes.item(m).getNodeType()==Node.ELEMENT_NODE) {
											Element addressFieldsElement = (Element) addressFieldsNodes.item(m);
											switch (addressFieldsElement.getNodeName()) {
												case "city":{
													patient.getAddress().setCity(City.valueOf(addressFieldsElement.getTextContent().toUpperCase()));
												}break;
												case "country":{
													patient.getAddress().getCountry();
												}break;
												case "street":{
													patient.getAddress().setStreet(addressFieldsElement.getTextContent());
												}break;
												case "buildingNum":{
													patient.getAddress().setBuildingNum(Integer.valueOf(addressFieldsElement.getTextContent()));
												}break;
											
											}
										}
									}
								}			
						}break;
						case "complaints": {
							patient.setComplaint (patientFieldsElement.getTextContent());
						}break;
						case "analysis": {
							patient.setAnalysis (patientFieldsElement.getTextContent());
						}break;
										
					}
					
				}
				
			}
			patientList.add(patient);
			patientList.forEach(logger::info);
		}
	}
		
	public void placeAllergist () throws NumberFormatException, AgeOutOfRangeException, DOMException, NameNullException {
		NodeList allergistNodeList = domBuilder.getElementsByTagName("Allergist");
		List<Allergist> allergistList = new ArrayList<>();
		int i = 0;
			if(allergistNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
				Element allergistElement = (Element) allergistNodeList.item(i);
				Allergist allergist = new Allergist();
				allergist.setAge (Integer.valueOf(allergistElement.getAttribute("age")));
			
				NodeList allergistFieldsNodes = allergistElement.getChildNodes();
				for (int j = 0; j< allergistFieldsNodes.getLength(); j++) {
					if(allergistFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
						Element allergistFieldsElement = (Element) allergistFieldsNodes.item(j);
						
						switch (allergistFieldsElement.getNodeName()) {
							case "education": {
								allergist.setEducation (allergistFieldsElement.getTextContent());
							} break;
							case "firstName": {
								allergist.setFirstName (allergistFieldsElement.getTextContent());
							} break;
							case "lastName": {
								allergist.setLastName (allergistFieldsElement.getTextContent());
							} break;
							case "gender": {
								allergist.setGender (allergistFieldsElement.getTextContent());
							} break;
							case "alive": {
								allergist.setAlive (Boolean.valueOf(allergistFieldsElement.getTextContent()));
							} break;
							case "docName": {
								allergist.setDocName (allergistFieldsElement.getTextContent());
							}break;
							case "specialization": {
								allergist.setSpecialization (allergistFieldsElement.getTextContent());
							}break;
							case "alergicDeadNum": {
								allergist.setAlergicDeadNum (Integer.valueOf(allergistFieldsElement.getTextContent()));
							} break;				
						}
						
					}
					
				}
				
				allergistList.add(allergist);
				allergistList.forEach(logger::info);
		}
	}
		
	public void placeCardiologist () throws NumberFormatException, AgeOutOfRangeException, DOMException, NameNullException {		
		NodeList cardiologistNodeList = domBuilder.getElementsByTagName("Cardiologist");
		List<Cardiologist> cardiologistList = new ArrayList<>();
		int i = 0;
			if(cardiologistNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
				Element cardiologistElement = (Element) cardiologistNodeList.item(i);
				Cardiologist cardiologist = new Cardiologist();
				cardiologist.setAge (Integer.valueOf(cardiologistElement.getAttribute("age")));
					
				NodeList cardiologistFieldsNodes = cardiologistElement.getChildNodes();
				for (int j = 0; j< cardiologistFieldsNodes.getLength(); j++) {
					if(cardiologistFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
						Element cardiologistFieldsElement = (Element) cardiologistFieldsNodes.item(j);
								
						switch (cardiologistFieldsElement.getNodeName()) {
							case "education": {
								cardiologist.setEducation (cardiologistFieldsElement.getTextContent());
							} break;								case "firstName": {
								cardiologist.setFirstName (cardiologistFieldsElement.getTextContent());
							} break;
							case "lastName": {
								cardiologist.setLastName (cardiologistFieldsElement.getTextContent());
							} break;
							case "gender": {
								cardiologist.setGender (cardiologistFieldsElement.getTextContent());
							} break;
							case "alive": {
								cardiologist.setAlive (Boolean.valueOf(cardiologistFieldsElement.getTextContent()));
							} break;
							case "docName": {
								cardiologist.setDocName (cardiologistFieldsElement.getTextContent());
							}break;
							case "specialization": {
								cardiologist.setSpecialization (cardiologistFieldsElement.getTextContent());
							}break;
													
						}
								
					}
							
				}
				cardiologistList.add(cardiologist);
				cardiologistList.forEach(logger::info);
		}	
	}
	
	public void placeDentist () throws NumberFormatException, AgeOutOfRangeException, DOMException, NameNullException {
		NodeList dentistNodeList = domBuilder.getElementsByTagName("Dentist");
		List<Dentist> dentistList = new ArrayList<>();
		int i = 0;
			if(dentistNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
				Element dentistElement = (Element) dentistNodeList.item(i);
				Dentist dentist = new Dentist();
				dentist.setAge (Integer.valueOf(dentistElement.getAttribute("age")));
			
				NodeList dentistFieldsNodes = dentistElement.getChildNodes();
				for (int j = 0; j< dentistFieldsNodes.getLength(); j++) {
					if(dentistFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
						Element dentistFieldsElement = (Element) dentistFieldsNodes.item(j);
									
						switch (dentistFieldsElement.getNodeName()) {
							case "education": {
								dentist.setEducation (dentistFieldsElement.getTextContent());
							} break;
							case "firstName": {
								dentist.setFirstName (dentistFieldsElement.getTextContent());
							} break;
							case "lastName": {
								dentist.setLastName (dentistFieldsElement.getTextContent());
							} break;
							case "gender": {
								dentist.setGender (dentistFieldsElement.getTextContent());
							} break;
							case "alive": {
								dentist.setAlive (Boolean.valueOf(dentistFieldsElement.getTextContent()));
							} break;
							case "docName": {
								dentist.setDocName (dentistFieldsElement.getTextContent());
							}break;
							case "specialization": {
								dentist.setSpecialization (dentistFieldsElement.getTextContent());
							}break;
							case "pulledOutTeethNum": {
								dentist.setPulledOutTeethNum (Integer.valueOf(dentistFieldsElement.getTextContent()));
							} break;				
						}
									
					}
							
				}
				dentistList.add(dentist);
				dentistList.forEach(logger::info);
		}	
	}	
			
	public void placeNeurologist () throws NumberFormatException, AgeOutOfRangeException, DOMException, NameNullException {
		NodeList neurologistNodeList = domBuilder.getElementsByTagName("Neurologist");
		List<Neurologist> neurologistList = new ArrayList<>();
		int i = 0;
			if(neurologistNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
				Element neurologistElement = (Element) neurologistNodeList.item(i);
				Neurologist neurologist = new Neurologist();
				neurologist.setAge (Integer.valueOf(neurologistElement.getAttribute("age")));
						
				NodeList neurologistFieldsNodes = neurologistElement.getChildNodes();
				for (int j = 0; j< neurologistFieldsNodes.getLength(); j++) {
					if(neurologistFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
						Element neurologistFieldsElement = (Element) neurologistFieldsNodes.item(j);
										
						switch (neurologistFieldsElement.getNodeName()) {
							case "education": {
								neurologist.setEducation (neurologistFieldsElement.getTextContent());
							} break;
							case "firstName": {
								neurologist.setFirstName (neurologistFieldsElement.getTextContent());
							} break;
							case "lastName": {
								neurologist.setLastName (neurologistFieldsElement.getTextContent());
							} break;
							case "gender": {
			 					neurologist.setGender (neurologistFieldsElement.getTextContent());
							} break;
							case "alive": {
								neurologist.setAlive (Boolean.valueOf(neurologistFieldsElement.getTextContent()));
							} break;
							case "docName": {
								neurologist.setDocName (neurologistFieldsElement.getTextContent());
							}break;
							case "specialization": {
								neurologist.setSpecialization (neurologistFieldsElement.getTextContent());
							}break;
															
						}
										
				}
									
			}
				neurologistList.add(neurologist);
				neurologistList.forEach(logger::info);
		}	
	}
	
	public void placeOphthalmologist () throws NumberFormatException, AgeOutOfRangeException, DOMException, NameNullException {
		NodeList ophthalmologistNodeList = domBuilder.getElementsByTagName("Ophthalmologist");
		List<Ophthalmologist> ophthalmologistList = new ArrayList<>();
		int i = 0;
		if(ophthalmologistNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
			Element ophthalmologistElement = (Element) ophthalmologistNodeList.item(i);
			Ophthalmologist ophthalmologist = new Ophthalmologist();
			ophthalmologist.setAge (Integer.valueOf(ophthalmologistElement.getAttribute("age")));
							
			NodeList ophthalmologistFieldsNodes = ophthalmologistElement.getChildNodes();
			for (int j = 0; j< ophthalmologistFieldsNodes.getLength(); j++) {
				if(ophthalmologistFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
					Element ophthalmologistFieldsElement = (Element) ophthalmologistFieldsNodes.item(j);
										
					switch (ophthalmologistFieldsElement.getNodeName()) {
						case "education": {
							ophthalmologist.setEducation (ophthalmologistFieldsElement.getTextContent());
						} break;
						case "firstName": {
							ophthalmologist.setFirstName (ophthalmologistFieldsElement.getTextContent());
						} break;
						case "lastName": {
							ophthalmologist.setLastName (ophthalmologistFieldsElement.getTextContent());
						} break;
						case "gender": {
							ophthalmologist.setGender (ophthalmologistFieldsElement.getTextContent());
						} break;
						case "alive": {
							ophthalmologist.setAlive (Boolean.valueOf(ophthalmologistFieldsElement.getTextContent()));
						} break;
						case "docName": {
							ophthalmologist.setDocName (ophthalmologistFieldsElement.getTextContent());
						}break;
						case "specialization": {
							ophthalmologist.setSpecialization (ophthalmologistFieldsElement.getTextContent());
						}break;
													
					}
											
				}
										
			}
			ophthalmologistList.add(ophthalmologist);
			ophthalmologistList.forEach(logger::info);
		}
	}
			
	public void placeOtolaryngologist () throws NumberFormatException, AgeOutOfRangeException, DOMException, NameNullException {		
		NodeList otolaryngologistNodeList = domBuilder.getElementsByTagName("Otolaryngologist");
		List<Otolaryngologist> otolaryngologistList = new ArrayList<>();
		int i = 0;
		if(otolaryngologistNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
			Element otolaryngologistElement = (Element) otolaryngologistNodeList.item(i);
			Otolaryngologist otolaryngologist = new Otolaryngologist();
			otolaryngologist.setAge (Integer.valueOf(otolaryngologistElement.getAttribute("age")));
							
			NodeList otolaryngologistFieldsNodes = otolaryngologistElement.getChildNodes();
			for (int j = 0; j< otolaryngologistFieldsNodes.getLength(); j++) {
				if(otolaryngologistFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
					Element otolaryngologistFieldsElement = (Element) otolaryngologistFieldsNodes.item(j);
										
					switch (otolaryngologistFieldsElement.getNodeName()) {
						case "education": {
							otolaryngologist.setEducation (otolaryngologistFieldsElement.getTextContent());
						} break;
						case "firstName": {
							otolaryngologist.setFirstName (otolaryngologistFieldsElement.getTextContent());
						} break;
						case "lastName": {
							otolaryngologist.setLastName (otolaryngologistFieldsElement.getTextContent());
						} break;
						case "gender": {
							otolaryngologist.setGender (otolaryngologistFieldsElement.getTextContent());
						} break;
						case "alive": {
							otolaryngologist.setAlive (Boolean.valueOf(otolaryngologistFieldsElement.getTextContent()));
						} break;
						case "docName": {
							otolaryngologist.setDocName (otolaryngologistFieldsElement.getTextContent());
						}break;
						case "specialization": {
							otolaryngologist.setSpecialization (otolaryngologistFieldsElement.getTextContent());
						}break;
													
					}
											
				}
										
			}
			otolaryngologistList.add(otolaryngologist);
			otolaryngologistList.forEach(logger::info);
		}	
	}
		
	public void placePodiatrist () throws NumberFormatException, AgeOutOfRangeException, DOMException, NameNullException {
		NodeList podiatristNodeList = domBuilder.getElementsByTagName("Podiatrist");
		List<Podiatrist> podiatristList = new ArrayList<>();
		int i = 0;
		if(podiatristNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
			Element podiatristElement = (Element) podiatristNodeList.item(i);
			Podiatrist podiatrist = new Podiatrist();
			podiatrist.setAge (Integer.valueOf(podiatristElement.getAttribute("age")));
							
			NodeList podiatristFieldsNodes = podiatristElement.getChildNodes();
			for (int j = 0; j< podiatristFieldsNodes.getLength(); j++) {
				if(podiatristFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
					Element podiatristFieldsElement = (Element) podiatristFieldsNodes.item(j);
										
					switch (podiatristFieldsElement.getNodeName()) {
						case "education": {
							podiatrist.setEducation (podiatristFieldsElement.getTextContent());
						} break;
						case "firstName": {
							podiatrist.setFirstName (podiatristFieldsElement.getTextContent());
						} break;
						case "lastName": {
							podiatrist.setLastName (podiatristFieldsElement.getTextContent());
						} break;
						case "gender": {
							podiatrist.setGender (podiatristFieldsElement.getTextContent());
						} break;
						case "alive": {
							podiatrist.setAlive (Boolean.valueOf(podiatristFieldsElement.getTextContent()));
						} break;
						case "docName": {
							podiatrist.setDocName (podiatristFieldsElement.getTextContent());
						}break;
						case "specialization": {
							podiatrist.setSpecialization (podiatristFieldsElement.getTextContent());
						}break;
													
					}
											
				}
										
			}
			podiatristList.add(podiatrist);
			podiatristList.forEach(logger::info);
		}
	}
	
	public void placeSurgeon () throws NumberFormatException, AgeOutOfRangeException, DOMException, NameNullException {	
		NodeList surgeonNodeList = domBuilder.getElementsByTagName("Surgeon");
		List<Surgeon> surgeonList = new ArrayList<>();
		int i = 0;
		if(surgeonNodeList.item(i).getNodeType()==Node.ELEMENT_NODE) {
			Element surgeonElement = (Element) surgeonNodeList.item(i);
			Surgeon surgeon = new Surgeon();
			surgeon.setAge (Integer.valueOf(surgeonElement.getAttribute("age")));
							
			NodeList surgeonFieldsNodes = surgeonElement.getChildNodes();
			for (int j = 0; j< surgeonFieldsNodes.getLength(); j++) {
				if(surgeonFieldsNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
					Element surgeonFieldsElement = (Element) surgeonFieldsNodes.item(j);
										
					switch (surgeonFieldsElement.getNodeName()) {
						case "education": {
							surgeon.setEducation (surgeonFieldsElement.getTextContent());
						} break;
						case "firstName": {
							surgeon.setFirstName (surgeonFieldsElement.getTextContent());
						} break;
						case "lastName": {
							surgeon.setLastName (surgeonFieldsElement.getTextContent());
						} break;
						case "gender": {
							surgeon.setGender (surgeonFieldsElement.getTextContent());
						} break;
						case "alive": {
							surgeon.setAlive (Boolean.valueOf(surgeonFieldsElement.getTextContent()));
						} break;
						case "docName": {
							surgeon.setDocName (surgeonFieldsElement.getTextContent());
						}break;
						case "specialization": {
							surgeon.setSpecialization (surgeonFieldsElement.getTextContent());
						}break;
						case "operationNum": {
							surgeon.setOperationNum (Integer.valueOf(surgeonFieldsElement.getTextContent()));
						} break;	
						case "deadNum": {
							surgeon.setDeadNum (Integer.valueOf(surgeonFieldsElement.getTextContent()));
						} break;
					}
											
				}
										
			}
			surgeonList.add(surgeon);
			surgeonList.forEach(logger::info);
		}		
	}

	
		
}	
	
	
