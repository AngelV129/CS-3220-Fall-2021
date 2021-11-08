package lab8Controller;

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

		
		config.getServletContext().setAttribute("map", map);
	
	}

	public ServletConfig getServletConfig() {

		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int array_size = 5;
		Map<String, ArrayList<String>> map =(Map<String, ArrayList<String>>)  request.getServletContext().getAttribute("map");
		
		request.getRequestDispatcher("/WEB-INF/GroupList.jsp").forward(request, response);
        
      
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}