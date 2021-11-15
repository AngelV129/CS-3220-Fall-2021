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

import HW3Service.DbsService;

/**
 * Servlet implementation class GroupList
 */
@WebServlet(urlPatterns="/GroupList", loadOnStartup=2)
public class GroupList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GroupList() {
        super();
    }

	
    
	public ServletConfig getServletConfig() {

		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("sdfsdafsdfawf");
		
		DbsService dbService = new DbsService();
		Map<String, List<String>> map = dbService.getGroup();
		dbService.close();
		request.setAttribute("map", map);
		request.getRequestDispatcher("/WEB-INF/GroupList.jsp").forward(request, response);
        
      
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}