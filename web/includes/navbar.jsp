<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<body style="background-color: #dcf9fc">

    <!-- Nav Bar Start -->
    <div class="navbar navbar-expand-lg bg-dark navbar-dark">
        <div class="container-fluid">
            <a href="index.jsp" class="navbar-brand">FANTASTIC5</a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                <div class="navbar-nav ml-auto">
                    <a href="home" class="nav-item nav-link">Home</a>
                    <a href="about.jsp" class="nav-item nav-link">About</a>
                    <a href="program?action=list" class="nav-item nav-link">Program</a>
                    <a href="news?action=list" class="nav-item nav-link">News</a>
<!--                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                        <div class="dropdown-menu">
                            <a href="detail.jsp" class="dropdown-item">Detail Page</a>
                            <a href="service.jsp" class="dropdown-item">What We Do</a>
                            <a href="team.jsp" class="dropdown-item">Meet The Team</a>
                            <a href="donate.jsp" class="dropdown-item">Donate Now</a>
                            <a href="volunteer.html" class="dropdown-item">Become A Volunteer</a>
                        </div>
                    </div>-->
                    <c:if test="${sessionScope.user !=null}">
                        <a href="contact" class="nav-item nav-link">Contact</a>

                    </c:if>
                </div>

                <div class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user"></i>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <c:choose>
                            <c:when test="${sessionScope.user !=null}">
                                <a class="dropdown-item" href="user?userId=${sessionScope.user.accountId}">${sessionScope.user.getName()}</a>

                                <c:if test="${sessionScope.user.role=='2'}">
                                    <a class="dropdown-item" href="program?action=register">Create program</a>
                                    <a class="dropdown-item" href="/OJT_Mock/news-manage">Create news</a>
                                </c:if>
                                <c:if test="${sessionScope.user.role=='1'}">
                                    <a class="dropdown-item" href="dashboard?action=donation">Dashboard</a>
                                </c:if>
                                <a class="dropdown-item" href="logout">Log out</a>

                            </c:when>
                            <c:otherwise>
                                <a class="dropdown-item" href="login">Log in</a>
                                <a class="dropdown-item" href="signup">Sign Up</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Nav Bar End -->
