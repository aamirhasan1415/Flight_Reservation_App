<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display flight</title>
</head>
<body>
     <h2>Display Flight here...</h2>
     <h3>LIST OF FLIGHTS</h3>
     
    <table border="2">
    <tr>
       <th>AIRLINES</th>
       <th>DEPARTURE CITY</th>
       <th>ARRIVAL CITY</th>
       <th>DEPARTURE TIME</th>
       <th>BOOK FLIGHT</th>
   </tr>
   
   <c:forEach var="flights" items="${flights}">
     <tr>
        <td>${flights.operatingAirlines}</td>
        <td>${flights.departureCity}</td>
        <td>${flights.arrivalCity}</td>
        <td>${flights.estimatedDepartureTime}</td>
        <td><a href="bookFlight?flightId=${flights.id}">Book</a></td>
    </tr>
  </c:forEach>
  
</table>

</body>
</html>