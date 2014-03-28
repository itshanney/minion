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
                        <a href="<spring:url value="/m/nimda/type/new"/>" class="btn btn-success">
                            <span class="glyphicon glyphicon-plus"></span>
                            New Server Type
                        </a>
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Type Code</th>
                                <th>Type Name</th>
                                <th>Cores</th>
                                <th>RAM (GB)</th>
                                <th>HDD (GB)</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="type" items="${serverTypes}">
                            <tr>
                                <td><a href="/m/nimda/type/${type.typeId}/edit">${type.typeCode}</a></td>
                                <td>${type.typeName}</td>
                                <td>${type.cpuCores}</td>
                                <td>${type.ramGb}</td>
                                <td>${type.hddGb}</td>
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