<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="usr" class="model.Utente" scope="request"/>
<jsp:useBean id="car" class="model.Veicoli" scope="session"/>

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
                    <c:if test="${utente==null}">
                        <div class="col-lg-5">
                            <div class="feature-car-rent-box-1">
                                <h3>Login</h3>
                                <ul class="list-unstyled">
                                    <li>
                                        <label>Username</label>
                                        <input type="text" placeholder="username" class="form-control" id="username"
                                               name="username" required>
                                    </li>
                                    <li>
                                        <label>Password</label>
                                        <input type="password" class="form-control" id="password" name="password"
                                               placeholder="Password" required>
                                    </li>
                                </ul>
                                <div id="login-result"></div>
                                <div class="d-flex align-items-center bg-light p-3">
                                    <button type="submit" onclick="login()"
                                            class="btn btn-primary btn-block login-form">Sign in
                                    </button>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${utente.ruolo.descrizione=='Admin'}">
                        <c:if test="${!prenotazioniInAttesa.isEmpty()}">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="feature-car-rent-box-1">
                                        <label>Prenotazioni in attesa di conferma</label>
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th scope="col">Nome</th>
                                                <th scope="col">Cognome</th>
                                                <th scope="col">Veicolo</th>
                                                <th scope="col">Targa</th>
                                                <th scope="col">Data prenotazione</th>
                                                <th scope="col">Data inizio noleggio</th>
                                                <th scope="col">Data fine noleggio</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${prenotazioniInAttesa}" var="book">
                                                <tr>
                                                    <th scope="row">${book.utente.nome}</th>
                                                    <td>${book.utente.cognome}</td>
                                                    <td>${book.veicolo.costruttore} ${book.veicolo.modello}</td>
                                                    <td>${book.veicolo.targa}</td>
                                                    <td>${book.dataPrenotazione}</td>
                                                    <td>${book.dataInizio}</td>
                                                    <td>${book.dataFine}</td>
                                                    <td style="padding: 1rem;">
                                                        <div class="row" style="padding: 0.5rem;">
                                                            <div class="col-lg-">
                                                                <form action="booking" method="get">
                                                                    <input type="submit" value="Approve" name="state"
                                                                           class="btn btn-primary" id="button1"/>
                                                                    <input type="hidden" value="${book.id}"
                                                                           name="bookId"/>
                                                                </form>
                                                            </div>
                                                            <div class="col-lg-4">
                                                                <form action="booking" method="get">
                                                                    <input type="submit" value="Reject" name="state"
                                                                           class="btn btn-danger" id="button2"/>
                                                                    <input type="hidden" value="${book.id}"
                                                                           name="bookId"/>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="feature-car-rent-box-1">
                                    <label>Storico prenotazioni confermate</label>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th scope="col">Nome</th>
                                            <th scope="col">Cognome</th>
                                            <th scope="col">Veicolo</th>
                                            <th scope="col">Targa</th>
                                            <th scope="col">Data prenotazione</th>
                                            <th scope="col">Data inizio noleggio</th>
                                            <th scope="col">Data fine noleggio</th>
                                            <th scope="col">Stato</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${storicoPrenotazioni}" var="book">
                                            <tr>
                                                <th scope="row">${book.utente.nome}</th>
                                                <td>${book.utente.cognome}</td>
                                                <td>${book.veicolo.costruttore} ${book.veicolo.modello}</td>
                                                <td>${book.veicolo.targa}</td>
                                                <td>${book.dataPrenotazione}</td>
                                                <td>${book.dataInizio}</td>
                                                <td>${book.dataFine}</td>
                                                <td>${book.stato}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>


    <div class="site-section section-3" style="background-image: url('images/hero_2.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center mb-5">
                    <h2 class="text-white">Our services</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4">
                    <div class="service-1">
              <span class="service-1-icon">
                <span class="flaticon-car-1"></span>
              </span>
                        <div class="service-1-contents">
                            <h3>Repair</h3>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="service-1">
              <span class="service-1-icon">
                <span class="flaticon-traffic"></span>
              </span>
                        <div class="service-1-contents">
                            <h3>Car Accessories</h3>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="service-1">
              <span class="service-1-icon">
                <span class="flaticon-valet"></span>
              </span>
                        <div class="service-1-contents">
                            <h3>Own a Car</h3>
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

