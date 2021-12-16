package FinalService;

import java.util.ArrayList;

public class Attendance {
	
	public int id;
	public String studentName;
	public ArrayList<String> didAttendList = new ArrayList<>();
	
	public Attendance() {
		
	}
	public Attendance(int id,String name, ArrayList<String> list) {
		this.id  =id;
		this.studentName = name;
		this.didAttendList = list;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public ArrayList<String> getDidAttendList() {
		return didAttendList;
	}
	public void setDidAttendList(ArrayList<String> didAttendList) {
		this.didAttendList = didAttendList;
	}
	
	

}
