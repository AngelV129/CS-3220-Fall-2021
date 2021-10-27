package midController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midtermcs3220Model.GameScore;
import midtermcs3220Model.Team;


@WebServlet("/AddGameScore")
public class AddGameScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddGameScore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/AddGameScore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GameScore> games = (List<GameScore>) getServletContext().getAttribute("games");
		List<Team> teams = (List<Team>) getServletContext().getAttribute("teams");
		int id = Integer.parseInt( request.getParameter("leftid") );
		int id2 = Integer.parseInt( request.getParameter("rightid") );
		
		int leftScore= Integer.parseInt(request.getParameter("leftscore"));
		int rightScore= Integer.parseInt(request.getParameter("rightscore"));
		
		GameScore game = new GameScore();
		
		// store the game
		game.setLeftID(id);
		game.setLeftID(id2);
		
		game.setLeftScore(leftScore);
		game.setLeftScore(rightScore);
		
		// Update wins and losses
		
		
		// find both teams
		Team team1 = null;
		Team team2 = null;
		// left team
		for(Team team: teams) {
			if(team.getId() == id) {
				team1 = team;
				break;
			}
		}
		//right team
		for(Team team: teams) {
			if(team.getId() == id2) {
				team2 = team;
				break;
			}
		}
		
		// find winner and loser
		
		if(leftScore > rightScore) {
			team1.addWin();
			team2.addLoss();
		}
		else {
			team1.addLoss();
			team2.addWin();
		}
		
		// add team names to game
		game.setLeftTeam(team1.getName());
		game.setRightTeam(team2.getName());
		games.add(game);
		
		
		response.sendRedirect("ListTeams");
	}

}
