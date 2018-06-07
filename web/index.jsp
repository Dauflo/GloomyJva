<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 15/04/2018
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="shortcut icon" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/img/gloomy.jpg">
        <meta name="author" content="codepixer">
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta charset="UTF-8">

        <title>Gloomy</title>

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
        <!-- CSS -->
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

        <!-- start banner Area -->
        <section class="banner-area background-gloomy">
          <div class="container">
            <div class="row head-index d-flex align-items-center justify-content-center ">
              <div class="banner-content col-lg-6 col-md-6">
                <h1>
                  Access your data <br>
                  from anywhere <br>
                  with Gloomy
                </h1>
                <p class="text-white text-uppercase text-contouring">
                  You can breath, we're protecting them for you
                </p>
                  <a href="about.jsp" class="primary-btn header-btn text-uppercase">View Details</a>
              </div>
              <div class=" col-lg-6 col-md-6 banner-content">
                <img class="img-fluid gloomy-img-big flex-right" src="img/banner-img.svg" alt="">
              </div>
            </div>
          </div>
        </section>
        <!-- End banner Area -->

        <!-- start footer Area -->
        <footer class="footer-area section-bottom">
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



