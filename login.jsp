<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.back-img {
	/* background: url("img/cl4.jpeg"); */
	background: url("img/L6.avif");
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-size: cover;
}
#d1{
     margin-top: 70px;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>




<%@include file="all_components/allcss.jsp"%>
</head>

<body>


	<%@include file="all_components/navbar.jsp"%>
	<div class="container-fluid back-img">
		<div class="row">
			<div  id="d1" class="col-md-4 offset-md-4">

				<div class="card mt-4">    <!-- 5 -->
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-circle fa-1x" aria-hidden="true"></i>  <!-- 3x -->
						<h4>Login</h4>
					</div>

					<%
                      String invalidMsg= (String)session.getAttribute("login_failed");
                 
                      if(invalidMsg != null)
                      {%>
                    	  <div class="alert alert-danger" role="alert"><%= invalidMsg%></div>
                      <%
                      session.removeAttribute("login_failed");
                      }
                       
                      %>
                      
                      
                      
                      
                  
                     <%
                       String withouitLogin= (String)session.getAttribute("login_error");
                        if(withouitLogin !=null)
                        {%>
                        
                          <div class="alert alert-danger" role="alert"><%= withouitLogin%></div>	
                       <%
                       session.removeAttribute("login_error");
                        }
                     %>

      <%
      
      String lgMsg= (String)session.getAttribute("logoutMsg");
      if(lgMsg!=null)
      {%>
    	    <div class="alert alert-success" role="alert"><%=lgMsg%></div>	
    	  
      <%
      session.removeAttribute("logoutMsg");
      }
      %>

					<div class="card-body">
						<form action="loginServlet" method="post">

							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uemail"
									placeholder="Enter email"> <small id="emailHelp"
									class="form-text text-muted"></small>

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name="upassword" placeholder="Password">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	
	<div class="container-fluid bg-dark mt-1">
<div class= "container-fluid bg-dark mt-3">
<p class="text-center text-white">Designed and Developed by Jay Bhawar</p>

<p class="text-center text-white">For any queries connect with Jay at <a href="#">jaybhawar432@gmail.com</a> 
</div>
</div>
	



</body>
</html>


