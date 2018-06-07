<%--
  Created by IntelliJ IDEA.
  User: antoi
  Date: 31/05/2018
  Time: 15:49
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
    <title>Gloomy - About Us</title>

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

<!-- Start feature Area -->
<section class="feature-area section-gap">
    <div class="container">
        <div class="col-md-12 pb-40 header-text text-center head-title">
            <h3><i>Our most Important Features</i></h3>
        </div>
        <div class="separation-bar-about"></div>

        <div class="row">

            <div class="col-lg-4 col-md-6">
                <div class="single-feature">
                    <a href="#" class="title d-flex flex-row">
                        <span class="lnr lnr-cloud"></span>
                        <h4>Cloud system</h4>
                    </a>
                    <p>
                        You can access your data and download it from anywhere                    </p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-feature">
                    <a href="#" class="title d-flex flex-row">
                        <span class="lnr lnr-file-empty"></span>
                        <h4>Big files</h4>
                    </a>
                    <p>
                        You can store files up to 1 GB, whatever their format is: Video, Audio, etc..                    </p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-feature">
                    <a href="#" class="title d-flex flex-row">
                        <span class="lnr lnr-layers"></span>
                        <h4>Organize your storage</h4>
                    </a>
                    <p>
                        It is possible to create multiple subfolders to sort your files and improve your navigation                    </p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-feature">
                    <a href="#" class="title d-flex flex-row">
                        <span class="lnr lnr-users"></span>
                        <h4>File and folder sharing</h4>
                    </a>
                    <p>
                        you can easily share your files and your folders with colleagues or friends to allow them to download or open the files                    </p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-feature">
                    <a href="#" class="title d-flex flex-row">
                        <span class="lnr lnr-picture"></span>
                        <h4>Previewing Pictures</h4>
                    </a>
                    <p>
                        Access an online preview of your pictures without having to download them on your computer                    </p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-feature">
                    <a href="#" class="title d-flex flex-row">
                        <span class="lnr lnr-bubble"></span>
                        <h4>A team to your listening</h4>
                    </a>
                    <p>
                        We carry out a constant follow-up and are at your disposal in case of questions or proposals of improvement.                    </p>
                </div>
            </div>

        </div>
    </div>
</section>

<!-- start footer Area -->
<footer class="footer-area section-bottom footer-about">
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



