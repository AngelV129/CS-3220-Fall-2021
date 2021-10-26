package lab8Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditGroup")
public class EditGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditGroup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String group = request.getParameter("key");
		
		request.setAttribute("currentGroup", group);
		
		request.getRequestDispatcher("/WEB-INF/EditGroup.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// this is only activated when the user presses same in the edit group page
		// Which will only do anything if the user tried to edit a group name.
		String group = request.getParameter("key");
		String oldGroup = request.getParameter("oldKey");
		
		System.out.println("Inside edit group "+ group);
		System.out.println("Inside edit oldgroup "+ oldGroup);
		
		
		// TODO: Check again later if need to modify List of Students
		Map<String, ArrayList<String>> map =(Map<String, ArrayList<String>>)  request.getServletContext().getAttribute("map");
		
		if (group != oldGroup) {
			ArrayList<String> arrayholder = map.get(oldGroup);
			map.remove(oldGroup);
			map.put(group, arrayholder);
			}
		
		response.sendRedirect("GroupList");
	}

}
