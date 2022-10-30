<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
	font-family: Montserrat, Sans Serif;
	color: #4f546c;
	font-size: 15px;
	background: linear-gradient(to right, #fefefe, #ebedee 75%);
}

a {
	text-decoration: none;
	font-style: italic;
	color: #2962ff;
}
</style>
<title>Welcome Page</title>
</head>

<!-- This is a welcome page that is loaded when the application boots on -->
<body>
	<div>
		<h3>Welcome to the Customer Registration Portal</h3>

		<!-- Link to the customer list page -->
		<a href="customers/list">Click here to view the list of registered
			customers</a>
	</div>
</body>
</html>