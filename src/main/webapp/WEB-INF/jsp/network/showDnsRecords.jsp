<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-12 col-md-12 col-lg-12">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <p>
                        <a href="<spring:url value="/m/network/dns/new"/>" class="btn btn-success">
                        <span class="glyphicon glyphicon-plus"></span>
                        New DNS Record
                        </a>
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Domain</th>
                            <th>Type</th>
                            <th>Value</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="record" items="${dnsRecords}">
                            <tr>
                                <td><a href="#">${record.name}</a></td>
                                <td>${record.domain.domainName}</td>
                                <td>${record.type}</td>
                                <td>${record.value}</td>
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