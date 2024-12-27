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
        <form action="ChangePasswordServlet" method="post">
            <h1>Change Password</h1>

            <div class="form-input">
                <input type="text" placeholder="Current password" name="currentPass" value="">
                <br>
                 <span>${requestScope.statusOfCurrentPass}</span>
            </div>
          

            <div class="form-input">
                <input type="password" placeholder="new password" name="newPass1">
            </div>
            
            <div class="form-input">
                <input type="password" placeholder="new password" name="newPass2">
                <br>
                <span>${requestScope.statusOfNewPass}</span>
            </div>
          <button type="submit" class="btn">Change</button>
        </form>
    </div>
    
</body>
</html>
