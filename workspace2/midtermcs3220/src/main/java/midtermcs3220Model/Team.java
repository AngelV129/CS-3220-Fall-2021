package midtermcs3220Model;

public class Team {
static int idSeed = 1;
	
	private int id;
	private int wins;
	private int losses;
	private String name;
	
	public Team(){
		id = idSeed++;
		wins=0;
		losses=0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addWin() {
		wins += 1;
	}
	public void addLoss() {
		losses += 1;
	}

}
