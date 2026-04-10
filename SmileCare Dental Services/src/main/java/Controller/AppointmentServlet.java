package Controller;

import java.io.IOException;

import Dao.DaoConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Appointment;

@WebServlet("/pat")
public class AppointmentServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		String treatment = req.getParameter("treatment");
		String date = req.getParameter("date");
		
		Appointment ap = new Appointment(name,treatment,date);
		
		DaoConnection dao = new DaoConnection();
		int i = dao.ApointPatient(ap);
		if(i > 0) {
			
			req.setAttribute("name", name);
			req.setAttribute("Treatment", treatment);
			req.setAttribute("msg", "Add Patient Successfully");
			req.getRequestDispatcher("Billing.jsp").forward(req, resp);
		}
		

		
	}

}
