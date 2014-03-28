<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-3 col-md-2 sidebar">
            <jsp:include page="/WEB-INF/jsp/nimda/nimdaNavbar.jsp"/>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <form class="form-horizontal" role="form" method="POST" action="/m/nimda/type/update">
                        <div class="form-group">
                            <label for="typeCode" class="col-sm-3 control-label">Type Code</label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" id="typeCode" name="typeCode" maxlength="16" value="${serverType.typeCode}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="typeName" class="col-sm-3 control-label">Type Name</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="typeName" name="typeName" value="${serverType.typeName}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cpuCores" class="col-sm-3 control-label">CPU Cores</label>
                            <div class="col-sm-1">
                                <input type="text" class="form-control" id="cpuCores" name="cpuCores" value="${serverType.cpuCores}" placeholder="2">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ramGb" class="col-sm-3 control-label">RAM (GB)</label>
                            <div class="col-sm-1">
                                <input type="text" class="form-control" id="ramGb" name="ramGb" value="${serverType.ramGb}" placeholder="8.0">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="hddGb" class="col-sm-3 control-label">HDD (GB)</label>
                            <div class="col-sm-1">
                                <input type="text" class="form-control" id="hddGb" name="hddGb" value="${serverType.hddGb}" placeholder="100.0">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9 text-left">
                                <input type="hidden" name="typeId" value="${serverType.typeId}"/>
                                <button type="submit" class="btn btn-success">Edit Server Type</button>
                                <a href="/m/nimda/types" class="btn btn-default">Cancel</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="/WEB-INF/jsp/includes/footer.jsp" %>