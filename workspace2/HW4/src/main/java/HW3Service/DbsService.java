package HW3Service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lab8Model.Group;
import lab8Model.Lesson;
import lab8Model.Student;


public class DbsService {
	
	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu32";

    private String username = "cs3220stu32";

    private String password = "Ni7aU0hs82Eb";

    private Connection connection;
	
	public DbsService()
    {
        try
        {
            connection = DriverManager.getConnection( url, username, password );
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        if( connection != null )
        {
            try
            {
                connection.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }
    
    // return map of students with each groups members.
    public Map<String, List<String>> getGroup(){
    	
    	Map<String, List<String>> map = new TreeMap<>();
    	// Fill the map with its key (group name).
    	try
        {
    		String sql = "SELECT student_groups.name FROM student_groups";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() )
            {
            	// Plsce members is corresponding group
            	// using an arraylist
            	List<String> studentsInGroupList = getStudentGroupList(rs.getString(1));
                map.put(rs.getString(1), studentsInGroupList);
            }
            pstmt.close();
            
            
         
            
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
    	// Plsce members is corresponding group
    	// using an arraylist
    	
		return map;
    	
    }
    
 // return map of students with each groups members.
    public Map<String, ArrayList<String>> getGroup1(){
    	
    	Map<String, ArrayList<String>> map = new TreeMap<>();
    	// Fill the map with its key (group name).
    	try
        {
    		String sql = "SELECT student_groups.name FROM student_groups";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() )
            {
            	// Plsce members is corresponding group
            	// using an arraylist
            	ArrayList<String> studentsInGroupList = getStudentGroupList(rs.getString(1));
                map.put(rs.getString(1), studentsInGroupList);
            }
            pstmt.close();
            
            
         
            
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
    	// Plsce members is corresponding group
    	// using an arraylist
    	
		return map;
    	
    }
    
    // returns an arraylist of students belonging to a specific group.
    public ArrayList<String> getStudentGroupList(String targetGroup){
    	
    	List<String> studentsInGroupList = new ArrayList<String>();
    	try
        {
    		String sql = "SELECT students.name as student_name FROM students INNER JOIN student_groups\r\n"
    				+ "    on students.group_id = student_groups.id\r\n"
    				+ "    WHERE student_groups.name = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setString(1, targetGroup);
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() )
            {
//            	System.out.println("adding " + rs.getString("student_name"));
            	// Plsce members is corresponding group
            	// using an arraylist
            	studentsInGroupList.add(rs.getString("student_name"));
            }
            pstmt.close();
            
            
         
            
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
		return (ArrayList<String>) studentsInGroupList;
		}
    
    // Returns all the students in the database as Student Objects in an array.
    public ArrayList<Student> getStudents(){
    	
    	List<Student> students = new ArrayList<>();
    	// Student information
    	int id = 0;
    	String name;
    	int birth;
    	String parent;
    	String email;
    	
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "SELECT id, name, birth_year, parent_name, parent_email FROM students";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() )
            {
            	id = rs.getInt(1);
            	name = rs.getString(2);
            	birth = rs.getInt(3);
            	parent = rs.getString(4);
            	email = rs.getString(5);
            	
            	Student student = new Student(name, parent, email, 2021 - birth);
            	student.setId(id);
            	students.add(student);
            }
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
    	
		return (ArrayList<Student>) students;
    	
    }
    
    public int addGroup(String groupName) {
    	int id = 0;
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "INSERT INTO student_groups (name) values (?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, groupName);
         
            pstmt.executeUpdate();
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	return id;
    }
    
    public void addStudent(String name, int birthYear, String parentName, String parentEmail, String groupName) {
    	
    	// if groupName is empty enter group_id as null in student table
    	// else find group id and insert with new student. ""
    	int id = 0;
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "\r\n"
    				+ "INSERT INTO students VALUES (NULL,?, ?, ?, ?,?);";
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, name);
            pstmt.setInt(2, birthYear);
            pstmt.setString(3, parentName);
            pstmt.setString(4, parentEmail);
            
            
            // insert null into the group_id column
            if(groupName == "") {
            	pstmt.setNull(5, Types.NULL);
            }
            else {
            	pstmt.setInt(5, getGroupId(groupName) );
            }
         
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if(rs.next()) id = rs.getInt(1);
            
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
    }
    
    // returns the id of group with target name from the student_group table.
    public int getGroupId(String targetGroupName) {
    	int id = 0;
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "SELECT id FROM student_groups WHERE name = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, targetGroupName);
         
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	id = rs.getInt(1);
            }
            pstmt.close();  
            
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
		return id;
    	
    }
    
    // Return a student object given a specific student id.
    public Student getStudent(int id) {
    	Student targetStudent = new Student();
    	int age;
    	String name;
    	String parent_name;
    	String eMail;
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
         
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	name = rs.getString("name");
            	age = 2021 - rs.getInt("birth_year");
            	parent_name = rs.getString("parent_name");
            	eMail = rs.getString("parent_email");
            	
            	targetStudent.setId(id);
            	targetStudent.setM_age(age);
            	targetStudent.setM_eMail(eMail);
            	targetStudent.setM_name(name);
            	targetStudent.setM_parent_name(parent_name);
            	
            }
            pstmt.close();  
            
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
		return targetStudent;
    	
    }
    
    
    public void updateStudent(String name, int birthYear, String parentName, String parentEmail, String groupName, int targetAtudentId) {
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "UPDATE students\r\n"
    				+ "SET \r\n"
    				+ "    name = ?,\r\n"
    				+ "    birth_year = ?,\r\n"
    				+ "    parent_name = ?,\r\n"
    				+ "    parent_email = ?,\r\n"
    				+ "    group_id = ? \r\n"
    				+ "WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, name);
            pstmt.setInt(2, birthYear);
            pstmt.setString(3, parentName);
            pstmt.setString(4, parentEmail);
            
            
            // insert null into the group_id column
            if(groupName == "") {
            	pstmt.setNull(5, Types.NULL);
            }
            else {
            	pstmt.setInt(5, getGroupId(groupName) );
            }
            pstmt.setInt(6, targetAtudentId);
         
            pstmt.executeUpdate();
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    // Names are unique is group database so using name will we sufficiant.
    public void updateGroupName(String newName, String oldName) {
    	
    	
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "UPDATE student_groups\r\n"
    				+ "SET \r\n"
    				+ "    name = ? \r\n"
    				+ "WHERE name = ? ";
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, newName);
            pstmt.setString(2, oldName);
                    
            pstmt.executeUpdate();
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void removeStudentFromGroup(String studentName) {
    	
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "UPDATE students SET group_id = NULL WHERE name = ?"; // LIMIT 1
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, studentName);

                    
            pstmt.executeUpdate();
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
    }
    
    public String getGroupName(int id) {
    	String groupName = null;
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "SELECT name FROM student_groups WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
         
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	groupName = rs.getString(1);
            }
            pstmt.close();  
            
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
		return groupName;
    	
    }
    
    public ArrayList<Lesson> getLessons(){
    	
    	int id;
    	Date date;
    	int length;
    	int groupID;
    	int studentID;
    	Timestamp s;
    	
    	ArrayList<Lesson> lessons = new ArrayList<>();
    	
    	try
        {
    		String sql = "SELECT * FROM lessons ORDER BY times DESC"; // LIMIT 1
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	id = rs.getInt("id");
            	date = rs.getTimestamp("times");
            	length = rs.getInt("length");
            	groupID = rs.getInt("students_group_id");
            	studentID = rs.getInt("student_id");
            	
            	Lesson lesson = new Lesson(id, date, length, groupID, studentID);
            	
            	if(studentID != 0) {
            		Student currStudent = this.getStudent(studentID);
            		lesson.setStudentName(currStudent.getM_name());
            	}
            	else {
            		String currGroup = this.getGroupName(groupID);
            		lesson.setGroupName(currGroup);
            	}
            	
            	
            	
            	lessons.add(lesson);
            }
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
    	return lessons;
    }
    
    // TODO: create method that get a list of groups in database.
    public ArrayList<Group> getGroups() {
    	ArrayList<Group> groups = new ArrayList<>();
    	
    	int id = 0;
    	String name=null;
    	
    	try
        {
    		String sql = "SELECT id, name FROM student_groups"; // LIMIT 1
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	id = rs.getInt("id");
            	name = rs.getString("name");
            	
            	Group lesson = new Group(id, name);
            	groups.add(lesson);
            }
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
		return groups;
    	
    }
    
    public void addLesson(String time, int length, int students_group_id, int student_id) {
    	
    	int id = 0;
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "INSERT into lessons VALUES (NULL, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, time);
            pstmt.setInt(2, length);
            pstmt.setInt(3, students_group_id );
            pstmt.setInt(4, student_id);
         
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if(rs.next()) id = rs.getInt(1);
            
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

}

	