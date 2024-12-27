<%-- 
    Document   : CartView
    Created on : Oct 18, 2024, 10:57:13 AM
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
    <link rel="stylesheet" href="css/cartStyle.css">
    <link rel="stylesheet" href="font/fontawesome-free-6.5.2-web/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row" style="background-color: rgb(243, 243, 243); border-radius: 15px;">
            <div class="col-lg-12">
                <div class="">
                    <div class="panel-heading">
                        <div class="panel-title">
                            <div class="row">
                                <div class="col-lg-10">
                                    <h5><span class=""></span> Shopping Cart</h5>
                                </div>
                                <div class="col-lg-2">
                                    <button type="button" class="btn btn-primary btn-sl btn-block back-button" onclick="backToHomePage()">
                                        <span class=""></span> BACK
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="panel-body">
                        <c:if test="${requestScope.ListCart == null}">
                            <p>No Product in cart</p>
                        </c:if>
                        <c:if test="${requestScope.ListCart != null}">
                             <c:forEach items="${requestScope.ListCart}" var="i">
                            <div class="row">
                            <div class="col-lg-2"><img class="img-responsive" src="${i.products.imgUrl}">
                            </div>
                            <div class="col-lg-4">
                                <p class="product-name"><strong>${i.products.productName}</strong></h4><h4><small>${i.products.description}</small></p>
                            </div>
                            <div class="col-lg-6">
                                <div class="col-lg-6 text-right">
                                    <h6><strong>${i.products.price}$ <span class="text-muted">x</span></strong></h6>
                                </div>
                                <div class="col-lg-3">
                                    <input type="text" class="form-control input-sm" value="${i.quantity}">
                                </div>
                                <div class="col-lg-2">
                                    <input type="checkbox">
                                </div>
                                 <div class="col-lg-1 text-right">
                                     <a href="url" class="" style="color: red"><i class="fa-solid fa-trash"></i></a>
                                </div>
                            </div>
                        </div>
                            
                            
                        </c:forEach>
                        </c:if>
                       
                        
                        <hr>
                        
                        <div class="row">
                            <div class="text-center">
                                <div class="col-lg-9">
                                    <h6 class="text-right">Added items?</h6>
                                </div>
                                <div class="col-lg-3">
                                    <button type="button" class="btn btn-default btn-sm btn-block">
                                        Update cart
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer" style="background-color:rgb(243, 243, 243);">
                        <div class="row text-center">
                            <div class="col-lg-9">
                                <h4 class="text-right">Total <strong>${requestScope.totalPrice}$</strong></h4>
                            </div>
                            <div class="col-lg-3">
                                <button type="button" class="btn btn-block check-out">
                                    Checkout
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
        function backToHomePage() {
           window.location.href ='http://localhost:8080/NikeWeb/HomePage';
        }
    </script>
    
</body>
</html>