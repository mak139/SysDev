<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.uow.cs.gpthirteen.bean.*"%>
<%@ page import="com.uow.cs.gpthirteen.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
     <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="themes/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	

    <!-- Custom styles for this template -->
	
    <link href="css/business-plate.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<div class="top">
    <div class="container">
        <div class="row-fluid">
            
            <ul class="loginbar">
               <%if (session.getAttribute("userName")!=null){ %>
            	<form action="<%=response.encodeURL("LogoutServ") %>" method="post">
			<input type="submit" value="LOGOUT" >
			</form> 
			<%}
			else { %>
			 <li><a href="BugTracker.html" class="login-btn">Home</a></li>
			<% }%> 
            </ul>
        </div>
    </div>
</div>
	
	<!-- topHeaderSection -->	
    <div class="topHeaderSection">		
    <div class="header">			
		<div class="container">
        <div class="navbar-header">
         
          <h3> Bug Tracker </h3>
        </div>
       
	   <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            
          </ul>
          <ul class="nav navbar-nav navbar-right">
           
        <li>
        <form action="ViewProjectServ" method="post">
		<input type="submit" value="View Projects" >
		<input type="hidden" name="viewproject" value="View_proj"/>
		</form>
		</li>
		
		<li>
		<form action="ViewUserServ" method="post">
		<input type="submit" value="View Users" >
		</form>
		</li>
			 
		<!-- <li>
		<form action="ViewBugDetailServ" method="post">
		<input type="submit" value="Add Comments" >
		</form>
		</li>	 -->         
           
        <li>
		<form action="BugReportForm.jsp" method="">
		<input type="submit" value="Report Bug" >
		</form>
		</li>
		
		
		<% 
		if(session.getAttribute("roleName").equals("Developer")){
		%>
		 <li>
		<form action="ViewPatchServ" method="POST">
		<input type="submit" value="Apply Patch" >
		</form>
		</li>
		<%} %>
		
		<li>
		<form action="ViewCommentServ" method="POST">
		<input type="submit" value="View Discussion" >
		</form>
		</li>
		 </ul>
        </div><!--/.nav-collapse -->
      </div>
	</div>
	</div>
	<hr/>
	<br/>
	<h1>Triage</h1>

	<table border="1">
		<tr>
			<td>Bug ID</td>
			<td>User ID</td>
			<td>Project ID</td>
			<td>Component ID</td>
			<td>Subscriber group ID</td>
			<td>Description</td>
			<td>Summary</td>
		</tr>

		<c:forEach var="projects" items="${allbugs}">
			<tr>
				<td><c:out value='${projects.getBug_ID()}' /></td>
				<td><c:out value='${projects.getUser_ID()}' /></td>
				<td><c:out value='${projects.getProjectID()}' /></td>
				<td><c:out value='${projects.getComponent_ID()}' /></td>
				<td><c:out value='${projects.getSubscriberGroupID()}' /></td>
				<td><c:out value='${projects.getDescription()}' /></td>
				<td><c:out value='${projects.getSummary()}' /></td>
			</tr>
		</c:forEach>

		<form action="<%=response.encodeURL("TriagerServ")%>" method="post">
		<!-- <form method="post" action="TriagerServ" style="height: 239px; "> -->
			<table>
				<tr>
					<td>Bug ID</td>
					<td><select name="viewprojdetails">
							<c:forEach var="projects" items="${allbugs}">
								<option value="<c:out value='${projects.getBug_ID()}'/>">
									<c:out value='${projects.getBug_ID()}' /></option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Priority</td>
					<td><select name="priority">
							<option value="low">Low</option>
							<option value="medium">Medium</option>
							<option value="high">High</option>
					</select></td>
					<td>
						<input type="submit"  value="Submit" name = "operation">
					</td>
				</tr>
			</table>
		</form>
	</table>
	<br/>
	
	<!-- footerBottomSection -->	
	<div class="footerBottomSection">
		<div class="container">
			&copy; 2016, Allright reserved. <a href="#">Terms and Condition</a> | <a href="#">Privacy Policy</a> 
			
		</div>
	</div>	
</body>
</html>