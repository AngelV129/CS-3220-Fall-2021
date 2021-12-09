package lab8Model;

import java.util.Date;

public class Lesson {
	private int id;
	private Date date;
	private int length;
	private int groupID;
	private int studentID;
	
	private String studentName = null;
	private String groupName = null;
	
	public Lesson(int id, Date date, int length, int groupID, int studentID) {
		this.id = id;
		this.date = date;
		this.length = length;
		this.groupID  = groupID;
		this.studentID = studentID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	

}
