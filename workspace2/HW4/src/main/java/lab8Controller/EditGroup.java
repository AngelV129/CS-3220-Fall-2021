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

@WebServlet("/EditGroup")
public class EditGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditGroup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String group = request.getParameter("key");
		DbsService dbService = new DbsService();

		
		request.setAttribute("currentGroup", group);
		// Will send a map to the editgroupjsp
		Map<String, List<String>> map = dbService.getGroup();
		dbService.close();
		request.setAttribute("map", map);
		
		
		request.getRequestDispatcher("/WEB-INF/EditGroup.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// this is only activated when the user presses save in the edit group page
		// Which will only do anything if the user tried to edit a group name.
		String group = request.getParameter("key");
		String oldGroup = request.getParameter("oldKey");
		
		DbsService dbService = new DbsService();
		dbService.updateGroupName(group, oldGroup);
		dbService.close();
		
		response.sendRedirect("GroupList");
	}

}
