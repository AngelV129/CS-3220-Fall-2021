package practiceController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import PracticeModel.Reservation;
import Service.DbsService;

@WebServlet("/DisplayReservations")
public class DisplayReservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayReservations() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbsService dbService = new DbsService();
		// Get list of reservatoins
		ArrayList<Reservation> res = dbService.getReservations();
		dbService.close();
		
		 String[] days = { "MON", "TUE", "WED", "THR", "FRI"};
		// array of string timestamps
		 String[] times = {"08:00-09:00","09:00-10:00","10:00-11:00","11:00-12:00","12:00-13:00","14:00-15:00","15:00-16:00","16:00-17:00"};
		
		
		request.setAttribute("reserves", res);
		request.setAttribute("days", days);
		request.setAttribute("times", times);

		request.getRequestDispatcher("/WEB-INF/DisplayReservations.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get values returned by form
		String name = request.getParameter("name");
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		
		
		DbsService dbs = new DbsService();
		dbs.addReservation(name, day, time);
		// Get list of reservatoins
		ArrayList<Reservation> res = dbs.getReservations();
		dbs.close();
		
		 String[] days = { "MON", "TUE", "WED", "THR", "FRI"};
		// array of string timestamps
		 String[] times = {"08:00-09:00","09:00-10:00","10:00-11:00","11:00-12:00","12:00-13:00","14:00-15:00","15:00-16:00","16:00-17:00"};
		
		
		request.setAttribute("reserves", res);
		request.setAttribute("days", days);
		request.setAttribute("times", times);
		response.sendRedirect("DisplayReservations");
	}

}
