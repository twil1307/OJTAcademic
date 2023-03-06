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
                    <a href="index.jsp" class="nav-item nav-link">Home</a>
                    <a href="about.jsp" class="nav-item nav-link">About</a>
                    <a href="causes.jsp" class="nav-item nav-link">Causes</a>
                    <a href="event.jsp" class="nav-item nav-link">Events</a>
                    <a href="blog.jsp" class="nav-item nav-link">Blog</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                        <div class="dropdown-menu">
                            <a href="detail.jsp" class="dropdown-item">Detail Page</a>
                            <a href="service.jsp" class="dropdown-item">What We Do</a>
                            <a href="team.jsp" class="dropdown-item">Meet The Team</a>
                            <a href="donate.jsp" class="dropdown-item">Donate Now</a>
                            <a href="volunteer.html" class="dropdown-item">Become A Volunteer</a>
                        </div>
                    </div>
                    <a href="contact.jsp" class="nav-item nav-link">Contact</a>
                </div>

                <div class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user"></i>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <c:choose>
                            <c:when test="${sessionScope.user !=null}">
                                <a class="dropdown-item" href="">${sessionScope.user.getName()}</a>

                                <c:if test="${sessionScope.user.role=='2' || sessionScope.user.role=='1'}">
                                    <a class="dropdown-item" href="">Create program</a>
                                    <a class="dropdown-item" href="/OJT_Mock/news-create">Create news</a>
                                </c:if>
                                    <c:if test="${sessionScope.user.role=='1'}">
                                    <a class="dropdown-item" href="">Admin</a>
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
