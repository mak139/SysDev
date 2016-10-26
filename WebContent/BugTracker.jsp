<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<% 
//allow access only if session exist
String user = null;

if(session.getAttribute("userName") == null){
	response.sendRedirect("BugTrackerServ.html");
}
else 
	{
	user = (String) session.getAttribute("userName");
	
	}
%>


<br>
<div class="top">
    <div class="container">
        <div class="row-fluid">
            
            <ul class="loginbar">
               
               
                <li><a href="" class="login-btn">Welcome <%=user%></a></li>
            </ul>
        </div>
    </div>
</div>
	
	<!-- topHeaderSection -->	
    <div class="topHeaderSection">		
    <div class="header">			
		<div class="container">
        <div class="navbar-header">
         
          <h2> Bug Tracker </h2>
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
		if(session.getAttribute("roleName").equals("Triager")){
		%> 

	<li>
	<form action="TriagerServ" method="POST">
	<input type="submit" value="Triager" name="action" >
	</form>
	</li>
 	<%} %>
 		
 		<% 
		if(session.getAttribute("roleName").equals("Developer")){
		%>	
		 <li>
		<form action="ViewPatchServ" method="POST">
		<input type="submit" value="Apply Patch" >
		</form>
		</li>
		<%} %>
		
		<%
		if(session.getAttribute("roleName")!=null){
		if(session.getAttribute("roleName").equals("Reviewer")){
		%>
		<li>
		<form action="ViewReviewerServ" method="POST">
		<input type="submit" value="Reviewer" >
		</form>
		</li>
		<%}} %>
		
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
	
		
<h3>Hi <%=user%>, Login successful</h3>

<form action="<%=response.encodeURL("LogoutServ") %>" method="post">
<input type="submit" value="LOGOUT" >
</form>


<!-- footerBottomSection -->	
	<div class="footerBottomSection">
		<div class="container">
			&copy; 2016, Allright reserved. <a href="#">Terms and Condition</a> | <a href="#">Privacy Policy</a> 
			
		</div>
	</div>		
</body>
</html>