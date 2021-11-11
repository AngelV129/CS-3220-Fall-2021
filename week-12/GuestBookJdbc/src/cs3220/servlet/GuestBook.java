package cs3220.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.service.DbService;

@WebServlet(urlPatterns = "/GuestBook", loadOnStartup = 1)
public class GuestBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public GuestBook()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        DbService dbService = new DbService();
        request.setAttribute( "entries", dbService.getEntries() );
        dbService.close();

        request.getRequestDispatcher( "/WEB-INF/GuestBook.jsp" )
            .forward( request, response );
    }
}
