package lab8Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW3Service.DbsService;
import lab8Model.Student;



@WebServlet(urlPatterns="/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddStudent() {
        super();
       
    }


	public void init(ServletConfig config) throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbsService dbService = new DbsService();
		Map<String, List<String>> map = dbService.getGroup();
		request.setAttribute("map", map);

        request.getRequestDispatcher("/WEB-INF/AddStudent.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String student_name = request.getParameter("student-name");
		String parent_name = request.getParameter("student-parent");
		String parent_email = request.getParameter("student-pEmail");
		String birthYear = request.getParameter("student-birth");
		String student_age = birthToAge(request.getParameter("student-birth"));
		int age = Integer.parseInt(birthYear);
		String group = request.getParameter("group"); 
		
		DbsService dbService = new DbsService();
		dbService.addStudent(student_name, age, parent_name, parent_email, group);
		dbService.close();
		
//		Map<String, ArrayList<String>> map =(Map<String, ArrayList<String>>)  request.getServletContext().getAttribute("map");
//		List<Student> entries = (List<Student>) request.getServletContext().getAttribute("entries");
//
//		
//		// Add new student to arralist of students
//		Student newStudent = new Student(student_name,parent_name,parent_email,age);
//		entries.add(newStudent);
//		
////		System.out.println("Insude of AddStudent group is "+group);
//		
//		// Add to student to a group
//		// if value for student is empty then skip this step
//		//  FIXME: this is not supposed to try add group of "N/A" but keeps trying.
//		if(group != "" && (!map.isEmpty())) {
//			map.get(group).add(student_name);
//		}
		
		
		response.sendRedirect("StudentLIst");
	}
	
	// convert given birth date to age by (cuurent year - birth date).
	private String birthToAge(String birthDate){
		int newDate = Integer.parseInt(birthDate);
		
		return Integer.toString((2021 - newDate));
		}

}
