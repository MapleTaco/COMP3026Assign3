<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Student Name: Daniel Perusse
	 Student ID: 200551990
	 Student Email: 200551990@student.georgianc.on.ca
	 COMP3026 - Application Security Programming
	  -->
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
	<h1>Registration Page</h1>

	<form action="<%=request.getContextPath()%>/RegisterServlet"
		method="post">
		<!-- Need UserName, Password, Mobile Phone Number, Email Id -->
		<table>
			<tr>
				<!-- UserName: Required -->
				<td>UserName:</td>
				<td><input type="text" name="userName" required /></td>
			</tr>
			<tr>
				<!-- Password: Required -->
				<td>Password:</td>
				<td><input type="text" name="password" required /></td>
			</tr>
			<tr>
				<!-- Mobile Phone Number: Required and correct format -->
				<td>Mobile Phone Number:</td>
				<td><input type="tel" name="phoneNumber" pattern="[0-9]{10}"
					required /></td>
			</tr>
			<tr>
				<!-- Email ID: Required and correct format -->
				<td>Email Id:</td>
				<td><input type="email" name="email" required /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td>${requestScope.createdUserName}</td>
		</tr>
		<tr>
			<td>${requestScope.createdPassword}</td>
		</tr>
		<tr>
			<td>${requestScope.createdPhoneNum}</td>
		</tr>
		<tr>
			<td>${requestScope.createdEmail}</td>
		</tr>
	</table>
</body>
</html>