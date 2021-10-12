package lab8.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DrivingTestBrowser() {
        super();    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
