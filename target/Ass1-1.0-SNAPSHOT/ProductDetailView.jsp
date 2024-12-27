<%-- 
    Document   : ProductDetailView
    Created on : Oct 23, 2024, 10:28:28 AM
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
    <link rel="stylesheet" href="css/DetailPR-2.css">

    <link rel="stylesheet" href="font/fontawesome-free-6.5.2-web/css/all.min.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
       <div class="back-button">
           <a href="HomePage">BACK</a>
       </div>

       <div class="row detail_place">
           <div class="col-lg-7 row left_part">

             

               <div class="col-lg-10 main-image">
                   <img src="${requestScope.productToShow.imgUrl}" alt="">
                <div class="rated">
                  <span><i class="fa-solid fa-star"></i> Highly rated</span>
                </div>
   
               </div>
           </div>

           <div class="col-lg-5 right-part">
                <div class="product_infor">
                    <p>Sustainable Materials</p>
                    <h3>${requestScope.productToShow. productName}</h3>
                    <p>Men's Road Running Shoes</p>
                </div>

                <div class="format_1-shoesDT product_price">
                    <p>${requestScope.productToShow.price}$</p>
                </div>

        
              

                <div class="size_shoes">
                    <div class="format_1-shoesDT size_option-header">
                        <p>Select Size</p>
                        <a href=""><i class="fa-solid fa-ruler"></i> Size Guide</a>

                    </div>

                    <div class="row size">
                        
                        <c:forEach items="${requestScope.listDetail}" var="ld">
                            <div class="col-lg-3 size_element">
                                <label for="">EU ${ld.size_value}</label>
                            </div> 
                        </c:forEach>       
                    </div>
                </div>

               

                <div class="button-shop">
                    <button class="btn btn-lg btn-block">Add to cart</button>
                    <button class="btn btn-lg btn-block">Favourite <i class="fa-regular fa-heart"></i></button>
                </div>
                <div class="product-description">
                    <p>
                        ${requestScope.productToShow.description}
                    </p>
                </div>
                
           </div>
       </div>
    </div>
</body>
</html>