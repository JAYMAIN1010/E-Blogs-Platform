package com.Servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.PostDAO;

@WebServlet("/AddBlogServlet")
public  class AddBlogServlet extends HttpServlet {
	

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		int uid= Integer.parseInt(request.getParameter("uid")); //4
		   String title= request.getParameter("title"); //inheritance
		   String content= request.getParameter("content"); //bdddvsvd //blogid,date

		  
		   
		   int f=PostDAO.AddBlog(title, content, uid);
		   
		   if(f > 0)
		   {
			  System.out.println("data insert successfully..");
			  response.sendRedirect("showBlog.jsp");
		   }
		   else
		   {
			   System.out.println("data not inserted..");
		   }
		   
		   
		   


	}

}
