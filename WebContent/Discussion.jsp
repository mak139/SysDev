<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="height: 338px; ">
	<center>
		<h1>Add Comment</h1>
		<form method="post" action="AddDiscussionServ" style="height: 239px; ">
			<table border=".2" width="70%" cellpadding="5" style="width: 739px; height: 119px; ">
				<tr>
					<td>Comment</td>
					<td style="width: 350px; "><input type="text" name="des" style="width: 362px; height: 85px"/></td>
				</tr>
			</table>
			</br></br>
			<input type="submit" value="submit" operation="insert" style="width: 178px; height: 44px; ">
			<input type="submit" value="View Discussion" operation="view" style="width: 178px; height: 44px; ">
		</form>
	</center>
	
</body>
</html>