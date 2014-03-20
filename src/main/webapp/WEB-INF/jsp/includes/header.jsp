<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Minion</title>
        <link href="<spring:url value="/css/bootstrap-3.1.1.css"/>" rel="stylesheet">
        <link href="<spring:url value="/css/minion.css"/>" rel="stylesheet">
        <script src="<spring:url value="/js/jquery-1.11.0.min.js"/>"></script>
        <script src="<spring:url value="/js/bootstrap-3.1.1.js"/>"></script>
        <style>
            body {
                padding-top: 50px;
            }
        </style>
    </head>

    <body>

        <jsp:include page="/WEB-INF/jsp/includes/navbar.jsp" />
