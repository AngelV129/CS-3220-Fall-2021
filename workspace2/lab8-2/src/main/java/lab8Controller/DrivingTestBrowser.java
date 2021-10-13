package lab8Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab8Model.Question;

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
		
		// Create list of Queation
		List <Question> questions = new ArrayList();
		
		// strng of file directoery
		String fileName = "/WEB-INF/DivingTest.txt"; // Ignore this
		ServletContext context = getServletContext();
//		System.out.println("Working Directory = " + System.getProperty("user.dir")); // this helped me find what was my working direcoty
		
		// open and read file for servlet
		File file = new File(getServletContext().getRealPath("/WEB-INF/DrivingTest.txt"));
		Scanner in;
		try {
			in = new Scanner(file);
			int counter = 1;
			// create Question object
			Question current_Question = new Question();
			// loop that gets every five lines to match corsponding member in question object
			 while( in.hasNextLine()) {
				 	String line = in.nextLine();
				 	// Skip blank line
				 	if(line.length() == 0) continue;
				 	// reset counter
				 	if (counter>=6) { 
				 		counter = 1;
				 	}
				 	if (counter == 1) {
				 		current_Question.setDescription(line);
				 		counter++;
				 	}
				 	else if(counter == 2) {
				 		current_Question.setAnswerA(line);
				 		counter++;
				 	}
				 	else if(counter == 3) {
				 		current_Question.setAnswerB(line);
				 		counter++;
				 	}
				 	else if(counter == 4) {
				 		current_Question.setAnswerC(line);
				 		counter++;
				 	}
				 	else if(counter == 5) {
				 		current_Question.setCorrectAnswer(Integer.parseInt(line));
				 		// add filled object to list
				 		questions.add(current_Question);
				 		// create new object for next questions
				 		current_Question = new Question();
				 		counter++;
				 	}
		        }
		        in.close();
		        
//		        for(Question q : questions) {
//		        	System.out.println(q.toString());
//		        }
//		        
		        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().setAttribute("Questions", questions);
		
		
       
		
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

		HttpSession session = request.getSession();
		int index =  (int) session.getAttribute("index");
		List<Question> ls = (List<Question>) request.getServletContext().getAttribute("Questions");

		// check if index is at the last index
		// if yes, set to zero
		if (index >= ls.size()) {
			
			index = 1;
		}
		
		// else increment
		else {
			
			index++;
		}

		session.setAttribute("index", index);
	
	
	request.getRequestDispatcher("/WEB-INF/displayQuestion.jsp").forward(request, response);
	}
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		doGet(request, response);
	}

}
