<%-- 
    Document   : Login
    Created on : Sep 26, 2024, 6:15:10 PM
    Author     : DUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/ter.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>

    <div class="wrapper">
        <form action="LoginServlet" method="post">
            <h1>Login</h1>

            <div class="form-input">
                <input type="text" placeholder="Account" name="account" value="${requestScope.account}">
                <br>
                 <span>${requestScope.statusAccount}</span>
            </div>
          

            <div class="form-input">
                <input type="password" placeholder="Password" name="password">
                <br>
                <span>${requestScope.statusPass}</span>
            </div>
             

            <div class="remember-forgot">

                <label for=""> <input type="checkbox" name="rememberMe"> Remember me</label>
                <a href="">Forgot password?</a>

            </div>

           
          <button type="submit" class="btn">Login</button>
          <br>
          <span>${requestScope.status}</span>

          <div class="register">
            <p>Don't have an account? <a href="checkServlet?action=signup">Register</a></p>
            
          </div>
        </form>
    </div>
    
</body>
</html>
