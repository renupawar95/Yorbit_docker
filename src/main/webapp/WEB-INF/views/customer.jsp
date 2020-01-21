<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Manager Details</h1>
	<hr>
	<div class="form">
		<form action="/addcustomer" method="post" onsubmit="return validate()">
			<table>
				<tr>

					<td>Name</td>
					<td><input type="text" id="customerName" name="customerName"></td>
				</tr>
				<tr>
					<td>PhoneNum</td>
					<td><input type="text" id="PhoneNum" name="PhoneNum"></td>
				</tr>
				<tr>
					<td>checkInDate</td>
					<td><input type="text" id="checkInDate" name="checkInDate"></td>
				</tr>
				<tr>
					<td>checkOutDate</td>
					<td><input type="text" id="checkOutDate" name="checkOutDate"></td>
				</tr>
				<tr>
					<td>RoomType</td>
					<td><select name="roomType" class="dropdown-menu">
							<option>Luxury</option>
							<option>SemiLuxury</option>
							<option>Deluxe</option>
					</select></td>
				</tr>
				<tr>
					<td>Hobby</td>
					<td><select name="hobby" class="dropdown-menu">
							<option>Reading</option>
							<option>Programming</option>
							<option>Swimming</option>
							<option>Cooking</option>
							<option>Drinking</option>
					</select></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><select name="gender" class="">
							<option>Male</option>
							<option>Female</option>
							<option>Others</option>
					</select></td>
				</tr>
				<tr>
					<td>comments</td>
					<td><input type="text" id="comments" name="comments"></td>
				</tr>
				<tr>
					<td>emailId</td>
					<td><input type="text" id="emailId" name="emailId"></td>
				</tr>
				<tr>
					<td><select name="hotel">
							<c:forEach var="hotel" items="${ hotels}">
								<option value="${hotel.hotelId}">${hotel.hotelName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>