<%@page import="model.Utente" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="usr" class="model.Utente" scope="request"/>

<!-- Test if user is logged -->
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
                        Logged as
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
        <div class="ftco-cover-1 overlay" style="background-image: url('images/hero_1.jpg')">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-5">
                        <div class="feature-car-rent-box-1"
                             style="overflow-y:scroll;
                                    min-width: 300px;
                                    min-height: 200px;
                                    max-width: 800px;
                                    max-height: 600px;">
                            <c:choose>
                                <c:when test="${car==null}">
                                    <form action="newCar" method="get">
                                        <h3>Add Car</h3>
                                        <ul class="list-unstyled-editable">
                                            <li>
                                                <label>Costruttore</label>
                                                <input type="text" placeholder="Costruttore" class="form-control"
                                                       id="costruttore" name="costruttore">
                                            </li>
                                            <li>
                                                <label>Modello</label>
                                                <input type="text" class="form-control" id="modello" name="modello"
                                                       placeholder="Modello">
                                            </li>
                                            <li>
                                                <label>Targa</label>
                                                <input type="text" class="form-control" id="targa" name="targa"
                                                       placeholder="Targa">
                                            </li>
                                            <li>
                                                <label>Anno di costruzione</label>
                                                <input type="text" class="form-control" id="costruzione" name="anno"
                                                       placeholder="Anno di costruzione">
                                            </li>
                                            <li>
                                                <label>Prezzo</label>
                                                <input type="text" class="form-control" id="prezzo" name="prezzo"
                                                       placeholder="prezzo in $">
                                            </li>
                                            <li>
                                                <label>URL immagine</label>
                                                <input type="url" class="form-control" id="url" name="url"
                                                       placeholder="url immagine">
                                            </li>
                                            <li>
                                                <form>
                                                    <fieldset>
                                                        <legend>Tipologia Veicolo</legend>
                                                        <select id="select" name="ruolo" required>
                                                            <c:forEach items="${categorieVeicoli}" var="cat">
                                                                <option value="${cat.id}">${cat.tipologia}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </fieldset>
                                                </form>
                                            </li>
                                            <div class="d-flex align-items-center bg-light p-3">
                                                <input type="submit" value="Submit"
                                                       class="btn btn-primary btn-block login-form">
                                            </div>
                                        </ul>
                                    </form>
                                </c:when>
                              <c:otherwise>
                                  <form action="newCar" method="get">
                                      <h3>Add Car</h3>
                                      <ul class="list-unstyled-editable">
                                          <li>
                                              <label>Costruttore</label>
                                              <input type="text"  class="form-control"
                                                     id="costruttore1" name="costruttore" value="${car.costruttore}">
                                          </li>
                                          <li>
                                              <label>Modello</label>
                                              <input type="text" class="form-control" id="modello1" name="modello"
                                                    value="${car.modello}">
                                          </li>
                                          <li>
                                              <label>Targa</label>
                                              <input type="text" class="form-control" id="targa1" name="targa"
                                                      value="${car.targa}">
                                          </li>
                                          <li>
                                              <label>Anno di costruzione</label>
                                              <input type="text" class="form-control" id="costruzione1" name="anno"
                                                      value="${car.annoCostruzione}">
                                          </li>
                                          <li>
                                              <label>Prezzo</label>
                                              <input type="text" class="form-control" id="prezzo1" name="prezzo"
                                                     placeholder="prezzo in $" value="${car.prezzo}">
                                          </li>
                                          <li>
                                              <label>URL immagine</label>
                                              <input type="url" class="form-control" id="url1" name="url"
                                                     placeholder="url immagine" value="${car.urlImg}">
                                          </li>
                                          <li>
                                              <form>
                                                  <fieldset>
                                                      <legend>Tipologia Veicolo</legend>
                                                      <select id="select1" name="ruolo" required value="${car.tipologia.tipologia}">
                                                          <c:forEach items="${categorieVeicoli}" var="cat">
                                                              <option value="${cat.id}">${cat.tipologia}</option>
                                                          </c:forEach>
                                                      </select>
                                                  </fieldset>
                                              </form>
                                          </li>
                                          <div class="d-flex align-items-center bg-light p-3">
                                              <input type="submit" value="Submit"
                                                     class="btn btn-primary btn-block login-form">
                                          </div>
                                      </ul>
                                  </form>
                              </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
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

<script src="js/main.js"></script>

</body>

</html>

