<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-3 col-md-2 sidebar">
            <jsp:include page="/WEB-INF/jsp/nimda/nimdaNavbar.jsp"/>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <form class="form-horizontal" role="form" method="POST" action="/m/nimda/domain/create">
                        <div class="form-group">
                            <label for="domainName" class="col-sm-3 control-label">Domain Name</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="domainName" name="domainName">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9 text-left">
                                <button type="submit" class="btn btn-success">Create Domain</button>
                                <a href="/m/nimda/domains" class="btn btn-default">Cancel</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="/WEB-INF/jsp/includes/footer.jsp" %>