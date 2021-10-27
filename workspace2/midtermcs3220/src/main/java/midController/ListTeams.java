package midController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midtermcs3220Model.GameScore;
import midtermcs3220Model.Team;



@WebServlet("/ListTeams")
public class ListTeams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListTeams() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		List<Team> teams = new ArrayList<Team>();
		Team team = new Team();
		
		team.setName("Rams");
		teams.add(team);
		
		List<GameScore> games = new ArrayList<GameScore>();
		// Create a dictionary of teams for each game playes
		
		getServletContext().setAttribute("teams", teams);
		getServletContext().setAttribute("games", games);
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ListTeams.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
