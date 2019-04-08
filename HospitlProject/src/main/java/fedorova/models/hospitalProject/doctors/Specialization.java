package fedorova.models.hospitalProject.doctors;

import java.util.ArrayList;

public class Specialization {
	private ArrayList<String>specialization;

	public Specialization (String string) {
		ArrayList<Specialization> specializations = new ArrayList<Specialization> ();
		Specialization sp1 = new Specialization("toothAche");
		specializations.add(sp1);
		Specialization sp2 = new Specialization("heartAche");
		specializations.add(sp2);
		Specialization sp3 = new Specialization("legAche");
		specializations.add(sp3);
		Specialization sp4 = new Specialization("snot");
		specializations.add(sp4);
		Specialization sp5 = new Specialization("sore throat");
		specializations.add(sp5);
		Specialization sp6 = new Specialization("earAche");
		specializations.add(sp6);
		Specialization sp7 = new Specialization("runny eyes");
		specializations.add(sp7);
		Specialization sp8 = new Specialization("depression");
		specializations.add(sp8);
		Specialization sp9 = new Specialization("stomachAche");
		specializations.add(sp9);
		Specialization sp10 = new Specialization("headAche");
		specializations.add(sp10);
		Specialization sp11 = new Specialization("badVision");
		specializations.add(sp11);
		Specialization sp12 = new Specialization("operations");
		specializations.add(sp12);
	}
	
	public ArrayList<String> getComplaint() {
		return specialization;
	}
	public void setSpecialization(ArrayList<String> specialization) {
		this.specialization = specialization;
		
		}

}
