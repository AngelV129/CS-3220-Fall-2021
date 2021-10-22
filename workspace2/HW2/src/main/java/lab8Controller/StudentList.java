package lab8Controller;

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


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<Student> entries = new ArrayList<Student>();
		

		// settting in application scope
		config.getServletContext().setAttribute("entries", entries);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> entries = (List<Student>) request.getServletContext().getAttribute("entries");
		request.getRequestDispatcher("/WEB-INF/StudentList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
