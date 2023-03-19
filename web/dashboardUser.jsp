<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <title>Flash Able - Most Trusted Admin Template</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="description" content="Flash Able Bootstrap admin template made using Bootstrap 4 and it has huge amount of ready made feature, UI components, pages which completely fulfills any dashboard needs." />
        <meta name="keywords" content="admin templates, bootstrap admin templates, bootstrap 4, dashboard, dashboard templets, sass admin templets, html admin templates, responsive, bootstrap admin templates free download,premium bootstrap admin templates, Flash Able, Flash Able bootstrap admin template">
        <meta name="author" content="Codedthemes" />

        <!-- Favicon icon -->
        <link rel="icon" href="./assets/images/favicon.ico" type="image/x-icon">
        <!-- fontawesome icon -->
        <link rel="stylesheet" href="./assets/fonts/fontawesome/css/fontawesome-all.min.css">
        <!-- animation css -->
        <link rel="stylesheet" href="./assets/plugins/animation/css/animate.min.css">

        <!-- vendor css -->
        <link rel="stylesheet" href="./assets/css/dashboard-style.css">
    </head>

    <body class="">
        <!-- [ Pre-loader ] start -->
        <div class="loader-bg">
            <div class="loader-track">
                <div class="loader-fill"></div>
            </div>
        </div>
        <!-- [ Pre-loader ] End -->

        <!-- [ navigation menu ] start -->
        <nav class="pcoded-navbar menupos-fixed menu-light brand-blue ">
            <div class="navbar-wrapper ">
                <div class="navbar-brand header-logo">
                    <a href="home" class="b-brand" style="color: white">
                        FANTASTIC V
                    </a>
                    <!--                    <a class="mobile-menu" id="mobile-collapse" href="#!"><span></span></a>-->
                </div>
                <div class="navbar-content scroll-div">
                    <ul class="nav pcoded-inner-navbar">
                        <li class="nav-item pcoded-menu-caption">
                            <label>Navigation</label>
                        </li>
                        <li class="nav-item">
                            <a href="dashboard?action=donation" class="nav-link"><span class="pcoded-micon"><i class="feather icon-home"></i></span><span class="pcoded-mtext">Donation</span></a>
                        </li>
                        <li class="nav-item">
                            <a href="dashboard?action=user" class="nav-link"><span class="pcoded-micon"><i class="feather icon-user"></i></span><span class="pcoded-mtext">User</span></a>
                        </li>
                         <li class="nav-item">
                            <a href="dashboard?action=contact" class="nav-link"><span class="pcoded-micon"><i class="feather icon-message-circle"></i></span><span class="pcoded-mtext">Message</span></a>
                        </li>

                    </ul>

                </div>
            </div>
        </nav>
        <!-- [ navigation menu ] end -->

        <!-- [ Header ] start -->
        <header class="navbar pcoded-header navbar-expand-lg navbar-light headerpos-fixed">

        </header>
        <!-- [ Header ] end -->

        <!-- [ Main Content ] start -->
        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <div class="pcoded-content">
                    <div class="pcoded-inner-content">
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- [ breadcrumb ] start -->
                                <div class="page-header">
                                    <div class="page-block">
                                        <div class="row align-items-center">
                                            <div class="col-md-12">
                                                <div class="page-header-title">
                                                    <h5>Users</h5>
                                                </div>
                                                <ul class="breadcrumb">
                                                    <li class="breadcrumb-item"><a href="index.html"><i class="feather icon-home"></i></a></li>
                                                    <li class="breadcrumb-item"><a>Users Analytics</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- [ breadcrumb ] end -->
                                <!-- [ Main Content ] start -->
                                <div class="row">

                                    <!-- product profit start -->
                                    <div class="col-xl-6 col-md-6">
                                        <div class="card prod-p-card bg-c-red">
                                            <div class="card-body">
                                                <div class="row align-items-center m-b-25">
                                                    <div class="col">
                                                        <h6 class="m-b-5 text-white">Total users on page</h6>
                                                        <h3 class="m-b-0 text-white">${listUser.size()}</h3>
                                                    </div>
                                                    <div class="col-auto">
                                                        <i class="fas fa-user text-c-red f-18"></i>
                                                    </div>
                                                </div>
                                                <!--                                                <p class="m-b-0 text-white"><span class="label label-danger m-r-10">+11%</span>From Previous Month</p>-->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-md-6">
                                        <div class="card prod-p-card bg-c-blue">
                                            <div class="card-body">
                                                <div class="row align-items-center m-b-25">
                                                    <div class="col">
                                                        <h6 class="m-b-5 text-white">Total managers</h6>
                                                        <h3 class="m-b-0 text-white">${managerNumber}</h3>
                                                    </div>
                                                    <div class="col-auto">
                                                        <i class="fas fa-wrench text-c-blue f-18"></i>
                                                    </div>
                                                </div>
                                                <!--<p class="m-b-0 text-white"><span class="label label-primary m-r-10">+12%</span>From Previous Month</p>-->
                                            </div>
                                        </div>
                                    </div>
           
                                    <div class="col-xl-12 col-md-6">
                                        <div class="card table-card">
                                            <div class="card-header">
                                                <h5>Programs Status</h5>
                                            </div>
                                            <div class="card-body px-0 py-0">
                                                <div class="table-responsive">
                                                    <div class="session-scroll" style="height:478px;position:relative;">
                                                        <table class="table table-hover m-b-0">
                                                            <thead>
                                                                <tr>
                                                                    <th><span>NO</span></th>
                                                                    <th><span>ACCOUNT ID</span></th>
                                                                    <th><span>USERNAME<a class="help" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>
                                                                    <th><span>EMAIL <a class="help" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>
                                                                    <th><span>PHONE NUMBER<a class="help" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>
                                                                    <th><span>ADDRESS<a class="help" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>
                                                                    <th><span>BANK ACCOUNT <a class="help" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>
                                                                    <th><span>STATUS<a class="help" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>

                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:choose>
                                                                    <c:when test="${not empty listUser}">
                                                                        <c:set var = "userNo" value="${1}" />
                                                                        <c:forEach var="item" items="${listUser}">
                                                                            <tr>
                                                                                <td>${userNo}</td>
                                                                                <td>${item.accountId}</td>
                                                                                <td>${item.username}</td>
                                                                                <td>${item.email}</td>
                                                                                <td>${item.phoneNumber} </td>
                                                                                <td>${item.city} - ${item.province} - ${item.address}</td>
                                                                                <td>${item.bank_account}</td>
                                                                                <td style="padding-top: 0.6em">
                                                                                    <div class="mt-1" >
                                                                                        <c:if test="${item.role == 3}">
                                                                                            <form method="POST" action="/OJT_Mock/user-manage?action=manager">
                                                                                                <input  type="hidden" class="form-control"  name="accountId"  value="${item.accountId}" >
                                                                                                <button class="btn btn-success btn-sm text-white m-0" type="submit">ENABLE MANAGER</button>
                                                                                            </form>
                                                                                        </c:if>
                                                                                        <c:if test="${item.role == 2}">
                                                                                            <form method="POST" action="/OJT_Mock/user-manage?action=user">
                                                                                                <input  type="hidden" class="form-control"  name="accountId"  value="${item.accountId}" >
                                                                                                <button class="btn btn-danger btn-sm text-white m-0" type="submit">DISABLE MANAGER</button>
                                                                                            </form>
                                                                                        </c:if>

                                                                                    </div>
                                                                                </td>
                                                                            </tr>
                                                                            <c:set var = "userNo" value="${userNo+1}" />
                                                                        </c:forEach>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <tr><td>There is no user yet</td></tr>
                                                                    </c:otherwise>
                                                                </c:choose>





                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- sessions-section end -->

                                </div>

                                <!-- [ Main Content ] end -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="./assets/js/vendor-all.min.js"></script>
        <script src="./assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="./assets/js/pcoded.min.js"></script>

    </body>

</html>