<%--
  Created by IntelliJ IDEA.
  User: antoi
  Date: 23/05/2018
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon-->
    <link rel="shortcut icon" type="image/jpg" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/img/gloomy.jpg">
    <!-- Author Meta -->
    <meta name="author" content="codepixer">
    <!-- Meta Description -->
    <meta name="description" content="">
    <!-- Meta Keyword -->
    <meta name="keywords" content="">
    <!-- meta character set -->
    <meta charset="UTF-8">
    <!-- Site Title -->
    <title>Gloomy - Contact</title>

    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
    <!--
    CSS
    ============================================= -->
    <link rel="stylesheet" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/css/linearicons.css">
    <link rel="stylesheet" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/css/magnific-popup.css">
    <link rel="stylesheet" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/css/nice-select.css">
    <link rel="stylesheet" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/css/hexagons.min.css">
    <link rel="stylesheet" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/css/animate.min.css">
    <link rel="stylesheet" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/css/owl.carousel.css">
    <link rel="stylesheet" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/css/main.css">
</head>
<body>
<header id="header" id="home">
    <%@include file="/WEB-INF/header.jsp"%>
</header>

<!-- Start contact-page Area -->
<section class="contact-page-area section-gap">
    <div class="container ">
        <div class="col-md-12 pb-40 header-text text-center head-title">
            <h3><i>Contact Us</i></h3>
        </div>
        <div class="separation-bar-about"></div>
        <div class="row text-center">
            <div class="map-wrap" style="width:100%; height: 445px;" id="map"></div>
            <div class="separation-bar-about"></div>
            <div class="inline-input">
                <div class="single-contact-address d-flex flex-row align-contact">
                    <div class="icon">
                        <span class="lnr lnr-home"></span>
                    </div>
                    <div class="contact-details">
                        <h5>Troyes, France</h5>
                        <p>1 Boulevard Charles Baltet</p>
                    </div>
                </div>
                <div class="single-contact-address d-flex flex-row align-contact">
                    <div class="icon">
                        <span class="lnr lnr-envelope"></span>
                    </div>
                    <div class="contact-details">
                        <h5>gloomy.entreprise@gmail.com</h5>
                        <p>Send us your query anytime!</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End contact-page Area -->

<!-- start footer Area -->
<footer class="footer-area section-bottom footer-contact">
    <%@include file="/WEB-INF/footer.jsp"%>
</footer>
<!-- End footer Area -->

<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/vendor/jquery-2.2.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/vendor/bootstrap.min.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/easing.min.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/hoverIntent.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/superfish.min.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/jquery.ajaxchimp.min.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/jquery.magnific-popup.min.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/owl.carousel.min.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/hexagons.min.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/jquery.nice-select.min.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/jquery.counterup.min.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/waypoints.min.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/mail-script.js"></script>
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/main.js"></script>
</body>
</html>



