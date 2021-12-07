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


@WebServlet("/RemoveReservation")
public class RemoveReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RemoveReservation() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String[] days = { "MON", "TUE", "WED", "THR", "FRI"};
		// array of string timestamps
		 String[] times = {"08:00-09:00","09:00-10:00","10:00-11:00","11:00-12:00","12:00-13:00","14:00-15:00","15:00-16:00","16:00-17:00"};
		
		 int id  = Integer.parseInt(request.getParameter("targetID"));
		 DbsService dbs = new DbsService();
		 id = dbs.removeReservation(id);
		 ArrayList<Reservation> res = dbs.getReservations();
		 
		request.setAttribute("reserves", res);
		request.setAttribute("days", days);
		request.setAttribute("times", times);
		System.out.println(id);

		 dbs.close();
		 
		 request.getRequestDispatcher("/WEB-INF/DisplayReservations.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
