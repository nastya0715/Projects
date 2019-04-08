package fedorova.models.hospitalProject;

import org.apache.log4j.Logger;

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
import fedorova.models.hospitalProject.patients.Patient;



public class Runner {
	private final static Logger logger = Logger.getLogger(Runner.class);
	
	public static void main(String[] args) throws NameNullException  {
		Patient p1 = new Patient ();
		p1.setFirstName("Alec");
		p1.setLastName("Lightw");
		
		try {
		p1.setAge(-1);
		} catch (AgeOutOfRangeException e) {
			logger.error("The age under 0", e);
		}finally {
		}
		
		p1.setGender("mal");
		Integer p = p1.toComplain();
		int a = (1+(int) (Math.random()*2));
		if (a==2) {
					
			if(p==1) {
				Dentist den = new Dentist();
				den.setDocName("Dentist"); 
				den.cure();
			
			}
			if(p==2) {
				Cardiologist cardiolog = new Cardiologist(); 
				cardiolog.setDocName("Cardiologist");
				cardiolog.cure();
			}
			if(p==3) {
				Podiatrist pod = new Podiatrist();
				pod.setDocName("Podiatrist");
				pod.cure();
			}
			if(p==4||p==5||p==6) {
				Otolaryngologist otol = new Otolaryngologist(); 
				otol.setDocName("Ototlaryngologist");
				otol.cure();
			}
			if(p==7) {
				Allergist allerg = new Allergist(); 
				allerg.setDocName("Allergist");
				allerg.cure();
			}
			if(p==8||p==9) {
				Neurologist neuro = new Neurologist(); 
				neuro.setDocName("Neurologist");
				neuro.cure();
			}
			if(p==10) {
				Ophthalmologist ophth = new Ophthalmologist(); 
				ophth.setDocName("Ophthalmologist");
				ophth.cure();
			}
			if(p==11) {
				Surgeon surg = new Surgeon(); 
				surg.setDocName("Surgeon"); 
				surg.cure();
			}
		}
		else {
			logger.info("We can not heal you ");
		
		}
		
		
			
	}
}
	

		      
		   
		
	

