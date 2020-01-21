<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>Manager project Details</h1>
	<hr>
	<form action="/getcustomerdata" method="get">
		<%-- <table class="table table-dark table-hover" border="2" width="70%"
			cellpadding="2">
			<tr>
				<th class="table-success">HotelId</th>
				<th class="table-success">HotelName</th>
			</tr>
			<c:forEach var="hotel" items="${result}">
				<tr class="info">
					<td>${hotel.hotelId}</td>
					<td>${hotel.hotelName}</td>
				</tr>
		 --%>		<table class="table" border="2" width="70%" cellpadding="2">
					<tr>
						<th class="table-light">customerId</th>
						<th class="table-success">customerName</th>
						<th class="table-light">checkInDate</th>
						<th class="table-light">checkOutDate</th>
						<th class="table-success">roomType</th>
						<th class="table-light">hobby</th>
						<th class="table-light">gender</th>
						<th class="table-success">comments</th>
						<th class="table-light">emailId</th>
					</tr>
					<c:forEach var="customer" items="${result}">
						<tr class="info">
							<td>${customer.customerId}</td>
							<td>${customer.customerName}</td>
							<td>${customer.checkInDate}</td>
							<td>${customer.checkOutDate}</td>
							<td>${customer.roomType}</td>
							<td>${customer.hobby}</td>
							<td>${customer.gender}</td>
							<td>${customer.comments}</td>
							<td>${customer.emailId}</td>
						</tr>
						
					</c:forEach>
				</table>
		<a href="/">
			<button>back</button>
		</a>
	</form>
</body>
</html>