package fedorova.models.hospitalProject.DOMParser;

import java.io.File;

public class DOMRunner {
	public static void main(String[] args) throws Exception{
		DOMParser domParser = new DOMParser();
		
		 File file = new File("src/main/resources/hospital.xml");    
	     
		
		//File file = new File("D:\\java\\eclipse\\workspace\\HospitlProject\\src\\main\\resources\\hospital.xml");
		
		//ClassLoader classLoader = DOMRunner.class.getClassLoader();
		//File file = classLoader.getResource("hospital.xml");
		//InputStream file = DOMRunner.class.getClassLoader().getResourceAsStream("hospital.xml");
		//File file = new File ("hospital.xml");
		domParser.domBuilderFile(file);
		domParser.placeHospital();
		domParser.placeFirstAidPost();
		domParser.placePolyclinic();
		domParser.placeLaboratory();
		domParser.placePatient();
		domParser.placeAllergist();
		domParser.placeCardiologist();
		domParser.placeDentist();
		domParser.placeNeurologist();
		domParser.placeOphthalmologist();
		domParser.placeOtolaryngologist();
		domParser.placePodiatrist();
		domParser.placeSurgeon();
		
}
}
