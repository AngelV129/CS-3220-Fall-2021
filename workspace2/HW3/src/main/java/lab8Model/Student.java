package lab8Model;

public class Student {
	
	private static int numStudents = 0;
	private int id;
	private int m_age;
	private String m_name;
	private String m_parent_name;
	private String m_eMail;
	
	
	public Student(String name, String pName,String email , int age){
		this.m_name = name;
		this.m_parent_name = pName;
		this.m_eMail = email;
		this.m_age = age;  
		this.id = ++numStudents;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getM_age() {
		return m_age;
	}
	public void setM_age(int m_age) {
		this.m_age = m_age;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_parent_name() {
		return m_parent_name;
	}
	public String getM_eMail() {
		return m_eMail;
	}

	public void setM_eMail(String m_eMail) {
		this.m_eMail = m_eMail;
	}

	public void setM_parent_name(String m_parent_name) {
		this.m_parent_name = m_parent_name;
	}
	
	

}
