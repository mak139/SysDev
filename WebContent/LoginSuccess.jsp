<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success Page</title>
</head>
<body>
<% 
//allow access only if session exist
String user = null;
int id = 0;
if(session.getAttribute("userName") == null){
	response.sendRedirect("BugTrackerServ.html");
}
else 
	{
	user = (String) session.getAttribute("userName");
	/* id  = (int) session.getAttribute("userID"); */
	}
%>
<h3>Hi <%=user%>, Login successful. Your Session ID=<%=session.getId()%></h3>
<h2>Your User Id <%=id%></h2>
<br>

<form action="<%=response.encodeURL("LogoutServ") %>" method="post">
<input type="submit" value="LOGOUT" >
</form>

</body>
</html>