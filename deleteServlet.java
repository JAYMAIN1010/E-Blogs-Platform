package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PostDAO;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Integer noteid= Integer.parseInt(request.getParameter("note_id"));
		 
		// PostDAO dao=new PostDAO(DBConnect.getConn());
			
		//int i=dao.DeleteBlog(noteid);
		  int i=PostDAO.DeleteBlog(noteid);	
		 
			HttpSession  session=null;
			if(i > 0)
			{
				
				 session = request.getSession();
				
				session.setAttribute("DeleteMsg", "Blog Deleted Successfully");
				response.sendRedirect("showBlog.jsp");
				
			}
			else
			{
				 session = request.getSession();
				 session.setAttribute("wrongMsg", "Something went wrong on server");
				 response.sendRedirect("showBlog.jsp");
			}
	}

	
}
