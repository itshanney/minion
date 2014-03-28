<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-12 col-md-12 col-lg-12">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <p>
                        <a href="<spring:url value="/m/nimda/dc/new"/>" class="btn btn-success">
                        <span class="glyphicon glyphicon-plus"></span>
                        New Server
                        </a>
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>Hostname</th>
                            <th>Data Center</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="server" items="${servers}">
                            <tr>
                                <td><a href="/m/servers/edit/${server.serverId}/edit">${server.hostname}</a></td>
                                <td>${server.dataCenterId}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="/WEB-INF/jsp/includes/footer.jsp" %>