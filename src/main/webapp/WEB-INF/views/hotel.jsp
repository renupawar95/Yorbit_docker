<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Project Details</h1>
	<hr>
	<div class="form">
		<form action="/addhotel" method="post" onsubmit="return validate()">
			<table>

				<tr>
					<td> Hotel Name</td>
					<td><input type="text" id="hotelName" name="hotelName"></td>
				</tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>