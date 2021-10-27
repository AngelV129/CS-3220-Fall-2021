package cs3220Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practiceMidterm.Poll;

/**
 * Servlet implementation class CreatePoll
 */
@WebServlet("/CreatePoll")
public class CreatePoll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreatePoll() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/CreatePoll.jsp").forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Poll poll = new Poll();
		poll.setQuestion(request.getParameter("question"));
		poll.setSingleChoice(request.getParameter("single") != null);
		
		List<Poll> polls = (List<Poll>) getServletContext().getAttribute("polls");
		polls.add(poll);
		response.sendRedirect("AddAnswers?id="+poll.getId());
	}

}
