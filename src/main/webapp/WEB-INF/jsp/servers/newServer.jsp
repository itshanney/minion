<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-3 main">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <form class="form-horizontal" role="form" method="POST" action="/m/servers/create">
                        <div class="form-group">
                            <label for="hostname" class="col-sm-3 control-label">Hostname</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="hostname" name="hostname" maxlength="16">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dataCenter" class="col-sm-3 control-label">Data Center</label>
                            <div class="col-sm-3">
                                <select class="form-control" name="dataCenter" id="dataCenter">
                                <c:forEach var="dc" items="${dataCenters}">
                                    <option value="${dc.dataCenterId}">${dc.dataCenterId} - ${dc.dataCenterName}</option>
                                </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="serverType" class="col-sm-3 control-label">Server Type</label>
                            <div class="col-sm-2">
                                <select class="form-control" name="serverType" id="serverType">
                                <c:forEach var="serverType" items="${serverTypes}">
                                    <option value="${serverType.typeId}">${serverType.typeCode}</option>
                                </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="operatingSystem" class="col-sm-3 control-label">Operating System</label>
                            <div class="col-sm-3">
                                <select class="form-control" name="operatingSystem" id="operatingSystem">
                                <c:forEach var="os" items="${operatingSystems}">
                                    <option value="${os.operatingSystemId}">${os.operatingSystemName}</option>
                                </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9 text-left">
                                <button type="submit" class="btn btn-success">Create Server</button>
                                <a href="/m/servers" class="btn btn-default">Cancel</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="/WEB-INF/jsp/includes/footer.jsp" %>