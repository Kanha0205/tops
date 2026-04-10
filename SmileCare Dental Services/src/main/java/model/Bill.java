package model;

public class Bill {

	
	private double treatmentCost;
	private double medicalCost;
	private double tex;
	private double discount;
	public double getTreatmentCost() {
		return treatmentCost;
	}
	public void setTreatmentCost(double treatmentCost) {
		this.treatmentCost = treatmentCost;
	}
	public double getMedicalCost() {
		return medicalCost;
	}
	public void setMedicalCost(double medicalCost) {
		this.medicalCost = medicalCost;
	}
	public double getTex() {
		return tex;
	}
	public void setTex(double tex) {
		this.tex = tex;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Bill(double treatmentCost, double medicalCost, double tex, double discount) {
		super();
		this.treatmentCost = treatmentCost;
		this.medicalCost = medicalCost;
		this.tex = tex;
		this.discount = discount;
	}
	
	public double calculateTotal() {
		return treatmentCost + medicalCost + tex - discount;
	}
	
	
	
	
	
}
