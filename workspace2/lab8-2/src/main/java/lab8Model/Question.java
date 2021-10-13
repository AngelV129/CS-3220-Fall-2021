package lab8Model;

public class Question {
	private String description;
	private String answerA;
	private String answerB;
	private String answerC;
	int correctAnswer;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAnswerA() {
		return answerA;
	}
	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}
	public String getAnswerB() {
		return answerB;
	}
	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}
	public String getAnswerC() {
		return answerC;
	}
	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	// This to string is meant to work for jsp file.
	public String toString()
    {
        return description + "<br>1. " + answerA + "<br>2. " + answerB + "<br>3. "
            + answerC + "<br>Correct Answer: " + correctAnswer;
    }

}
