package cs3220.midterm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.midterm.model.Department;
import cs3220.midterm.model.Faculty;
import midService.DbService;

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	List<Department> departments = new ArrayList<Department>();
    	DbService dbService = new DbService();
    	departments = dbService.getDepartments();
    	dbService.close();
    	request.setAttribute("departments", departments);
    	
//    	Connection c = null;
//        try
//        {
//            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu32";
//            String username = "cs3220stu32";
//            String password = "Ni7aU0hs82Eb";
//
//            c = DriverManager.getConnection( url, username, password );
//            Statement stmt = c.createStatement();
//            
//            ResultSet rs = stmt.executeQuery( "SELECT dp.name as department_name FROM department dp" );
//            
//            // populate deparments array first
//            // Create List<Department>
//            List<Department> departments = new ArrayList<Department>();
//            while( rs.next() )
//            {
//            	Department dep = new Department();
//            	
//            	dep.setName(rs.getString("department_name"));
//            	departments.add(dep);
//               
//            }
//            
//            // Pass the list to view
//            request.setAttribute("departments", departments);
//            
//        }
//        catch( SQLException e )
//        {
//            throw new ServletException( e );
//        }
//        finally
//        {
//            try
//            {
//                if( c != null ) c.close();
//            }
//            catch( SQLException e )
//            {
//                throw new ServletException( e );
//            }
//        }
    	
        request.getRequestDispatcher( "/WEB-INF/midterm/AddFaculty.jsp" )
            .forward( request, response );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	// Insert data into the database
        String departmentName = request.getParameter( "department" );
        
        
        
//        Faculty faculty = new Faculty( request.getParameter( "faculty" ) );
//        if( request.getParameter( "chair" ) != null ) faculty.setChair( true );

//        List<Department> departments = ((List<Department>) getServletContext()
//            .getAttribute( "departments" ));
//        for( Department department : departments )
//            if( department.getName().equals( departmentName ) )
//                department.getFaculty().add( faculty );

        response.sendRedirect( "DisplayFaculty" );
    }

}
