package lab8Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DrivingTestBrowser
 */
@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DrivingTestBrowser() {
        super();

    }

	
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		String fileName = "./WEB-INF/DivingTest.txt"; // Ignore this
		ServletContext context = getServletContext();
		System.out.println("Working Directory = " + System.getProperty("user.dir")); // this helped me find what was my working direcoty
		System.out.println("EAT ASS");System.out.println("EAT ASS");
		
		File file = new File(getServletContext().getRealPath("/WEB-INF/DrivingTest.txt"));
		Scanner in;
		try {
			in = new Scanner(file);
			 while( in.hasNextLine()) {
		            System.out.println(in.nextLine());
		        }
		        in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		System.out.println("EAT ASS");
		
//		// First get the file InputStream using ServletContext.getResourceAsStream()
//        // method.
//        InputStream is = context.getResourceAsStream(fileName);
//        System.out.print(is);
//        if (is != null) {
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader reader = new BufferedReader(isr);
//            String text;
//
//            // We read the file line by line and later will be displayed on the
//            // browser page.
//            System.out.println("EAT ASS");
//            try {
//				while ((text = reader.readLine()) != null) {
//				    System.out.println(text);
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        }
	
	}
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		doGet(request, response);
	}

}
