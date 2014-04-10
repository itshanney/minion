<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-3 col-md-2 sidebar">
            <jsp:include page="/WEB-INF/jsp/network/networkNavbar.jsp"/>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <p>
                        <a href="<spring:url value="/m/network/cert/new"/>" class="btn btn-success">
                        <span class="glyphicon glyphicon-plus"></span>
                        New Certificate
                        </a>
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>Certificate Name</th>
                            <th>Domain Name</th>
                            <th>Create Date</th>
                            <th>Expiration Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cert" items="${sslCertificates}">
                            <tr>
                                <td><a href="/m/network/cert/${cert.certificateId}/edit">${cert.certificateName}</a></td>
                                <td>${cert.domain.domainName}</td>
                                <td>${cert.createDate}</td>
                                <td>${cert.expirationDate}</td>
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