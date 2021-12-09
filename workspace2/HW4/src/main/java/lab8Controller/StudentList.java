package lab8Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW3Service.DbsService;
import lab8Model.Student;

/**
 * Servlet implementation class StudentLIst
 */
@WebServlet(urlPatterns="/StudentLIst", loadOnStartup=3)
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentList() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbsService dbService = new DbsService();
		List<Student> entries = dbService.getStudents();
		Map<String, List<String>> map = dbService.getGroup();
		dbService.close();
		
		request.setAttribute("entries", entries);
		request.setAttribute("map", map);
		request.getRequestDispatcher("/WEB-INF/StudentList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
