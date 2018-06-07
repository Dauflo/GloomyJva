<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 14/05/2018
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js" id="share-html">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/img/gloomy.jpg">
    <meta name="author" content="codepixer">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta charset="UTF-8">

    <title>Gloomy - Account</title>

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



<section class="section-main-1">
    <div class="container">
        <div class="col-md-12 pb-40 header-text text-center head-title">
            <h3>Directory : <i><c:out value="${directory.getName()}"/></i></h3>
            <h3>Belong to : <i><c:out value="${directory.getUser().getFirstname()}"/> <c:out value="${directory.getUser().getLastname()}"/></i></h3>
        </div>
        <div class="separation-bar-about"></div>

        <p id="test"></p>
    </div>
</section>

    <div>
<%-- DISPLAY FILE --%>
        <div class="section-top-border">
            <div class="progress-table">
                <div class="dir-path"> Files in <c:out value="${directory.getName()}"/> ></div>
                <div class="table-head">
                    <div class="file-picture-share"></div>
                    <div class="file-name-share">Name</div>
                    <div class="file-id-share">Id</div>
                    <div class="file-see-share">View</div>
                    <div class="file-download-share">Download</div>
                </div>
                <c:forEach items="${files}" var="file">
                    <div class="table-row">
                        <div class="file-picture-share"><i class="fa fa-file-o"></i></div>
                        <div class="file-name-share"><c:out value="${file.getName()}"/></div>
                        <div class="file-id-share"><c:out value="${file.getId()}"/></div>

                        <!-- Visualisation -->
                        <div class="file-see-share">
                            <form method="get" action="/auth/openfile">
                                <input type="hidden" value="${file.getId()}" name="id"/>
                                <input type="submit" class="genric-btn primary small" value="View"/>
                            </form>
                        </div>

                        <div class="file-download-share">
                            <form method="get" action="/auth/downloadfile">
                                <input type="hidden" value="${file.getId()}" name="id"/>
                                <input type="submit" class="genric-btn primary small" value="Download"/>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

    <%-- DISPLAY DIRECTORY --%>
        <div class="section-top-border">
            <div class="progress-table">
                <div class="dir-path"> Folders in <c:out value="${directory.getName()}"/> ></div>
                <div class="table-head">
                    <div class="dir-picture-share"></div>
                    <div class="dir-name-share">Name</div>
                    <div class="dir-see-share">See</div>
                </div>
                <c:forEach items="${directories}" var="subDirectory">
                    <div class="table-row">
                        <div class="dir-picture-share"><i class="fa fa-folder"></i></div>
                        <div class="dir-name-share"><c:out value="${subDirectory.getName()}"/></div>
                        <div class="dir-see-share">
                            <form method="post" action="/auth/directorydetail">
                                <input type="hidden" value="${subDirectory.getId()}" name="id">
                                <input type="submit" class="genric-btn primary small" value="See" />
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <footer class="footer-area section-bottom" id="footer-resp">
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

    <script>
        // Gestion responsif de la page
        var winHeight = window.innerHeight;
        var footer = document.getElementById("footer-resp");

        if(parseInt(winHeight) > parseInt(footer.getBoundingClientRect().bottom)){

            footer.style.position = "absolute";
            footer.style.bottom = 0;
            footer.style.width = "100%"
        }
    </script>

    <script>

        /* This part is from a tutorial on Tympanus.com */

        var inputs = document.querySelectorAll( '.inputfile' );
        Array.prototype.forEach.call( inputs, function( input )
        {
            var label    = input.nextElementSibling,
                labelVal = label.innerHTML;

            input.addEventListener( 'change', function( e )
            {
                var fileName = '';
                if( this.files && this.files.length > 1 )
                    fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
                else
                    fileName = e.target.value.split( '\\' ).pop();

                if( fileName )
                    label.querySelector( 'span' ).innerHTML = fileName;
                else
                    label.innerHTML = labelVal;
            });
        });

    </script>
</body>
</html>
