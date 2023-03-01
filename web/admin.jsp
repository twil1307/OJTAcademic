<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/includes/header.jsp"%>
<head>
    <title>Admin Page</title>
    <style>
        .navbar {
            background: #20212B !important;
        }
        .navbar-nav .nav-link,
        .navbar-nav .nav-link:focus,
        .navbar-nav .nav-link:hover,
        .navbar-nav .nav-link.active {
            color: #ffffff;
        }
    </style>
</head>

<body style="background-color: #dcf9fc">
    
    <!-- Top Bar Start -->
    <div class="top-bar d-none d-md-block">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-8">
                    <a href="index.jsp" class="navbar-brand">FANTASTICV</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
                <div class="col-md-4">
                    <div class="top-bar-right">
                        <div class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Hello Admin <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Log Out</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Top Bar End -->

    <!-- Nav Bar Start -->
    <div class="navbar navbar-expand-lg navbar-dark">
        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
            <div class="navbar-nav">
                <a href="dashboard.jsp" class="nav-item nav-link">Dashboard</a>
                <a href="charities.jsp" class="nav-item nav-link">Charities</a>
                <a href="delcharities.jsp" class="nav-item nav-link">Delete Charities</a>
                <a href="censorContent.jsp" class="nav-item nav-link">Censor Content</a>
                <a href="manageEmployee.jsp" class="nav-item nav-link">Manage Employee Account</a>
            </div>
        </div>
    </div>    
    <!-- Nav Bar End -->
</body>






