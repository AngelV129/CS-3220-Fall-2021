package lab8Model;

import java.util.ArrayList;
import java.util.List;

public class Group {
	
	private static int numGroups = 0;
	private int id;
	private String name;
	private List<Student> groupMembers = new ArrayList<>();
	
	public Group(int id, String name){
		this.name = name;
		this.id= id;
		
	}

	public static int getNumGroups() {
		return numGroups;
	}

	public static void setNumGroups(int numGroups) {
		Group.numGroups = numGroups;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(List<Student> groupMembers) {
		this.groupMembers = groupMembers;
	}
	
	public void addMember(Student stu) {
		groupMembers.add(stu);
	}

}
