package CS3220.HW1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw1.model.Student;

/**
 * Servlet implementation class StudentLIst
 */
@WebServlet(urlPatterns="/StudentLIst", loadOnStartup=3)
public class StudentLIst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentLIst() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		List<Student> entries = new ArrayList<Student>();
		
//		Student test = new Student("angel","mom","ass.com",26);
//		entries.add(test);
		// settting in application scope
		config.getServletContext().setAttribute("entries", entries);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> entries = (List<Student>) request.getServletContext().getAttribute("entries");
		
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Student List</title></head><body>" );
        
        out.println("<div><a href='./AddStudent'>New Student</a></div> <br>");
        // Creating a table
        out.println("<table border=1>");
        //open table head
        out.println("<thead> <tr>");
        // fill table thead
        out.println("<th><b>Name</b></th>");
        out.println("<th><b>Age</b></th>");
        out.println("<th><b>Parent</b></th>");
        out.println("<th><b>Email</b></th>");
        
        // Close table head
        out.println("</tr> </thead>");
        // Fill table body
        out.println("<tbody>");
        
        // fills rows and cols
        for (Student entry: entries) {
        	out.println("<tr>");
        	out.println("<td>" + entry.getM_name() + "</td>");
        	out.println("<td>" + entry.getM_age() + "</td>");
        	out.println("<td>" + entry.getM_parent_name() + "</td>");
        	out.println("<td>" + entry.getM_eMail() + "</td>");
        	out.println("</tr>");
        }
       
        // end of table body
        out.println("</tbody>");
        
        out.println( "</body></html>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
