package midService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cs3220.midterm.model.Department;

public class DbService {
	
	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu32";

    private String username = "cs3220stu32";

    private String password = "Ni7aU0hs82Eb";

    private Connection connection;
    
    
    public DbService()
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
    
    public  List<Department> getDepartments(){
    	
    	// Create List<Department>
        List<Department> departments = new ArrayList<Department>();

        try
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT dp.name as department_name FROM department dp" );
            
            // populate deparments array first
            
            while( rs.next() )
            {
            	Department dep = new Department();
            	
            	dep.setName(rs.getString("department_name"));
            	departments.add(dep);
               
            }
            
            stmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    	
		return departments;
	}
    
    // TODO: Add an addFaculty(name, ischair, deptName), addDepartment(deptName)
    
    // add faculty will need to find the id for matching deptName.
    // After it will need to add the faculty entry.
    
    // addDept will just need to add the dept to the database

}
