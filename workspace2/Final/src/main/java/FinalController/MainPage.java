package FinalController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FinalService.Attendance;
import FinalService.DbsService;
import FinalService.Event;


@WebServlet("/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbsService dbs = new DbsService();
		ArrayList<Event> events = dbs.getEvents();
		ArrayList<Attendance> Attendances = dbs.getAttend();
		dbs.close();
		
		for(Event text:events) {
            System.out.println(text.getName());
         }
		
		request.setAttribute("events", events);
		request.setAttribute("Attendances", Attendances);

		request.getRequestDispatcher("/WEB-INF/MainPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
