package lab7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Members() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Members</title></head><body>" );
        
        String  user = (String) request.getSession().getAttribute("user");
        
        if(user != null) {
        	out.println("<h2>Welcome to the Members Area</h2><br>");
        
        	out.println("<div><a href='./Logout'>Logout</a></div>");
        }
        else {
        	response.sendRedirect("Members");
        }
       
        
        // end of body
        out.println( "</body></html>" );
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
