package lab8Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW3Service.DbsService;
import lab8Model.Lesson;

@WebServlet("/LessonsList")
public class LessonsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LessonsList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get list of lessons from database
		DbsService dbs = new DbsService();
		
		ArrayList<Lesson> lessons = dbs.getLessons();
		
		request.setAttribute("lessons", lessons);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		System.out.println(" Date of lesson: "+lessons.get(1).getDate());
//		System.out.println(dateFormat.format(lessons.get(1).getDate()));
		dbs.close();
		request.getRequestDispatcher("/WEB-INF/LessonsList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
