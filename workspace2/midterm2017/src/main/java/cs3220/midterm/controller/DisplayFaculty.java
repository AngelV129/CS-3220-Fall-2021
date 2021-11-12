package cs3220.midterm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.midterm.model.Department;
import cs3220.midterm.model.Faculty;

@WebServlet(urlPatterns = "/DisplayFaculty", loadOnStartup = 1)
public class DisplayFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DisplayFaculty()
    {
        super();
    }
    
    // no longer need to store data in application scope

//    public void init( ServletConfig config ) throws ServletException
//    {
//        super.init( config );
//
//        List<Department> departments = new ArrayList<Department>();
//        departments.add( new Department( "Computer Science" ) );
//        departments
//            .add( new Department( "Electrical and Computer Engineering" ) );
//        getServletContext().setAttribute( "departments", departments );
//    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu32";
            String username = "cs3220stu32";
            String password = "Ni7aU0hs82Eb";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery( "SELECT dp.name as department_name FROM department dp" );
            
            // populate deparments arrat first
            // Create List<Department>
            List<Department> departments = new ArrayList<Department>();
            while( rs.next() )
            {
            	Department dep = new Department();
            	
            	dep.setName(rs.getString("department_name"));
            	departments.add(dep);
               
            }
            
            rs = stmt.executeQuery( "SELECT fa.name as faculty_name,\r\n"
            		+ "    fa.is_chair as chair,\r\n"
            		+ "    dp.name as department_name\r\n"
            		+ "    FROM faculty fa, department dp\r\n"
            		+ "    WHERE fa.department_id = dp.id\r\n"
            		+ "    ORDER BY dp.name" );
            
            // create facutly and insert into correct department
            while( rs.next() )
            {
            	String currDepName = rs.getString("department_name");
            	String currFacName = rs.getString("faculty_name");
            	Boolean currChair = rs.getBoolean("chair");
//            	System.out.println("Current dept name is " + currDepName + " " + currFacName + " " + currChair);
            	Faculty fac = new Faculty();
            	fac.setName(currFacName);
            	fac.setChair(currChair);
            	
            	// get the faculty list for the department object.
            	List<Faculty> facultyList = new ArrayList<Faculty>();
            	
            	// iterate throght list to find matching dept. to faculty.
            	for(Department dep: departments) {
            		facultyList = dep.getFaculty();
//            		System.out.println(dep.getName() + " " + dep.getName());
            		// if mathching then add facutly to department
            		if(dep.getName().equalsIgnoreCase(currDepName)) {
            			facultyList = dep.getFaculty();
            			facultyList.add(fac);
            		}
            	}
            
            }
            
            // Pass the list to view
            request.setAttribute("departments", departments);
            
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }
    	
    	
        request.getRequestDispatcher( "/WEB-INF/midterm/DisplayFaculty.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
