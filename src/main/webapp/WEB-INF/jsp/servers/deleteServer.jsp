<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-3 main">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <form:form cssClass="form-horizontal" role="form" method="POST" action="/m/servers/delete">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Hostname</label>
                            <div class="col-sm-3">
                                <form:input path="hostname" cssClass="form-control" maxlength="16" disabled="true" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9 text-left">
                                <form:hidden path="serverId"/>
                                <button type="submit" class="btn btn-danger">Delete Server</button>
                                <a href="/m/servers" class="btn btn-default">Cancel</a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="/WEB-INF/jsp/includes/footer.jsp" %>