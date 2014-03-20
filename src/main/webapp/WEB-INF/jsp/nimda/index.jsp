<%@include file="/WEB-INF/jsp/includes/header.jsp" %>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="#">Server Types</a></li>
                <li class="active"><a href="#">Operating Systems</a></li>
                <li><a href="#">Data Centers</a></li>
            </ul>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 text-right">
                    <p>
                    <a href="#" class="btn btn-success">
                        <span class="glyphicon glyphicon-plus"></span>
                        New Server
                    </a>
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Operating System</th>
                                <th>Family</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>CentOS 6.3</td>
                                <td>Linux</td>
                            </tr>
                            <tr>
                                <td>CentOS 6.4</td>
                                <td>Linux</td>
                            </tr>
                            <tr>
                                <td>Windows Server 2008</td>
                                <td>Windows</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="/WEB-INF/jsp/includes/footer.jsp" %>