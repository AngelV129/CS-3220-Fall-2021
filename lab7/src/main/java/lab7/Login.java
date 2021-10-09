package lab7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
    
    }

	
	public void init(ServletConfig config) throws ServletException {
	
	}
	
	private String getUserName(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user")) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	private String getPassword(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("password")) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Login</title></head><body>" );
        
        out.println("<form method='post'>");
        
        // Username
        out.println("<label for='uName'>Username: </label>");
        out.println("<input type='text' id='uName' name='uName' required><br>");
        
        // password 
        out.println("<label for='password'>Password: </label>");
        out.println("<input type='password' id='password' name='password' required><br>");
        out.println("<button> Login </button>");
        
        // end of body
        out.println( "</body></html>" );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String uname = (String) request.getSession().getAttribute("uName");
//		String password = (String) request.getSession().getAttribute("password");
		
		String paramName = (String) request.getParameter("uName");
		String paramPassword = request.getParameter("password");
		
		// check if username and password match 'cysun' and 'abcd'.
		// if match then set session attribut 'user' and redirect to members Servlet.
		if(paramName.equals("cysun") && paramPassword.equals("abcd")) {
			
			request.getSession().setAttribute("user", paramName);
			response.sendRedirect("Members");
		}
		else {
			// else redirect to login page.
			response.sendRedirect("Login");
			
		}
		
		
		// else redirect to login page.
	}

}
