<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
                                                    <h5>Home</h5>
                                                </div>
                                                <ul class="breadcrumb">
                                                    <li class="breadcrumb-item"><a href="index.html"><i class="feather icon-home"></i></a></li>
                                                    <li class="breadcrumb-item"><a href="#!">Analytics Dashboard</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- [ breadcrumb ] end -->
                                <!-- [ Main Content ] start -->
                                <div class="row">

                                    <!-- product profit start -->
                                    <div class="col-xl-3 col-md-6">
                                        <div class="card prod-p-card bg-c-red">
                                            <div class="card-body">
                                                <div class="row align-items-center m-b-25">
                                                    <div class="col">
                                                        <h6 class="m-b-5 text-white">Total donate today</h6>
                                                        <h3 class="m-b-0 text-white">$<fmt:formatNumber type = "number" 
                                                                          groupingUsed = "false" value = "${totalToday}" /></h3>
                                                    </div>
                                                    <div class="col-auto">
                                                        <i class="fas fa-money-bill-alt text-c-red f-18"></i>
                                                    </div>
                                                </div>
                                                <!--                                                <p class="m-b-0 text-white"><span class="label label-danger m-r-10">+11%</span>From Previous Month</p>-->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xl-3 col-md-6">
                                        <div class="card prod-p-card bg-c-blue">
                                            <div class="card-body">
                                                <div class="row align-items-center m-b-25">
                                                    <div class="col">
                                                        <h6 class="m-b-5 text-white">Total donate this month</h6>
                                                        <h3 class="m-b-0 text-white">$<fmt:formatNumber type = "number" 
                                                                          groupingUsed = "false" value = "${totalThisMonth}" /></h3>
                                                    </div>
                                                    <div class="col-auto">
                                                        <i class="fas fa-database text-c-blue f-18"></i>
                                                    </div>
                                                </div>
                                                <!--<p class="m-b-0 text-white"><span class="label label-primary m-r-10">+12%</span>From Previous Month</p>-->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xl-3 col-md-6">
                                        <div class="card prod-p-card bg-c-green">
                                            <div class="card-body">
                                                <div class="row align-items-center m-b-25">
                                                    <div class="col">
                                                        <h6 class="m-b-5 text-white">Total donate</h6>
                                                        <h3 class="m-b-0 text-white">$<fmt:formatNumber type = "number" 
                                                                          groupingUsed = "false" value = "${totalAll}" /></h3>
                                                    </div>
                                                    <div class="col-auto">
                                                        <i class="fas fa-dollar-sign text-c-green f-18"></i>
                                                    </div>
                                                </div>
                                                <!--<p class="m-b-0 text-white"><span class="label label-success m-r-10">+52%</span>From Previous Month</p>-->
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xl-3 col-md-6">
                                        <div class="card prod-p-card bg-c-yellow">
                                            <div class="card-body">
                                                <div class="row align-items-center m-b-25">
                                                    <div class="col">
                                                        <h6 class="m-b-5 text-white">Number of program in process</h6>
                                                        <h3 class="m-b-0 text-white">${avaiablePrograms}</h3>
                                                    </div>
                                                    <div class="col-auto">
                                                        <i class="fas fa-tags text-c-yellow f-18"></i>
                                                    </div>
                                                </div>
                                                <!--<p class="m-b-0 text-white"><span class="label label-warning m-r-10">+52%</span>From Previous Month</p>-->
                                            </div>
                                        </div>
                                    </div>
                                    <!-- product profit end -->
                                    <div class="col-md-12 col-xl-6">
                                        <div class="card card-social">
                                            <div class="card-block border-bottom">
                                                <div class="row align-items-center justify-content-center">
                                                    <div class="col-auto">
                                                        <span style="display: flex; flex-direction: row">
                                                            <i class="fas fa-money-bill-alt text f-18" style="margin: 2px 5px 0 0"></i>
                                                            <h4>Total calling amount of closed program</h4>
                                                        </span>

                                                    </div>
                                                    <div class="col text-right">
                                                        <h3><fmt:formatNumber type = "number" 
                                                                          groupingUsed = "false" value = "${totalCalledAmountClose}" />$</h3>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card-block">
                                                <div class="row align-items-center justify-content-center card-active">
                                                    <div class="col-12">
                                                        <h6 class="text-center m-b-10"><span class="text-muted m-r-5">Target:</span><fmt:formatNumber type = "number" 
                                                                          groupingUsed = "false" value = "${totalActualAmountClose}" />$</h6>
                                                        <div class="progress">
                                                            <div class="progress-bar progress-c-blue" role="progressbar" style="${(totalCalledAmountClose/totalActualAmountClose) * 100}%;height:6px;" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-xl-6">
                                        <div class="card card-social">
                                            <div class="card-block border-bottom">
                                                <div class="row align-items-center justify-content-center">
                                                    <div class="col-auto">
                                                        <span style="display: flex; flex-direction: row">
                                                            <i class="fas fa-money-bill-alt text f-18" style="margin: 2px 5px 0 0"></i>
                                                            <h4>Total calling amount of processing program</h4>
                                                        </span>

                                                    </div>
                                                    <div class="col text-right">
                                                        <h3>
                                                            <fmt:formatNumber type = "number" 
                                                                              groupingUsed = "false" value = "${totalCalledAmountOpen}" />
                                                            $
                                                        </h3>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card-block">
                                                <div class="row align-items-center justify-content-center card-active">

                                                    <div class="col-12">
                                                        <h6 class="text-center  m-b-10"><span class="text-muted m-r-5">Target:</span>
                                                            <fmt:formatNumber type = "number" 
                                                                              groupingUsed = "false" value = "${totalActualAmountOpen}" />

                                                            $</h6>
                                                        <div class="progress">
                                                            <div class="progress-bar progress-c-green" role="progressbar" style="width:${totalActualAmountOpen == 0 ? 0 : (totalCalledAmountOpen/totalActualAmountOpen)*100}%;height:6px;" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- sessions-section start -->
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
                                                                    <th><span>PROGRAM NAME</span></th>
                                                                    <th><span>CITY </span></th>
                                                                    <th><span>PROVINCE</span></th>
                                                                    <th><span>ADDRESS</span></th>

                                                                    <th><span>RAISE DATE</span></th>
                                                                    <th><span>GOAL AMOUNT </span></th>
                                                                    <th><span>RAISED</span></th>
                                                                    <th><span>PROCESS</span></th>
                                                                    <th><span>STATUS<a class="help" data-toggle="popover" title="Popover title" data-content="When you reopen the closed program, It will just be opened until 00:00AM the next day!!"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>

                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:choose>
                                                                    <c:when test="${not empty programs}">
                                                                        <c:set var = "programNo" value="${1}" />
                                                                        <jsp:useBean id="now" class="java.util.Date"/>
                                                                        <c:forEach var="item" items="${programs}">
                                                                            <tr>
                                                                                <td>${programNo}</td>
                                                                                <td><a href="program?action=detail&programId=${item.programId}&isClosed=${item.isClosed}">${item.programName}</a></td>
                                                                                <td>${item.destination.city}</td>
                                                                                <td>${item.destination.province}</td>
                                                                                <td>${item.destination.address} </td>
                                                                                <td>${item.startDate} - ${item.endDate}</td>
                                                                                <td><fmt:formatNumber type = "number" 
                                                                                                  groupingUsed = "false" value = "${(item.goalAmount)}" />$</td>
                                                                                <td><fmt:formatNumber type = "number" 
                                                                                                  groupingUsed = "false" value = "${item.raisedAmount}" />$</td>
                                                                                <td>${(item.raisedAmount / item.goalAmount) * 100}%
                                                                                    <div class="progress mt-1" style="height:4px;">
                                                                                        <div class="progress-bar bg-warning rounded" role="progressbar" style="width: ${(item.raisedAmount / item.goalAmount) * 100}%;" aria-valuenow="${(item.raisedAmount / item.goalAmount) * 100}" aria-valuemin="0" aria-valuemax="100"></div>
                                                                                    </div>
                                                                                </td>
                                                                                <td style="padding-top: 0.6em">
                                                                                    <div class="mt-1" >
                                                                                        <c:if test="${item.isClosed == 'FALSE'}">
                                                                                            <form method="POST" action="/OJT_Mock/program?action=close">
                                                                                                <input  type="hidden" class="form-control"  name="programId"  value="${item.programId}" >
                                                                                                <button class="btn btn-danger btn-sm text-white m-0" type="submit">CLOSE</button>
                                                                                            </form>
                                                                                        </c:if>
                                                                                        <c:if test="${item.isClosed == 'TRUE'}">
                                                                                            <form method="POST" action="/OJT_Mock/program?action=open">
                                                                                                <input  type="hidden" class="form-control"  name="programId"  value="${item.programId}" >


                                                                                                <c:choose>
                                                                                                    <c:when test="${item.isOutDate == 'TRUE'}">
                                                                                                        <button class="btn btn-success btn-sm text-white m-0" type="submit" disabled>OPEN</button>
                                                                                                    </c:when>
                                                                                                    <c:otherwise>
                                                                                                        <button class="btn btn-success btn-sm text-white m-0" type="submit">OPEN</button>
                                                                                                    </c:otherwise>
                                                                                                </c:choose>


                                                                                            </form>
                                                                                        </c:if>

                                                                                    </div>
                                                                                </td>
                                                                            </tr>
                                                                            <c:set var = "programNo" value="${programNo+1}" />
                                                                        </c:forEach>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <tr>There is no program yet</tr>
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

                                    <!-- sessions-section start -->
                                    <div class="col-xl-12 col-md-6">
                                        <div class="card table-card">
                                            <div class="card-header">
                                                <h5>Donation Log</h5>
                                            </div>
                                            <div class="card-body px-0 py-0">
                                                <div class="table-responsive">
                                                    <div class="session-scroll" style="height:478px;position:relative;">
                                                        <table class="table table-hover m-b-0">
                                                            <thead>
                                                                <tr>
                                                                    <th><span>NO</span></th>
                                                                    <th><span>NAME </span></th>
                                                                    <th><span>AMOUNT <a class="help" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>
                                                                    <th><span>PROGRAM <a class="help" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>
                                                                    <th style="text-align: center"><span>MESSAGE <a class="help" data-toggle="popover" title="Popover title" data-content="When you reopen the closed program, It will just be opened until 00:00AM the next day!!"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>
                                                                    <th style="text-align: center"><span >AT <a class="help" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?"><i
                                                                                    class="feather icon-help-circle f-16"></i></a></span></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>

                                                                <c:choose>
                                                                    <c:when test="${not empty donations}">
                                                                        <c:set var = "donateNo" value="${1}" />
                                                                        <c:forEach var="item" items="${donations}">
                                                                            <tr>
                                                                                <td>${donateNo}</td>
                                                                                <td>${item.name}</td>
                                                                                <td>${item.amount}$</td>
                                                                                <td>${item.programName}</td>
                                                                                <td style="text-align: center">${item.message}</td>
                                                                                <td style="text-align: center">${item.donate_date}</td>
                                                                            </tr>

                                                                            <c:set var = "donateNo" value="${donateNo+1}" />
                                                                        </c:forEach>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <tr>
                                                                            <td colspan="5">Number is less than or equal to 10.</td>
                                                                        </tr>
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