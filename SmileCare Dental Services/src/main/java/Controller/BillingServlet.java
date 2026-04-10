package Controller;

import java.io.IOException;

import Dao.DaoConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Bill;

@WebServlet("/bill")
public class BillingServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		
		try {
			double TreatmentCost = Double.parseDouble(req.getParameter("Tretment Cost"));
			double MedicalCost = Double.parseDouble(req.getParameter("medicine Cost"));
			double Tex =  Double.parseDouble(req.getParameter("TEX"));
			double Discount = Double.parseDouble(req.getParameter("Discount"));
			
			Bill  bill  = new Bill(TreatmentCost, MedicalCost, Tex, Discount);
			
			double total = bill.calculateTotal();
					
			DaoConnection dao = new DaoConnection();
			dao.saveBill(bill, total);
			
			
			req.setAttribute("tcost", TreatmentCost);
			req.setAttribute("mCost", MedicalCost);
			req.setAttribute("tex", Tex);
			req.setAttribute("discount", Discount);
			req.setAttribute("total", total);
			req.getRequestDispatcher("Invoice.jsp").forward(req, resp);
				
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
