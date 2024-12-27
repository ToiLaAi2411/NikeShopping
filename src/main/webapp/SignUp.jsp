<%-- 
    Document   : SignUp
    Created on : Sep 27, 2024, 9:12:16 AM
    Author     : DUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <form action="SignupServlet" method="post">
            <h1>Login</h1>

            <div class="form-input">
                <input type="text" placeholder="Account" name="account" value="${requestScope.account}">
                 <br>
                 <span>${requestScope.statusOfAccount}</span>
            </div>

            <div class="form-input">
                <input type="password" placeholder="Password" name="password1">
                <br>
                <span></span>
            </div>


            <div class="form-input">
                <input type="password" placeholder="enter again your password" name="password2">
                <br>
                <span>${requestScope.statusOfPassword}</span>
            </div>

            <div class="form-input">
                <input type="password" placeholder="Phonenumber" name="phone" value="${requestScope.phone}">
                <br>
                <span></span>
            </div>

            <div class="form-input">
                <input type="password" placeholder="Email" name="email" value="${requestScope.email}">
                <br>
                <span></span>
            </div>

            <div class="">
                <label>Femail</label>
                <input type="radio" placeholder="Password" name="gender" value="0" ${requestScope.gender == 0? "checked":""}> 
                <label>Male</label>
                <input type="radio" placeholder="Password" name="gender" value="1" ${requestScope.gender == 1? "checked":""}> 
                 <br>
                <span></span>
            </div>
          <button type="submit" class="btn">Sign up</button>
        </form>
    </div>
    
</body>
</html>
