<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 16/04/2018
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx" class="no-js short-page">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/img/gloomy.jpg">
    <meta name="author" content="codepixer">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta charset="UTF-8">
    <meta name="google-signin-client_id" content="947353537310-fieofubb16lojooivoisohvm2gm5mef0.apps.googleusercontent.com">

    <title>Gloomy - Google Log In</title>

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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>


</head>

<body class="short-page middle-center">
<header id="header" id="home">
    <%@include file="/WEB-INF/header.jsp"%>
</header>
<section class="section-gap center-one" >
    <div class="container">
        <div class="col-md-12 pb-40 header-text text-center head-title">
            <h3><i>Log in with your Google Account</i></h3>
        </div>
        <div class="separation-bar-about"></div>
        <div class="form-center ">
            <div class="center-div-login text-center middle-center">


                <div class="g-signin2" data-onsuccess="onSignIn" id="myP">

                </div>

                <img id="myImg">
                <div class="br-add"></div>
                <p id="name" class="text-black"></p>


                <div id="status">
                </div>

                <script type="text/javascript">

                    function onSignIn(googleUser) {
                        var profile = googleUser.getBasicProfile();
                        var imagurl=profile.getImageUrl();
                        var name=profile.getName();
                        var id_token = googleUser.getAuthResponse().id_token;
                        console.log(id_token);
                        document.getElementById("myImg").src = imagurl;

                        document.getElementById("myP").style.visibility = "hidden";


                        document.getElementById("status").innerHTML = 'Welcome <strong>'+name+'</strong> !</p>'

                        var f = document.createElement("form");
                        f.setAttribute('method',"post");
                        f.setAttribute('action',"/googleconnection/login");

                        var i = document.createElement("input"); //input element, text
                        i.setAttribute('type',"hidden");
                        i.setAttribute('name',"token");
                        i.setAttribute("value", id_token);

                        var s = document.createElement("input"); //input element, Submit button
                        s.setAttribute('type',"submit");
                        s.setAttribute('value',"Continue to gloomy");
                        s.setAttribute('class',"end-form genric-btn primary circle arrow");

                        f.appendChild(i);
                        f.appendChild(s);

                        document.getElementsByClassName('little-div')[0].appendChild(f);
                        document.getElementsByClassName('br-add').appendChild(document.createElement("br"));
                        document.getElementsByClassName('br-add').appendChild(document.createElement("br"));
                    }
                </script>
                <div class="little-div">

                </div>

                <div class="separation-div">
                    OR
                </div>

                <button onclick="myFunction()" class="end-form genric-btn danger circle arrow">Sign Out</button>
            </div>
        </div>
    </div>
</section>

<script>
    function myFunction() {
        gapi.auth2.getAuthInstance().disconnect();
        location.reload();
    }

    document.getElementById("google-co").style.width = "120px";
    document.getElementById("google-co").style.marginLeft = "auto";
    document.getElementById("google-co").style.marginRight = "auto";
</script>


<footer class="footer-area section-bottom short-footer short-footer-google-login">
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
<script src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/js/main.js"></script


</body>
</html>