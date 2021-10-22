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

import lab8Model.Student;

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditStudent() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get the list of students
		List<Student> entries = (List<Student>) request.getServletContext().getAttribute("entries");
		// grab id of selected student to be edited
		int currentId = Integer.parseInt(request.getParameter("id"));
		//find matching student object with same id
		Student currentStudent = null;
		for(Student stu : entries) {
			if(stu.getId() == currentId) {
				currentStudent = stu;
				break;
			}
		}
		// get map object from application
		Map<String, ArrayList<String>> map =(Map<String, ArrayList<String>>)  request.getServletContext().getAttribute("map");
		
		// find if student belongs to a groups
		String currentGroup = getStudentGroup(currentStudent.getM_name(), map);
		// send Student object and his/her group name to jsp
		request.setAttribute("currentstudent", currentStudent);
		request.setAttribute("currentGroup", currentGroup);
		
		request.getRequestDispatcher("/WEB-INF/EditStudent.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	String getStudentGroup(String name, Map<String, ArrayList<String>> map) {
		
		for(Entry<String, ArrayList<String>> entry: map.entrySet()) {
			if(entry.getValue().contains(name)) {
				return entry.getKey();
			}
		}
		
		
		return "";
		
	}

}
