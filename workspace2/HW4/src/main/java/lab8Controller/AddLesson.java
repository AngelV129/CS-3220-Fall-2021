package lab8Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW3Service.DbsService;
import lab8Model.Group;
import lab8Model.Lesson;
import lab8Model.Student;

@WebServlet("/AddLesson")
public class AddLesson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddLesson() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get list of lessons from database
		DbsService dbs = new DbsService();
		
		ArrayList<Lesson> lessons = dbs.getLessons();
		List<Student> students = dbs.getStudents();
		ArrayList<Group> groups = dbs.getGroups();
		
		request.setAttribute("lessons", lessons);
		request.setAttribute("students", students);
		request.setAttribute("groups", groups);
		
		dbs.close();
		request.getRequestDispatcher("/WEB-INF/AddLesson.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =  Integer.parseInt(request.getParameter("dropdown"));
		String datetimeLocal = request.getParameter("date");
		String time = datetimeLocal.replace("T"," ");
		String length = request.getParameter("length");
		String type = request.getParameter("type");
		
		// selected holds the hidden value of selected type
		// selectedAGroup
		// selectedAStudent
		String selected = request.getParameter("selected");
		
//		System.out.println(id);
//		System.out.println(type);
//		System.out.println(length);
//		System.out.println(time);
//		System.out.println("-------------------");
		
		DbsService dbs = new DbsService();
		if(type.equals("group")) {
			dbs.addLesson(time, Integer.parseInt(length), id, 0);
		}
		else {
			dbs.addLesson(time, Integer.parseInt(length), 0, id);
		}
		
		dbs.close();
		response.sendRedirect("LessonsList");
	}

}
