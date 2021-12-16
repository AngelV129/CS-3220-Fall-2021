package FinalService;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



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
    
    
    public ArrayList<Event> getEvents(){
    	
    	List<Event> events = new ArrayList<>();
    	// Student information
    	int id = 0;
    	String name;
    	int birth;
    	String parent;
    	String email;
    	
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "SELECT id, name FROM events";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() )
            {
            	id = rs.getInt(1);
            	name = rs.getString(2);
            	
            	Event student = new Event(id,name);
            	student.setId(id);
            	events.add(student);
            }
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
    	
		return (ArrayList<Event>) events;
    	
    }
    
    
public ArrayList<Attendance> getAttend(){
    	
	    ArrayList<Attendance> events = new ArrayList<>();
    	// Student information
    	int id = 0;
    	String name;
    	int birth;
    	String parent;
    	
    	
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "SELECT id, name, attend FROM attendance_event";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() )
            {
            	ArrayList<String> attend = new ArrayList<>();
            	id = rs.getInt(1);
            	name = rs.getString(2);
            	List<String> names =  Arrays.asList(rs.getString(3).split(","));
            	for(String text:names) {
                    attend.add(text);
                 }
            	
            	Attendance student = new Attendance(id,name, attend);
            	events.add(student);
            	
            	
            	
            }
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
    	
		return (ArrayList<Attendance>) events;
    	
    }
    
}
