package CS3220.HW1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GroupList
 */
@WebServlet("/GroupList")
public class GroupList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GroupList() {
        super();


    }

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	
	}

	public ServletConfig getServletConfig() {

		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>AdditionPractice</title></head><body>" );
        
        // Link to new to new group.
        out.println("<div><a href=''></a>New Student</div>");
        
        // Creating a table
        out.println("<table border=1>");
        //open table head
        out.println("<thead> <tr>");
        // fill table thead
        out.println("<th><b>Group</b></th>");
        out.println("<th><b>Members</b></th>");
        
        // Close table head
        out.println("</tr> </thead>");
        // Fill table body
        out.println("<tbody>");
        
        // fills rows and cols
        
        
        // end of table body
        out.println("</tbody>");
        
        // end of body
        out.println( "</body></html>" );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
