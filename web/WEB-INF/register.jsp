<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 16/04/2018
  Time: 00:07
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

        <title>Gloomy - Register</title>

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

        <section class="section-gap">
            <div class="container">
                <div class="col-md-12 pb-40 header-text text-center head-title">
                    <h3><i>Create a Account on Gloomy</i></h3>
                </div>
                <div class="separation-bar-about"></div>
                <div class="form-center">
                    <div>
                        </p>
                    </div>
                    <div class="center-div-login">
                        <form method="post" action="<%= application.getContextPath() + Register.URL_PATH%>" class="form-area text-right">

                            <div class="input-group-icon mt-10">
                                <div class="icon"><i class="fa fa-address-card-o" aria-hidden="true"></i></div>
                                <input type="text" name="firstname" placeholder="Firstname" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Firstname'" required="" class="single-input">
                            </div>

                            <div class="input-group-icon mt-10">
                                <div class="icon"><i class="fa fa-address-card-o" aria-hidden="true"></i></div>
                                <input type="text" name="lastname" placeholder="Lastname" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Lastname'" required="" class="single-input">
                            </div>

                            <div class="input-group-icon mt-10">
                                <div class="icon"><i class="fa fa-user-circle-o" aria-hidden="true"></i></div>
                                <input type="text" name="username" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'" required="" class="single-input">
                            </div>

                            <div class="input-group-icon mt-10">
                                <div class="icon"><i class="fa fa-at" aria-hidden="true"></i></div>
                                <input type="email" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'" required="" class="single-input">
                            </div>

                            <div class="input-group-icon mt-10">
                                <div class="icon"><i class="fa fa-key" aria-hidden="true"></i></div>
                                <input type="password" name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'" required="" class="single-input">
                            </div>

                            <div class="input-group-icon mt-10">
                                <div class="icon"><i class="fa fa-key" aria-hidden="true"></i></div>
                                <input type="password" name="passwordConf" placeholder="Confirm your Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Confirm your Password'" required="" class="single-input">
                            </div>

                            <div class="end-form-div input-group-icon mt-10">
                                <input class="end-form genric-btn primary circle arrow" type="submit" value="Register" >
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <footer class="footer-area section-bottom footer-register">
            <%@include file="/WEB-INF/footer.jsp"%>
        </footer>

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