<%-- 
    Document   : index
    Created on : Sep 25, 2024, 10:26:00 AM
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

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="font/fontawesome-free-6.5.2-web/css/all.min.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>

    <div class="container-fluid" style="background-color: rgb(255, 255, 255);">

       <header class="">
        <div class="row component-1 cover-page">

            <div class="col-md-6 header-logo">
                <img src="img/il_794xN.3920518793_53yg.jpg" alt="" style="width: 7%; height: 35px;">
                <h5>Hello ${sessionScope.user.account}</h5>
            </div>
            <div class="col-md-6 option_1">
                <ul>
                    <li class="option-header"><a href="">Find a store</a></li>
                    <span class="line-row"></span>
                    <li class="option-header"><a href="">Help</a></li>
                    <span class="line-row"></span>
                    <li class="option-header"><a href="checkServlet?action=ManageAccount">Manage account</a></li>
                    <span class="line-row" style="margin: 14px 7px;"></span>
                    <c:if test="${sessionScope.user == null}">
                        <li class="option-header"><a href="LoginServlet">Sign In</a></li>
                    </c:if>
                    <c:if test="${sessionScope.user != null}">
                        <li class="option-header"><a href="LogoutServlet">Logout</a></li>
                    </c:if>
                        
                </ul>
            </div>
        </div>

        <div class="row component-2 cover-page">
            <div class="col-md-3 header-logo-2">
                <img src="img/logo-cua-hang-nike.png" alt="" style="width: 35%; height: 64px;" >
            </div>

            <div class="col-md-6">
                <ul class="category_List">
                    <li class="category"><a href="">New & Featured</a></li>
                    <li class="category"> <a href="">Men</a></li>
                    <li class="category"><a href="">Women</a></li>
                    <li class="category"><a href="">Kids</a></li>
                    <li class="category"><a href="">Sale</a></li>
                    <li class="category"><a href="">Customise</a></li>
                    <li class="category"><a href="">SNKRS</a></li>
                </ul>
            </div>

            <form class="col-md-3 search_header">
                <input type="text" placeholder="search">
                <a href="" type="submit"><i class="fa-solid fa-magnifying-glass icon-search"></i></an>
                <a href=""> <i class="fa-regular fa-heart"></i></a>
                <a href="CartServlet"> <i class="fa-solid fa-bag-shopping"></i></a>
            </form>
        </div>

        <div class="row component-3">
            <div class="banner_new-header">
                <div class="rightBanner_content">
                    <h4>
                        Move, Shop, Customise & Celebrate With Us
                    </h4>
                </div>
                <div class="leftBanner_content">
                    <span>
                        No matter what you feel like doing today, It’s better as a Member. <br>
                        <a href="">Join Us</a>
                    </span>
                </div>
            </div>
        </div>      
       </header>

    <nav class="row header-bodyWeb cover-page">
        <div class="col-md-6 header-bodyWeb-component_1">

            <span><a href="">New Release </a> / <a href="">Shoes</a></span>
            <h3>New Shoes (${listP.size()})</h3>

        </div>
        <div class="col-md-6 header-bodyWeb-component_2">
             <span>Hide Filters  <i class="fa-solid fa-sliders"></i></span>
             <span>Sort by  <i class="fa-solid fa-sliders"></i></span>
        </div>
     </nav>



       <div class="row body-web cover-page">
           
                <div class="col-md-2 left-menu">
                    <ul class="list-category">
                        <c:forEach items="${listC}" var="i">
                            <li class="category-element"><a href="FilterCategory?cateID=${i.categoryID}">${i.categoryName}</a></li>
                        </c:forEach>
                    </ul>
                </div>

                <div class="col-lg-10 right-menu">
                    <c:forEach items="${listP}"  var="x">
                      <div class="col-lg-4 item">
                        <a href="showProduct?productID=${x.productID}">
                            <img src="${x.imgUrl}" alt="">
                            <div class="information">
                                <p>Just in</p>
                                <p>${x.productName}</p>
                                <p>${x.description}</p>
                                <p>${x.price} $</p>
                            </div>
                        </a>
                     </div>
                    </c:forEach>
                </div>
       </div>
    </div>



</body>
</html>