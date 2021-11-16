package lab8Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW3Service.DbsService;
import lab8Model.Student;

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditStudent() {
        super();

    }

    // This servlet is only called on existing students.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbsService dbService = new DbsService();

		// grab id of selected student to be edited
		int currentId = Integer.parseInt(request.getParameter("id"));
		// set the current id of student being edited to the scope
		request.setAttribute("currentEditId", currentId);

		//find matching student object with same id
		Student currentStudent = dbService.getStudent(currentId);
		// get map object from application
		Map<String, ArrayList<String>> map = dbService.getGroup1();
		
		// find if student belongs to a groups
		String currentGroup = getStudentGroup(currentStudent.getM_name(), map);

		// send Student object and his/her group name to jsp
		// Current Student will only be used for the edit student.
		request.setAttribute("currentstudent", currentStudent);
		request.setAttribute("currentGroup", currentGroup);
		request.setAttribute("map", map);
		dbService.close();
		request.getRequestDispatcher("/WEB-INF/EditStudent.jsp").forward(request, response);

	}

	// Will need to update student information on the table.
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbsService dbService = new DbsService();
		String student_name = request.getParameter("student-name");
		String parent_name = request.getParameter("student-parent");
		String parent_email = request.getParameter("student-pEmail");
		int birth_year = Integer.parseInt(request.getParameter("student-birth"));
		String group = request.getParameter("group");
		int currentId = Integer.parseInt(request.getParameter("id"));
		
		dbService.updateStudent(student_name, birth_year, parent_name, parent_email, group, currentId);
		
		dbService.close();
		response.sendRedirect("StudentLIst");
			
	}
	
	// get the group the student belongs too useing their name
	private   String getStudentGroup(String name, Map<String, ArrayList<String>> map) {
		
		for(Entry<String, ArrayList<String>> entry: map.entrySet()) {
			if(entry.getValue().contains(name)) {
				return entry.getKey();
			}
		}	
		return "";
		
	}
	
	// convert given birth date to age by (cuurent year - birth date).
		private String birthToAge(String birthDate){
			int newDate = Integer.parseInt(birthDate);
			
			return Integer.toString((2021 - newDate));
			}

}
