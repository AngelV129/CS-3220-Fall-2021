package HW3Service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
            	System.out.println("adding " + rs.getString("student_name"));
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
    
    public List<Student> getStudents(){}

}

	