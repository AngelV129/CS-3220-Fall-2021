package CS3220.HW1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GroupList
 */
@WebServlet(urlPatterns="/GroupList", loadOnStartup=2)
public class GroupList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GroupList() {
        super();


    }

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Map<String, List<String>> map = new TreeMap<>(); 
//		List<String> tmpList = new ArrayList<String>();
//		tmpList.add("Angel");
//		tmpList.add("james");
//		tmpList.add("james");
//		tmpList.add("james");
//		tmpList.add("james");
//		map.put("MEN", tmpList);
//		tmpList = new ArrayList<String>();
//		tmpList.add("WHo");
//		map.put("yes", tmpList);
		
		config.getServletContext().setAttribute("map", map);
	
	}

	public ServletConfig getServletConfig() {

		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int array_size = 5;
		Map<String, ArrayList<String>> map =(Map<String, ArrayList<String>>)  request.getServletContext().getAttribute("map");
		
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Group List</title></head><body>" );
        
        // Link to new to new group.
        out.println("<div><a href='./AddGroup'>New Group</a></div> <br>");
        
        // Creating a table
        out.println("<table border=1>");
        //open table head
        out.println("<thead> <tr>");
        // fill table thead
        out.println("<th><b>Group</b></th>");
        out.println("<th><b>Members</b></th>");
        
        // Close table head
        out.println("</tr> </thead>");
        
        // fill the table with current group information.
        out.println("<tbody>");
        // get itertator of map set.
        Iterator<Map.Entry<String, ArrayList<String>>> itr = map.entrySet().iterator();
        
        // loop for each row
        while(itr.hasNext()) {
        	out.println("<tr>");
        	Map.Entry<String, ArrayList<String>> entry = itr.next();
        	out.println("<td>" + entry.getKey() + "</td>");
        	// get all names associated with group name
        	List<String> names = entry.getValue();
        	out.println("<td>");
        	for(int i = 0; i < names.size(); i++) {
        		out.println(names.get(i) + " ");
        	}
        	out.println("</td>");
        	out.println("</tr>");
        }
        
        // close tabble body
        out.println("</tbody>");
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
