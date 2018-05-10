<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <title>Insert title here</title>

    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta name="google-signin-client_id" content="947353537310-fieofubb16lojooivoisohvm2gm5mef0.apps.googleusercontent.com">
</head>

 

<body>


<div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>

<img id="myImg"><br>
<p id="name"></p> 


<div id="status">
</div>

<script type="text/javascript">
    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        var imagurl=profile.getImageUrl();
        var name=profile.getName();
        var email=profile.getEmail();
        var id_token = googleUser.getAuthResponse().id_token;
        console.log(id_token);
        document.getElementById("myImg").src = imagurl;
        document.getElementById("name").innerHTML = name;

        document.getElementById("myP").style.visibility = "hidden";


        document.getElementById("status").innerHTML = 'Welcome '+name+'!<a href=success.jsp?email='+email+'&name='+name+'/>Continue with Google login</a></p>'

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

        f.appendChild(i);
        f.appendChild(s);

        document.getElementsByTagName('body')[0].appendChild(f);

        //window.location.href='success.jsp?email='+email+'&name='+name;
    }
</script>
 
                                     
 


<button onclick="myFunction()">Sign Out</button>

<script>
    function myFunction() {
        gapi.auth2.getAuthInstance().disconnect();
        location.reload();
    }
</script>
 


</body>
</html>