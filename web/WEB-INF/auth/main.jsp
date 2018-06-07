<%--
  Created by IntelliJ IDEA.
  User: alois
  Date: 16/04/2018
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zxx" class="no-js">
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
        <div class="col-md-12 pb-40 header-text text-center head-title">
            <h3><i>Welcome in your storage, <i class="section-main-name"><c:out value="${user.getFirstname()}"/></i></i></h3>
        </div>
        <div class="separation-bar-about"></div>
        <div>
            <c:if test="${!user.isGoogleFacebookUser()}">
                <a href="/auth/gloomyauth/updateprofil" class="genric-btn primary-border circle">Update Profil</a>
            </c:if>
        </div>
    </section>

<%-- UPLOAD FILE --%>
    <section class="section-gap">
        <div class="progress-table add-file">
            <div class="form-center">
                <div class="center-div-login">
                    <form method="post" action="/auth/uploadfile" enctype="multipart/form-data">
                        <h5>Upload a file</h5><br/>
                        <div class="little-div">
                            <input type="file" name="file" id="file-2" class="inputfile inputfile-2" data-multiple-caption="{count} files selected" multiple="">
                            <label for="file-2"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"></path></svg> <span>Choose a file…</span></label>
                        </div>
                        <div class="little-div">
                            <label class="no-padding no-margin">
                                <select class="nice-select" tabindex="0" name="category">
                                    <option value="0">No directory</option>
                                    <c:forEach items="${directories}" var="directory">
                                        <option value="${directory.getId()}" class="option selected focus"><c:out value="${directory.getName()}"/></option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>
                        <div class="little-div">
                            <input type="hidden" value="0" name="currentDirID"/>
                            <input class="end-form genric-btn primary circle arrow" type="submit" value="Upload" >
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

<%-- DISPLAY FILES--%>
    <div class="section-top-border">
        <div class="progress-table">
            <div class="dir-path"> Files in Root ></div>
            <div class="table-head">
                <div class="file-picture"></div>
                <div class="file-name">Name</div>
                <div class="file-id">Id</div>
                <div class="file-rename">Rename</div>
                <div class="file-see">View</div>
                <div class="file-download">Download</div>
                <div class="file-delete">Delete</div>
            </div>
            <c:forEach items="${files}" var="file">
            <div class="table-row">
                <div class="file-picture"><i class="fa fa-file-o"></i></div>
                <div class="file-name"><c:out value="${file.getName()}"/></div>
                <div class="file-id"><c:out value="${file.getId()}"/></div>
                <div class="file-rename">
                    <form method="post" action="/auth/updatefilename">
                        <input type="text" name="newName" required/>
                        <input type="hidden" value="${file.getId()}" name="id"/>
                        <input type="submit" class="genric-btn primary small" value="Update"/>
                    </form>
                </div>

                <!-- Visualisation -->
                <div class="file-see">
                    <form method="get" action="/auth/openfile">
                        <input type="hidden" value="${file.getId()}" name="id"/>
                        <input type="submit" class="genric-btn primary small" value="View"/>
                    </form>
                </div>

                <div class="file-download">
                    <form method="get" action="/auth/downloadfile">
                        <input type="hidden" value="${file.getId()}" name="id"/>
                        <input type="submit" class="genric-btn primary small" value="Download"/>
                    </form>
                </div>

                <div class="file-delete">
                    <form method="post" action="/auth/deletefile">
                        <input type="hidden" value="${file.getId()}" name="id">
                        <input type="submit" class="genric-btn primary small" value="Delete">
                    </form>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>


    <%-- ADD DIRECTORY --%>
    <section class="section-gap">
        <div class="progress-table add-file">
            <div class="form-center">
                <div class="center-div-login">
                    <form method="post" action="/auth/addDirectory">
                        <h5>Create a new directory</h5><br/>
                        <input type="text" name="directory" placeholder="Name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Name'" required class="single-input-reverse">
                        <input type="hidden" value="0" name="rootDirId">
                        <br/>
                        <input class="end-form genric-btn primary circle arrow" type="submit" value="Add" >
                    </form>
                </div>
            </div>
        </div>
    </section>


    <%-- DISPLAY FOLDERS --%>
    <div class="section-top-border">
        <div class="progress-table">
            <div class="dir-path"> Folders in Root ></div>
            <div class="table-head">
                <div class="dir-picture"></div>
                <div class="dir-name">Name</div>
                <div class="dir-see">See</div>
                <div class="dir-delete">Delete</div>
            </div>
            <c:forEach items="${directories}" var="directory">
                <div class="table-row">
                    <div class="dir-picture"><i class="fa fa-folder"></i></div>
                    <div class="dir-name"><c:out value="${directory.getName()}"/></div>
                    <div class="dir-see">
                        <form method="post" action="/auth/directorydetail">
                            <input type="hidden" value="${directory.getId()}" name="id">
                            <input type="submit" class="genric-btn primary small" value="See" />
                        </form>
                    </div>
                    <div class="dir-delete">
                        <form method="post" action="/auth/deletedir">
                            <input type="hidden" value="${directory.getId()}" name="id">
                            <input type="submit" class="genric-btn primary small" value="Delete" />
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <br/>

    <footer class="footer-area section-bottom">
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

    /* This part is from a tutorial on Tympanus.com */

    var inputs = document.querySelectorAll( '.inputfile' );
    Array.prototype.forEach.call( inputs, function( input )
    {
        var label	 = input.nextElementSibling,
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



