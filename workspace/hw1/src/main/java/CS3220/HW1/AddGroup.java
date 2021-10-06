package CS3220.HW1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddGroup
 */
@WebServlet(urlPatterns="/AddGroup")
public class AddGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddGroup() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Add Group</title></head><body>" );
        //create form.
        out.println("<form action='AddGroup' method='post'> ");
        //Add table inside of form
        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<td>" + "<span style=\"font-weight:bold\">Name</span>"+"</td>");
        out.println("<td><input type='text' name='group-name'size='25'>");
        out.println("<tr> <td> <button> Add </button> </td> </tr>");
        out.println("</tr>");
        out.println( "</body></html>" );

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String form_name = request.getParameter("group-name");
		Map<String, ArrayList<String>> map =(Map<String, ArrayList<String>>)  request.getServletContext().getAttribute("map");
		
		map.put(form_name, new ArrayList<String>());
		// add group name to map.
		
		response.sendRedirect("GroupList");
		
	}

}
