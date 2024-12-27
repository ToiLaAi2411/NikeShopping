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
        <form action="" method="post">
            <h4>PROFILE</h4>

            <div class="form-input">
                <input type="text" placeholder="Account" name="account" value="${sessionScope.user.account}">
                 <br>
                 <span>${requestScope.statusOfAccount}</span>
            </div>
            
            <div class="form-input">
                <input type="text" placeholder="Account" name="account" value="${sessionScope.user.password}">
                 <br>
                 <span>${requestScope.statusOfAccount}</span>
            </div>

            <div class="form-input">
                <input type="password" placeholder="Dob" name="dob" value="${sessionScope.user.dob}">
                <br>
                <span></span>
            </div>


            <div class="form-input">
                <input type="password" placeholder="Address" name="Address" value="${sessionScope.user.address}">
                <br>
                <span>${requestScope.statusOfPassword}</span>
            </div>

            <div class="form-input">
                <input type="text" placeholder="Phonenumber" name="phone" value="${sessionScope.user.phone}">
                <br>
                <span></span>
            </div>

            <div class="form-input">
                <input type="text" placeholder="Email" name="email" value="${sessionScope.user.email}">
                <br>
                <span></span>
            </div>

            <div class="">
                <label>Femail</label>
                <input type="radio" placeholder="Password" name="gender" value="0" ${sessionScope.user.gender == 0? "checked":""}> 
                <label>Male</label>
                <input type="radio" placeholder="Password" name="gender" value="1" ${sessionScope.user.gender == 1? "checked":""}> 
                 <br>
                <span></span>
            </div>
                 <a href="checkServlet?action=changePass">Change Password</a>
          <button type="submit" class="btn">Update</button>
        </form>
    </div>
    
</body>
</html>
