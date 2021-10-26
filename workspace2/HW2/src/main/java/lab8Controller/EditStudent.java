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
		// set the current id of student being edited to the scope
		request.getServletContext().setAttribute("currentEditId", currentId);

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
		// Current Student will only be used for the edit student.
		request.getSession().setAttribute("currentstudent", currentStudent);
		request.getSession().setAttribute("currentGroup", currentGroup);
		
		request.getRequestDispatcher("/WEB-INF/EditStudent.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String student_name = request.getParameter("student-name");
		String parent_name = request.getParameter("student-parent");
		String parent_email = request.getParameter("student-pEmail");
		String student_age = birthToAge(request.getParameter("student-birth"));
		String group = request.getParameter("group"); 
		
		Map<String, ArrayList<String>> map =(Map<String, ArrayList<String>>)  request.getServletContext().getAttribute("map");
		List<Student> entries = (List<Student>) request.getServletContext().getAttribute("entries");

		int age = Integer.parseInt(student_age);
		// Edit the student Current info
		
		int currentId = (int) request.getServletContext().getAttribute("currentEditId");
		//find matching student object with same id
		Student currentStudent = null;
		for(Student stu : entries) {
			if(stu.getId() == currentId) {
				currentStudent = stu;
				break;
			}
		}
		
		// Remove student from old group
		
		// Add to student to a group
		// if value for student is empty then skip this step
				
		String oldGroup = getStudentGroup(currentStudent.getM_name(), map);
		
		
		// updat all the student onformation
		currentStudent.setM_name(student_name);
		currentStudent.setM_eMail(parent_email);
		currentStudent.setM_parent_name(parent_name);
		currentStudent.setM_age(age);
		
//		System.out.println("Insude of EditStudent group is "+oldGroup);
//		System.out.println("Insude of editStudent group is "+group);
		
	
		//FIXME: this is causing bug of unable to remove a student from group
		// - and vice versa such as adding a student that is not in a group to one.
		// - It keeps always checking map for 'N/A' value when it should never exist.
		// change the students group.
		if ((oldGroup != "") && (group != "" )&& (!map.isEmpty())) {
			// add student to group
			map.get(oldGroup).remove(student_name);
			map.get(group).add(student_name);
			
		}
		
		if ((oldGroup == "") && (group != "" )&& (!map.isEmpty())) {
			// add student to group
			map.get(group).add(student_name);
			
		}
		
		if ((oldGroup != "") && (group == "" )&& (!map.isEmpty())) {
			// add student to group
			map.get(oldGroup).remove(student_name);
			
		}
		
		// TODO: Add a redirect page
		// FIXME: Currently the code crashes when changing a students group.
		response.sendRedirect("StudentLIst");
			
	}
	
	// remove student from their current group
	// update student to their new group.
	String updateGroup() {
		
		
		return null;
	}
	
	private Student getStudent(String name, String pName, String email, String age, List<Student> students) {
		
		for(Student stu: students) {
			if(stu.getM_name() == name) {
				return stu;
			}
		}
		return null;
	}
	
	// Remove student from old group
	private   void removeFromGroup(String name,String oldGroup, Map<String, ArrayList<String>> map) {
		if(map.containsKey(oldGroup)) {
			if(map.get(oldGroup).contains(name)) {
				map.get(oldGroup).remove(name);
			}
			
		}
		
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
