<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-3 main">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <form class="form-horizontal" role="form" method="POST" action="/m/network/dns/create">
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">Name</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="domainId" class="col-sm-3 control-label">Domain</label>
                            <div class="col-sm-4">
                                <select class="form-control" name="domainId" id="domainId">
                                    <c:forEach var="domain" items="${domains}">
                                        <option value="${domain.domainId}">${domain.domainName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="type" class="col-sm-3 control-label">Type</label>
                            <div class="col-sm-2">
                                <select class="form-control" name="type" id="type">
                                    <option value="A">A</option>
                                    <option value="CNAME">CNAME</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="value" class="col-sm-3 control-label">Value</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="value" name="value">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9 text-left">
                                <button type="submit" class="btn btn-success">Create DNS Record</button>
                                <a href="/m/network/dns" class="btn btn-default">Cancel</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="/WEB-INF/jsp/includes/footer.jsp" %>