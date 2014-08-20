<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Minion - Simple Server Wrangling</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="<spring:url value="/css/bootstrap-3.1.1.css"/>" rel="stylesheet">
    <link href="<spring:url value="/css/minion.css"/>" rel="stylesheet">

    <script type="text/javascript">
        $().ready(function(){
            if("${param['failed']}"=="true"){
                $("#failed").text("Login failed! Incorrect login or password");
            }

            $('#login').focus();
        });
    </script>
</head>

<body>

<div class="container">

    <form class="form-signin" role="form" action="/m/login" method="POST">
        <input id="login" name="j_username" type="text" class="form-control" placeholder="user@email.com" tabindex="1" required autofocus />
        <input id="password" name="j_password" type="password" class="form-control" placeholder="password" tabindex="2" required />
        <button class="btn btn-lg btn-success btn-block" type="submit">Login</button>
    </form>

</div>
</body>

</html>