package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;  
import javax.servlet.ServletException;  

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "kiru";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Cityy city=new Cityy();
		city.display();
		PrintWriter out= response.getWriter();
		// get request parameters for userID and password
		String user = request.getParameter("inputname");
		if(userID.equals(user)) {
		HttpSession session = request.getSession();
		session.setAttribute("sessname",user);
		response.sendRedirect("LoginSuccess.jsp");

		}
		else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
		
	}
}
