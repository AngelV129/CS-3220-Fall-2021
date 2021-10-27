package midtermcs3220Model;

public class GameScore {
	int leftID;
	int rightID;
	
	int leftScore;
	int rightScore;
	
	String leftTeam;
	String rightTeam;
	
	public String getLeftTeam() {
		return leftTeam;
	}

	public void setLeftTeam(String leftTeam) {
		this.leftTeam = leftTeam;
	}

	public String getRightTeam() {
		return rightTeam;
	}

	public void setRightTeam(String rightTeam) {
		this.rightTeam = rightTeam;
	}

	public GameScore() {
		
	}
	
	public int getLeftID() {
		return leftID;
	}
	public void setLeftID(int leftID) {
		this.leftID = leftID;
	}
	public int getRightID() {
		return rightID;
	}
	public void setRightID(int rightID) {
		this.rightID = rightID;
	}
	public int getLeftScore() {
		return leftScore;
	}
	public void setLeftScore(int leftScore) {
		this.leftScore = leftScore;
	}
	public int getRightScore() {
		return rightScore;
	}
	public void setRightScore(int rightScore) {
		this.rightScore = rightScore;
	}
	
	

}
