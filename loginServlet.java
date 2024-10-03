package com.Servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.User.UserDetails;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String email=request.getParameter("uemail");   //jaybhawar432@
		 String password=request.getParameter("upassword");//abcd
		 	 
		 
		 UserDetails u =new UserDetails();
		  u.setEmail(email);
		  u.setPassword(password);
		 
		UserDetails user= UserDAO.loginUser(u);
		
		System.out.println(user);
		 if( user!= null)
		 {
			 HttpSession session = request.getSession();
			 session.setAttribute("userD",user);  //KEY,VALUE
			 response.sendRedirect("home.jsp");
		 }
		 else	
		 {
			 HttpSession session = request.getSession();
			 session.setAttribute("login_failed","Invalid UserName and Password"); 
			 response.sendRedirect("login.jsp");
			 
		 }
	}
}
