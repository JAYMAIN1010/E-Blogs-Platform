package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PostDAO;

@WebServlet("/BlogEditServlet")
public class BlogEditServlet extends HttpServlet {
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try
		{
			Integer noteid=Integer.parseInt(request.getParameter("noteid"));
			String Title = request.getParameter("title");
			String Content= request.getParameter("content");
			
		//PostDAO dao=new PostDAO(DBConnect.getConn());
			
			int i=PostDAO.PostUpdate(noteid, Title, Content);
			
			//int i=PostDAO.PostUpdate(noteid, Title, Content);
			
			
			//update post set title=?, content =? where noteid=?
			if(i> 0)
			{
				System.out.println("data update successfully..");
				HttpSession  session = request.getSession();
				
				session.setAttribute("UpdateMsg", "Blog Updated Successfully");
				response.sendRedirect("showBlog.jsp");
			}
			else
			{
				System.out.println("data not updated..");
			}
			
		}
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		
	}


}
