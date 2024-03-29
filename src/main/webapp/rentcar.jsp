<%@page import="model.Utente" %>
<%@page import="model.Veicoli" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="usr" class="model.Utente" scope="request"/>
<jsp:useBean id="car" class="model.Veicoli" scope="session"/>
<c:if test="${empty utente}">
    <%
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.sendRedirect("index.jsp");
    %>
</c:if>
<!DOCTYPE html>
<html>
<html lang="en">

<head>
    <title>Car Rent SI</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
    <link rel="stylesheet" href="css/aos.css">

    <!-- MAIN CSS -->
    <link rel="stylesheet" href="css/style.css">

</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

<input type="hidden" id="dateDaDisabilitare" value="${dateDaDisabilitare}"/>


<div class="site-wrap" id="home-section">

    <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close mt-3">
                <span class="icon-close2 js-menu-toggle"></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div>


    <header class="site-navbar site-navbar-target" role="banner">

        <div class="container">
            <div class="row align-items-center position-relative">

                <div class="col-3 ">
                    <div class="site-logo">
                        <a href="index.jsp">CarRentSI</a>
                    </div>
                </div>
                <div class="login-message">
                    <c:if test="${utente!=null}">
                        Loggato come
                        <a href="profile.jsp">
                            <c:out value="${utente.nome}"></c:out>
                            <c:out value="${utente.cognome}"></c:out>
                        </a>

                    </c:if>
                </div>

                <div class="col-7  text-right" style="left: 20%; font-size: 14px;">


              <span class="d-inline-block d-lg-none">
                <a href="#" class="text-white site-menu-toggle js-menu-toggle py-5 text-white">
                  <span class="icon-menu h3 text-white"></span>
                </a>
              </span>
                    <nav class="site-navigation text-right ml-auto d-none d-lg-block" role="navigation">
                        <ul class="site-menu main-menu js-clone-nav ml-auto ">
                            <li class="active"><a href="index.jsp" class="nav-link">Home</a></li>
                            <li><a href="addCar.jsp" class="nav-link">Services</a></li>
                            <c:if test="${utente!=null}">
                                <li><a href="cars.jsp" class="nav-link">Cars</a></li>
                            </c:if>
                            <c:if test="${utente.ruolo.descrizione=='Admin'}">
                                <li><a href="newuser.jsp" class="nav-link">New User</a></li>
                                <li><a href="addCar.jsp" class="nav-link">Add Car</a></li>
                            </c:if>
                            <c:if test="${utente!=null}">
                                <li><a onclick="logout()" class="nav-link" style="cursor:pointer">Logout</a></li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </header>

    <div class="ftco-blocks-cover-1">
        <div class="ftco-cover-1 overlay innerpage" style="background-image: url('images/hero_2.jpg')">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <form class="trip-form" style="min-width: 900px;
                                                   max-width: 1200px;
                                                   margin-top: 100px;
                            ">
                        <div class="row align-items-center mb-4">
                            <div class="col-md-6">
                                <h3 class="m-0">Begin your trip here</h3>
                            </div>
                        </div>
                        <div class="row">
                            <form action="/rent" method="get">
                                <div class="form-group col-md-6">
                                    <div class="it-datepicker-wrapper">
                                        <div class="form-group">
                                            <label for="date1">Data inizio noleggio</label>
                                            <input name="dataInizio" id="date1" type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <div class="it-datepicker-wrapper">
                                        <div class="form-group">
                                            <label for="date2">Data fine noleggio</label>
                                            <input name="dataFine" id="date2" type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <input type="submit" value="Submit" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <footer class="site-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <h2 class="footer-heading mb-4">About Us</h2>
                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there
                        live the blind texts. </p>
                </div>
                <div class="col-lg-8 ml-auto">
                    <div class="row">
                        <div class="col-lg-3">
                            <h2 class="footer-heading mb-4">Quick Links</h2>
                            <ul class="list-unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Testimonials</a></li>
                                <li><a href="#">Terms of Service</a></li>
                                <li><a href="#">Privacy</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </div>
                        <div class="col-lg-3">
                            <h2 class="footer-heading mb-4">Quick Links</h2>
                            <ul class="list-unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Testimonials</a></li>
                                <li><a href="#">Terms of Service</a></li>
                                <li><a href="#">Privacy</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </div>
                        <div class="col-lg-3">
                            <h2 class="footer-heading mb-4">Quick Links</h2>
                            <ul class="list-unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Testimonials</a></li>
                                <li><a href="#">Terms of Service</a></li>
                                <li><a href="#">Privacy</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </div>
                        <div class="col-lg-3">
                            <h2 class="footer-heading mb-4">Quick Links</h2>
                            <ul class="list-unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Testimonials</a></li>
                                <li><a href="#">Terms of Service</a></li>
                                <li><a href="#">Privacy</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row pt-5 mt-5 text-center">
                <div class="col-md-12">
                    <div class="border-top pt-5">
                        <p>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                            All rights reserved | This template is made with <i class="icon-heart text-danger"
                                                                                aria-hidden="true"></i> by <a
                                href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </p>
                    </div>
                </div>

            </div>
        </div>
    </footer>

</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.sticky.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.animateNumber.min.js"></script>
<script src="js/jquery.fancybox.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>
<script src="js/aos.js"></script>
<script src="js/index.js" type="text/javascript"></script>
<script src="js/datepicker.js" type="text/javascript"></script>

<script src="js/main.js"></script>

</body>

</html>

