package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.User.UserDetails;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
	
		String name=request.getParameter("fname");
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		UserDetails u = new UserDetails();
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		
		int i = UserDAO.addUser(u);
		
		PrintWriter out=response.getWriter();
		HttpSession session;
		if(i > 0)
		 {
			 session= request.getSession();
			 session.setAttribute("reg_success","Registration Successfully.");
			 response.sendRedirect("register.jsp");
		 }
		 else 
		 {
			 session= request.getSession();
			 session.setAttribute("failed_msg","Something went wrong on server."); 
			 response.sendRedirect("register.jsp");
		 }
	}
}
