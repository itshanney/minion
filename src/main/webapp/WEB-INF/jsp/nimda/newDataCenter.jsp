<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-3 col-md-2 sidebar">
            <jsp:include page="/WEB-INF/jsp/nimda/nimdaNavbar.jsp"/>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <h2>Data Centers</h2>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <form class="form-horizontal" role="form" method="POST" action="/m/nimda/dc/create">
                        <div class="form-group">
                            <label for="dataCenterId" class="col-sm-3 control-label">Data Center ID</label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" id="dataCenterId" name="dataCenterId" maxlength="8">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dataCenterName" class="col-sm-3 control-label">Data Center Name</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="dataCenterName" name="dataCenterName">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9 text-left">
                                <button type="submit" class="btn btn-success">Create Data Center</button>
                                <a href="/m/nimda/dc" class="btn btn-default">Cancel</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="/WEB-INF/jsp/includes/footer.jsp" %>