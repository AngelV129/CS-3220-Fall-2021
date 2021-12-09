package lab8Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW3Service.DbsService;

@WebServlet("/RemoveGroupMember")
public class RemoveGroupMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveGroupMember() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// This only activates when the user presses the remove link next to a member in the Edit group page.
		String group = request.getParameter("key");
		String target = request.getParameter("targetRemoval");
		DbsService dbService = new DbsService();
		
		request.setAttribute("currentGroup", group);
		
		dbService.removeStudentFromGroup(target);
		
		Map<String, List<String>> map = dbService.getGroup();
		request.setAttribute("map", map);
		dbService.close();
		

		request.getRequestDispatcher("/WEB-INF/EditGroup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
