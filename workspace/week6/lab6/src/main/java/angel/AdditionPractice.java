package angel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionPractice
 */
@WebServlet(urlPatterns= "/AdditionPractice")
public class AdditionPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionPractice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random rand = new Random();
		int num1 = rand.nextInt((9 - 1) + 1) + 1;
		int num2 = rand.nextInt((9 - 1) + 1) + 1;

		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>AdditionPractice</title></head><body>" );
        
        out.println("<form action:AdditionPractice method='post'>");
        out.println("<input type='hidden' name='num1' value='"+num1+"'>" );
        out.println("<input type='hidden' name='num2' value='" + num2 + "'>" );
        
        out.println(num1 + " + " + num2 + " = <input type='text' name='sum'>");
        out.println("<input type=\"submit\" value='Submit'>");
        out.println("</form>");
        
        out.println( "</body></html>" );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		
		String usrSum = request.getParameter("sum");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int i_usrSum = Integer.parseInt(usrSum);
		int y = Integer.parseInt(num1);
		int x = Integer.parseInt(num2);
		int correctSum = x + y;
//		int num2 = Integer.parseInt(request.getParameter("num2"));
		out.println( "<html><head><title>AdditionPractice</title></head><body>" );
		
		out.println(y + " + " + x + " = " + correctSum);
		out.println("<br>");
		
		String valid;
		
		if(i_usrSum == correctSum)
			valid = "correct";
		else valid = "Incorrect";
		
		out.println("Your answer " + usrSum + " is " + valid);
		out.println("<p><a href='AdditionPractice'>Try Again</a></p>");
		
		out.println( "</body></html>" );
	
	}

}
