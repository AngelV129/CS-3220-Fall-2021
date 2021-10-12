package lab8.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab8.model.Question;


@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DrivingTestBrowser() {
        super();

    }


	public void init(ServletConfig config) throws ServletException {
		super.init();
		List <Question> questions;
		
//		BufferedReader in = new
//		        BufferedReader(new InputStreamReader(new FileInputStream("DrivingTest.txt")));
//		        String line;
//		        while( (line = in.readLine()) != null )
//		            System.out.println(line);
//		        in.close();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
