package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import PracticeModel.Reservation;

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
    
    public ArrayList<Reservation> getReservations(){
    	
	    	ArrayList<Reservation> res = new ArrayList<Reservation>();
	    	Reservation re = null;
	    	
	    	int id = 0;
	    	String customerName = null;
	    	String day = null;
	    	String startTime = null;
	    	int endtime;
	    	
	    	try
	        {
	    		String sql = "SELECT * FROM reservations";
	            PreparedStatement pstmt = connection.prepareStatement( sql );
	            
	            ResultSet rs = pstmt.executeQuery();
	            while( rs.next() )
	            {
	//            	System.out.println("adding " + rs.getString("student_name"));
	            	
	            	id = rs.getInt(1);
	            	customerName = rs.getString(2);
	            	day = rs.getString(3);
	            	startTime = rs.getString(4);
	            	re = new Reservation(id, customerName, day, startTime);
	            	
	            	res.add(re);
	            }
	            pstmt.close();
	    }
	    	catch( SQLException e )
	        {
	            e.printStackTrace();
	        }
	    	return res;
    }
    
    public int removeReservation(int resID) {
    	
    	int id = 0;
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "DELETE FROM reservations WHERE id = ?"; // LIMIT 1
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, resID);

            System.out.println("resid" + resID);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if( rs.next() ) id = rs.getInt( 1 );
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	System.out.println("generated " +id);
    	return id;
    }
    
    public int addReservation(String name, String day, String time) {
    	int id = 0;
    	try
        {
    		// query for id, name, birth year, parent name, email
    		String sql = "INSERT INTO reservations VALUES (NULL,?, ?, ?);"; // LIMIT 1
            PreparedStatement pstmt = connection.prepareStatement( sql,
            		Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, name);
            pstmt.setString(2, day);
            pstmt.setString(3, time);

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if( rs.next() ) id = rs.getInt( 1 );
            pstmt.close();     
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
    	System.out.println("generated " +id);
    	return id;
    }
    
}

