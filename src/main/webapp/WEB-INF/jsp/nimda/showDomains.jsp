<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-3 col-md-2 sidebar">
            <jsp:include page="/WEB-INF/jsp/nimda/nimdaNavbar.jsp"/>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <p>
                        <a href="<spring:url value="/m/nimda/domain/new"/>" class="btn btn-success">
                        <span class="glyphicon glyphicon-plus"></span>
                        New Domain
                        </a>
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>Domain Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="domain" items="${domains}">
                            <tr>
                                <td><a href="/m/nimda/domain/${domain.domainId}/edit">${domain.domainName}</a></td>
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