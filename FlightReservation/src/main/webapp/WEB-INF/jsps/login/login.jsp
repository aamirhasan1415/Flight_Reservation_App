<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
    <h2>Login here</h2>
    
    <form action="verifyLogin" method="post">
             <pre>
                 Email       <input type="email" name="email"> <br>
                 Password    <input type="password" name="password"> <br> <br>
                 <input type="submit" value="login"><br><br>
                 
             </pre>
          </form>
          
          <h3 style="color:red">${error }</h3>

</body>
</html>