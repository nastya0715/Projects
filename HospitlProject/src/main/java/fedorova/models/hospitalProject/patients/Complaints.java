package fedorova.models.hospitalProject.patients;

import java.util.ArrayList;

public class Complaints {
	private ArrayList<Complaints>complaints;
	
	public Complaints () {
		
	};
	public Complaints (String string) {
		ArrayList<Complaints> complaints = new ArrayList<Complaints> ();
		Complaints c1 = new Complaints("toothAche");
		complaints.add(c1);
		Complaints c2 = new Complaints("heartAche");
		complaints.add(c2);
		Complaints c3 = new Complaints("LegAche");
		complaints.add(c3);
		Complaints c4 = new Complaints("snot");
		complaints.add(c4);
		Complaints c5 = new Complaints("sore throat");
		complaints.add(c5);
		Complaints c6 = new Complaints("earAche");
		complaints.add(c6);
		Complaints c7 = new Complaints("runny eyes");
		complaints.add(c7);
		Complaints c8 = new Complaints("depression");
		complaints.add(c8);
		Complaints c9 = new Complaints("appendicitis");
		complaints.add(c9);
		Complaints c10 = new Complaints("headAche");
		complaints.add(c10);
		Complaints c11 = new Complaints("badVision");
		complaints.add(c11);
		}
	public ArrayList<Complaints> getComplaints() {
		return complaints;
	}
	public void setComplaints(ArrayList<Complaints> complaints) {
		this.complaints = complaints;
	}


}