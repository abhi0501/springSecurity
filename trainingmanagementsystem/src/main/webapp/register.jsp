<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guru Registration Form</title>
</head>
<body>
<h1>Training Register Form</h1>
<form action="register" method="post">
			<table style="with: 50%">
				<tr>
					<td>User Name</td>
					<td><input type="text" name="username" required /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required"/></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><input type="text" name="role_name" required="required"/></td>
				</tr>
				</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>