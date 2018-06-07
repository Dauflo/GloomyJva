<%@ page import="com.gloomy.servlet.Login" %>
<%@ page import="com.gloomy.servlet.Register" %>
<%@ page import="com.gloomy.servlet.Main" %>
<%@ page import="com.gloomy.servlet.Logout" %><%--
  Created by IntelliJ IDEA.
  User: antoi
  Date: 21/05/2018
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container main-menu">
    <div class="row align-items-center justify-content-between d-flex">
        <div id="logo">
            <a href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/#"><img src="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/img/banner-img.svg" alt="" title="" class="gloomy-img"/></a>
        </div>
        <nav id="nav-menu-container">
            <ul class="nav-menu">
                <li class="menu-active"><a href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/#">Home</a></li>
                <li><a href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/about.jsp">About Us</a></li>
                <li><a href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()%>/contact.jsp">Contact</a></li>
                <% if (session.getAttribute("user") == null){%>
                    <li><a href="<%=request.getContextPath()+Login.URL_PATH%>">Log in</a></li>
                    <li><a href="<%=request.getContextPath()+Register.URL_PATH%>">Register</a></li>
                <%}else{%>
                    <li><a href="<%=request.getContextPath()+Main.URL_PATH%>">My account</a></li>
                    <li><a href="<%=request.getContextPath()+Logout.URL_PATH%>">Logout</a></li>
                <%}%>
                </li>

            </ul>
        </nav><!-- #nav-menu-container -->
    </div>
</div>
