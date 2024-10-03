package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;

public class UserDAO {
	
	//int a      
		 private Connection conn;
		 

		    public static Connection getConn()
		    {  
		        Connection conn=null;  
		        try{  
		        	Class.forName("com.mysql.jdbc.Driver");
		             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eblogs_servlet","root","root"); //2 
		        }
		        catch(Exception e)
		        {System.out.println(e);}  
		        return conn;  
		    }
		    
		    public static int addUser(UserDetails u) // satatic methos call by classname like UserDAO.addUser
		    {
		    	int i=0;
		    	try {
		    		Connection conn= UserDAO.getConn();
		    		
		    		PreparedStatement ps= conn.prepareStatement("insert into user(name,email,password)values(?,?,?)");
		    		ps.setString(1,u.getName());
		    		ps.setString(2,u.getEmail());
		    		ps.setString(3,u.getPassword());
		    		
		    		i= ps.executeUpdate();
		    		
		    	}
		    	catch (Exception e) {
					// TODO: handle exception
		    		e.printStackTrace();
				}
		    	return i;
		    }

		    public static UserDetails loginUser(UserDetails u)
		    {
		    	UserDetails user= null;
		    	Connection conn= UserDAO.getConn();
		    	try {
		    		String qurey="select * from user where email=? and password=?";
		    		PreparedStatement ps= conn.prepareStatement(qurey);
		    		ps.setString(1, u.getEmail());
		    		ps.setString(2, u.getPassword());
		    		
		    		ResultSet rs = ps.executeQuery();
		    		
		    		while(rs.next())
					 {
						 user= new UserDetails();
						
						 
						 user.setId(rs.getInt("id"));				 
						 user.setName(rs.getString("name"));
						 user.setEmail(rs.getString("email"));
						 user.setPassword(rs.getString("password"));
					 }
		    	}
		    		catch(Exception e)
		    		{
		    			e.printStackTrace();
		    		}
				return user;

		    			
		    	
		    }
}	

