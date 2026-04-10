package model;

public class Appointment {
	private String PatientName;
	private String treatment;
	private String date;

//	public Appointment() {
//		
//	}

	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public Appointment(String patientName, String treatment, String date) {
		super();
		PatientName = patientName;
		this.treatment = treatment;
		this.date = date;
	}
}
	

