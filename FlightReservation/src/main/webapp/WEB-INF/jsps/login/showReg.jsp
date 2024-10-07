<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Registration</title>
</head>
<body>
        <form action="saveReg" method="post">
             <pre>
                 FirstName   <input type="text" name="firstName"> <br>
                 LastName    <input type="text" name="lastName"> <br>
                 Email       <input type="email" name="email"> <br>
                 Password    <input type="password" name="password"> <br> <br>
                 <input type="submit" value="save"><br><br>
                 
             </pre>
          </form>
</body>
</html>