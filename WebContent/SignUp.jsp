<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
                <li><a href="BugTracker.html" class="login-btn">Home</a></li>
                <li class="devider">&nbsp;</li>
                <li><a href="SignUp.jsp" class="login-btn">Sign Up</a></li>
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
			 
	        
           
        <li>
		<form action="BugReportForm.jsp" method="">
		<input type="submit" value="Report Bug" >
		</form>
		</li>
		
		
		
				
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
		
<form action="<%=response.encodeURL("RegisterServ")%>" method="post">
 <fieldset>
    <legend>Personal Particular</legend>
    Name: <input type="text" name="username" /><br /><br />
    Password: <input type="password" name="password" /><br /><br />
    Email Addres <input type="text" name="email" /><br /><br />
  </fieldset>
 
<input type="submit" value="SignUp" >
</form>


<!-- footerBottomSection -->	
	<div class="footerBottomSection">
		<div class="container">
			&copy; 2016, Allright reserved. <a href="#">Terms and Condition</a> | <a href="#">Privacy Policy</a> 
			
		</div>
	</div>		
	<br/>
</body>
</html>