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
		List<Student> entries = dbs.getStudents();
		ArrayList<String> group;
		
		request.setAttribute("lessons", lessons);
		
		dbs.close();
		request.getRequestDispatcher("/WEB-INF/LessonsList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
