package CS3220.HW1;

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

import hw1.model.Student;


@WebServlet(urlPatterns="/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddStudent() {
        super();
       
    }


	public void init(ServletConfig config) throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, ArrayList<String>> map =(Map<String, ArrayList<String>>)  request.getServletContext().getAttribute("map");
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Add Student</title></head><body>" );
        //create form.
        out.println("<form action='AddStudent' method='post'> ");
        //Add table inside of form
        out.println("<table border=1>");
        // name row
        out.println("<tr>");
        out.println("<td><span style=text-align: center; font-weight: bold>Name</span></td>");
        out.println("<td><input type='text' name='student-name'size='25'>");
        out.println("</tr>");
        
        // year row
        out.println("<tr>");
        out.println("<td><span style=text-align: center; font-weight: bold>Birth Year</span></td>");
        out.println("<td><input type='text' name='student-birth'size='25'>");
        out.println("</tr>");
        
        // parent name.
        out.println("<tr>");
        out.println("<td><span style=text-align: center; font-weight: bold>Parent Name</span></td>");
        out.println("<td><input type='text' name='student-parent'size='25'>");
        out.println("</tr>");
        
        // parent email
        out.println("<tr>");
        out.println("<td><span style=text-align: center; font-weight: bold>Parent Email</span></td>");
        out.println("<td><input type='text' name='student-pEmail'size='25'>");
        out.println("</tr>");
        
        // group row
        out.println("<tr>");
        out.println("<td><span style=text-align: center; font-weight: bold>Group</span></td>");
        out.println("<td><select name='group' width=2em style='width: 50px;'>");
        out.println("<option value='N/A'></option>");
        Iterator<Map.Entry<String, ArrayList<String>>> itr = map.entrySet().iterator();
        while(itr.hasNext()) {
        	Map.Entry<String, ArrayList<String>> entry = itr.next();
        	// move to next group if size of 5.
        	if(entry.getValue().size() == 5) continue;
        	out.println("<option value='" + entry.getKey()+ "'>"+ entry.getKey() +"</option>");
        }
        out.println("</select>");
        out.println("</td>");
        // groups added from map.
        out.println("</tr>");
        
        // add button
        out.println("<tr> <td colspan=\"2\"> <button> Add </button> </td> </tr>");
        
//        out.println("</tr>");
        out.println( "</body></html>" );

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
		// Add new student to arralist of students
		Student newStudent = new Student(student_name,parent_name,parent_email,age);
		entries.add(newStudent);
		
		// Add to student to a group
		// if value for student is empty then skip this step
		
		if(group != "N/A" && (!map.isEmpty())) {
			map.get(group).add(student_name);
		}
		
		
		response.sendRedirect("StudentLIst");
	}
	
	// convert given birth date to age by (cuurent year - birth date).
	public String birthToAge(String birthDate){
		int newDate = Integer.parseInt(birthDate);
		
		return Integer.toString((2021 - newDate));}

}
