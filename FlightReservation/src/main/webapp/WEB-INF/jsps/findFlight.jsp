<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Flight</title>
</head>
<body>
     <h2>Search Flight</h2>
     
     <form action = "findFlights" method = "post">
     
            FROM: <input type ="text" name = "from"/>
            TO:   <input type ="text" name = "to"/>
            DEPARTURE DATE:<input type = "text" name = "departureDate"/>
            <input type = "Submit" value = "Search"/>
     </form>
     
</body>
</html>