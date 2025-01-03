<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Airline Reservation</title>
</head>
<body>
    <h2>Welcome to Airline Reservation System</h2>
    <nav>
        <ul>
            <li><a href="flights.jsp">View Flights</a></li>
            <li><a href="profile.jsp">My Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </nav>
</body>
</html>
