package lab8Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomePage
 */
@WebServlet(urlPatterns="/HomePage", loadOnStartup=1)
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomePage() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {

	}

	public ServletConfig getServletConfig() {

		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Sends request the reuest to jasp from doGet
		 request.getRequestDispatcher("/WEB-INF/Index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}