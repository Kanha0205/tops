package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Appointment;
import model.Bill;
import model.patient;

public class DaoConnection {
	Connection cn = null;
	
	public DaoConnection() {
		
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
						
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int ApointPatient(Appointment p) {
			int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("insert into appointment values(?,?,?,?)");
         ps.setInt(1, 0);
         ps.setString(2, p.getPatientName());
         ps.setString(3, p.getTreatment());
         ps.setString(4, p.getDate());

           i =  ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	
//	treatmentCost DOUBLE,
//    medicineCost DOUBLE,
//    tax DOUBLE,
//    discount DOUBLE,
//    total DOUBLE
	
    public int saveBill(Bill bill, double total) {
    	int i = 0;
    	try {
			PreparedStatement ps = cn.prepareStatement("insert into bill(treatmentCost, medicineCost, tax, discount, total) values (?,?,?,?,?)");
			ps.setDouble(1, bill.getTreatmentCost());
			ps.setDouble(2, bill.getMedicalCost());
			ps.setDouble(3, bill.getTex());
			ps.setDouble(4, bill.getDiscount());
			ps.setDouble(5, total);
			
			i =   ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return i;
    	
    }
	
	
	
}