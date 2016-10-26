<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <head>
    <meta charset="UTF-8">
    <title>Flat Login Form 3.0</title>
      
	    <link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/business-plate.css" rel="stylesheet">	
    
		<link rel="stylesheet" href="css/reset.css">

		<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
		<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

        <link rel="stylesheet" href="css/login_style.css">

    
    
    
    
  </head>

  <body>

<div class="top">
    <div class="container">
        <div class="row-fluid">
            
            
        </div>
    </div>
	</div>
	
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
            <li class="active"><a href="BugTracker.html">Home</a></li>
            
          </ul>
          
        </div><!--/.nav-collapse -->
      </div>
	</div>
	</div>
	

<!-- Form Module-->
<div class="module form-module">
  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
    <div class="tooltip">Click Me</div>
  </div>
  <div class="form">
    <h2>Login to your account</h2>
    <form action="LoginServ" method="POST">
      <input type="text"  name="username" placeholder="Username"/>
      <input type="password" name="password" placeholder="Password"/>
     
      <button>Login</button>
    </form>
  </div>
  <div class="form">
    <h2>Create an account</h2>
    <form>
      <input type="text" placeholder="Username"/>
      <input type="password" placeholder="Password"/>
      <input type="email" placeholder="Email Address"/>
      <input type="tel" placeholder="Phone Number"/>
      <button>Register</button>
    </form>
  </div>
  <div class="cta"><a href="">Forgot your password?</a></div>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


        <script src="js/index.js"></script>

    
    
		<div class="footerBottomSection">
		<div class="container">
			&copy; 2016, Allright reserved. <a href="#">Terms and Condition</a> | <a href="#">Privacy Policy</a> 
			
		</div>
	</div>
  </body>
</html>
