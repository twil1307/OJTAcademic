<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/includes/header.jsp"%>
<head>
    <title>FantasticV - Charity Website</title>
</head>

<%@include file="/includes/navbar.jsp"%>

<!-- Carousel Start -->
<div class="carousel" style="background-color: #dcf9fc">
    <div class="container-fluid">
        <div class="owl-carousel">
            <div class="carousel-item">
                <div class="carousel-img">
                    <img src="img/carousel-1.jpg" alt="Image">
                </div>
                <div class="carousel-text">
                    <h1>Let's be kind for children</h1>
                    <p>
                        Lorem ipsum dolor sit amet elit. Phasellus ut mollis mauris. Vivamus egestas eleifend dui ac
                        consequat at lectus in malesuada
                    </p>
                    <div class="carousel-btn">
                        <a class="btn btn-custom" href="">Donate Now</a>
                        <a class="btn btn-custom btn-play" data-toggle="modal"
                           data-src="https://www.youtube.com/embed/DWRcNpR6Kdc" data-target="#videoModal">Watch
                            Video</a>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="carousel-img">
                    <img src="img/carousel-2.jpg" alt="Image">
                </div>
                <div class="carousel-text">
                    <h1>Get Involved with helping hand</h1>
                    <p>
                        Morbi sagittis turpis id suscipit feugiat. Suspendisse eu augue urna. Morbi sagittis, orci
                        sodales varius fermentum, tortor
                    </p>
                    <div class="carousel-btn">
                        <a class="btn btn-custom" href="">Donate Now</a>
                        <a class="btn btn-custom btn-play" data-toggle="modal"
                           data-src="https://www.youtube.com/embed/DWRcNpR6Kdc" data-target="#videoModal">Watch
                            Video</a>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="carousel-img">
                    <img src="img/carousel-3.jpg" alt="Image">
                </div>
                <div class="carousel-text">
                    <h1>Bringing smiles to millions</h1>
                    <p>
                        Sed ultrices, est eget feugiat accumsan, dui nibh egestas tortor, ut rhoncus nibh ligula
                        euismod quam. Proin pellentesque odio
                    </p>
                    <div class="carousel-btn">
                        <a class="btn btn-custom" href="">Donate Now</a>
                        <a class="btn btn-custom btn-play" data-toggle="modal"
                           data-src="https://www.youtube.com/embed/DWRcNpR6Kdc" data-target="#videoModal">Watch
                            Video</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Carousel End -->

<!-- Video Modal Start-->
<div class="modal fade" id="videoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <!-- 16:9 aspect ratio -->
                <div class="embed-responsive embed-responsive-16by9">
                    <iframe class="embed-responsive-item" src="" id="video" allowscriptaccess="always"
                            allow="autoplay"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Video Modal End -->


<!-- About Start -->
<div class="about">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6">
                <div class="about-img" data-parallax="scroll" data-image-src="img/about.jpg"></div>
            </div>
            <div class="col-lg-6">
                <div class="section-header">
                    <p>Learn About Us</p>
                    <h2>Worldwide non-profit charity organization</h2>
                </div>
                <div class="about-tab">
                    <ul class="nav nav-pills nav-justified">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="pill" href="#tab-content-1">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="pill" href="#tab-content-2">Mission</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="pill" href="#tab-content-3">Vision</a>
                        </li>
                    </ul>

                    <div class="tab-content">
                        <div id="tab-content-1" class="container tab-pane active">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vitae pellentesque turpis.
                            Donec in hendrerit dui, vel blandit massa. Ut vestibulum suscipit cursus. Cras quis
                            porta nulla, ut placerat risus. Aliquam nec magna eget velit luctus dictum. Phasellus et
                            felis sed purus tristique dignissim. Morbi sit amet leo at purus accumsan pellentesque.
                            Vivamus fermentum nisi vel dapibus blandit. Lorem ipsum dolor sit amet, consectetur
                            adipiscing elit.
                        </div>
                        <div id="tab-content-2" class="container tab-pane fade">
                            Sed tincidunt, magna ut vehicula volutpat, turpis diam condimentum justo, posuere congue
                            turpis massa in mi. Proin ornare at massa at fermentum. Nunc aliquet sed nisi iaculis
                            ornare. Nam semper tortor eget est egestas, eu sagittis nunc sodales. Interdum et
                            malesuada fames ac ante ipsum primis in faucibus. Praesent bibendum sapien sed purus
                            molestie malesuada. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                        </div>
                        <div id="tab-content-3" class="container tab-pane fade">
                            Aliquam dolor odio, mollis sed feugiat sit amet, feugiat ut sapien. Nunc eu dignissim
                            lorem. Suspendisse at hendrerit enim. Interdum et malesuada fames ac ante ipsum primis
                            in faucibus. Sed condimentum semper turpis vel facilisis. Nunc vel faucibus orci. Mauris
                            ut mauris rhoncus, efficitur nisi at, venenatis quam. Praesent egestas pretium enim sit
                            amet finibus. Curabitur at erat molestie, tincidunt lorem eget, consequat ligula.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- About End -->


<!-- Service Start -->
<div class="service">
    <div class="container">
        <div class="section-header text-center">
            <p>What We Do?</p>
            <h2>We believe that we can save more lifes with you</h2>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="service-item">
                    <div class="service-icon">
                        <i class="flaticon-diet"></i>
                    </div>
                    <div class="service-text">
                        <h3>Healthy Food</h3>
                        <p>Lorem ipsum dolor sit amet elit. Phase nec preti facils ornare velit non metus tortor</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="service-item">
                    <div class="service-icon">
                        <i class="flaticon-water"></i>
                    </div>
                    <div class="service-text">
                        <h3>Pure Water</h3>
                        <p>Lorem ipsum dolor sit amet elit. Phase nec preti facils ornare velit non metus tortor</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="service-item">
                    <div class="service-icon">
                        <i class="flaticon-healthcare"></i>
                    </div>
                    <div class="service-text">
                        <h3>Health Care</h3>
                        <p>Lorem ipsum dolor sit amet elit. Phase nec preti facils ornare velit non metus tortor</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="service-item">
                    <div class="service-icon">
                        <i class="flaticon-education"></i>
                    </div>
                    <div class="service-text">
                        <h3>Primary Education</h3>
                        <p>Lorem ipsum dolor sit amet elit. Phase nec preti facils ornare velit non metus tortor</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="service-item">
                    <div class="service-icon">
                        <i class="flaticon-home"></i>
                    </div>
                    <div class="service-text">
                        <h3>Residence Facilities</h3>
                        <p>Lorem ipsum dolor sit amet elit. Phase nec preti facils ornare velit non metus tortor</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="service-item">
                    <div class="service-icon">
                        <i class="flaticon-social-care"></i>
                    </div>
                    <div class="service-text">
                        <h3>Social Care</h3>
                        <p>Lorem ipsum dolor sit amet elit. Phase nec preti facils ornare velit non metus tortor</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Service End -->


<!-- Facts Start -->
<div class="facts" data-parallax="scroll" data-image-src="img/facts.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="facts-item">
                    <i class="flaticon-home"></i>
                    <div class="facts-text">
                        <h3 class="facts-plus" data-toggle="counter-up">150</h3>
                        <p>Countries</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="facts-item">
                    <i class="flaticon-charity"></i>
                    <div class="facts-text">
                        <h3 class="facts-plus" data-toggle="counter-up">400</h3>
                        <p>Volunteers</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="facts-item">
                    <i class="flaticon-kindness"></i>
                    <div class="facts-text">
                        <h3 class="facts-dollar" data-toggle="counter-up">${totalGoal}</h3>
                        <p>Our Goal</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="facts-item">
                    <i class="flaticon-donation"></i>
                    <div class="facts-text">
                        <h3 class="facts-dollar" data-toggle="counter-up">${totalRaised}</h3>
                        <p>Raised</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Facts End -->


<!-- Causes Start -->
<div class="causes">
    <div class="container">
        <div class="section-header text-center">
            <p>Popular Causes</p>
            <h2>Let's know about charity causes around the world</h2>
        </div>
        <div class="owl-carousel causes-carousel">
            <c:forEach var="item" items="${listPrograms}">
                <div class="causes-item">
                    <div class="causes-img">
                        <img src="${item.programDisplayImg}" alt="Image"  style="height: 20em; width: 100%; object-fit: cover;">
                    </div>
                    <div class="causes-progress">
                        <div class="progress">
                            <div class="progress-bar" role="progressbar" aria-valuenow="${(item.raisedAmount/item.goalAmount)*100}" aria-valuemin="0" aria-valuemax="100">
                                <span>${(item.raisedAmount/item.goalAmount)*100 > 100 ? 100 : (item.raisedAmount/item.goalAmount)*100}%</span>
                            </div>
                        </div>
                        <div class="progress-text">
                            <p><strong>Raised:</strong> $${(item.raisedAmount)}</p>
                            <p><strong>Goal:</strong>$${(item.goalAmount)}</p>
                        </div>
                    </div>
                    <div class="causes-text" style="height: 6em">
                        <h3><a href="program?action=detail&programId=${item.programId}">${item.programName}</a></h3>
                        <p>${item.shortDes}</p>
                    </div>
                    <div class="causes-btn" style="padding: 10px">
                        <a href="program?action=detail&programId=${item.programId}" class="btn btn-custom" style="display: flex; justify-content: center; align-items: center">Learn More</a>


                        <c:if test="${sessionScope.user.role=='2' || sessionScope.user.role=='1'}">
                            <a href="program?action=update&programId=${item.programId}" class="btn btn-custom">Update Program</a>
                            <a class="btn btn-custom" href="operator?programId=${item.programId}&action=update">Update Operator</a>
                        </c:if>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>
<!-- Causes End -->




<!-- Event Start -->
<div class="event">
    <div class="container">
        <div class="section-header text-center">
            <p>Upcoming Events</p>
            <h2>Be ready for our upcoming charity events</h2>
        </div>
        <div class="row">
            <c:forEach var="item" items="${operators}">
                <div class="col-lg-6" style="margin-bottom: 5em">
                    <div class="event-item" style="height: 100% !important">
                        <div class="carousel" style="margin-bottom: 0">
                            <div class="container-fluid">
                                <div class="owl-carousel">
                                    <!-- News images -->
                                    <c:forEach items="${item.activiesImgs}" var="activity">
                                        <div class="owl-carousel-item"> 
                                            <div class="carousel-img">
                                                <img src="${activity.path}" alt="Image" style="height: 360px; width: 100%">
                                                <!--<img src="img/event-1.jpg" alt="Image">-->
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="event-content">
                            <div class="event-meta">
                                <p><i class="fa fa-calendar-alt"></i>${item.operatorDate}</p>
                                <p><i class="fa fa-map-marker-alt"></i>${item.city}</p>
                                <p><i class="fa fa-map-marker-alt"></i>${item.province}</p>
                                <p><i class="fa fa-map-marker-alt"></i>${item.address}</p>
                            </div>
                            <div class="event-text">
                                <h3>Activities</h3>
                                <p class="description">
                                    ${item.operatorDetailDes.replaceAll("\\r\\n", "<br>")}
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<!-- Event End -->


<!-- Team Start -->
<div class="team">
    <div class="container">
        <div class="section-header text-center">
            <p>Meet Our Team</p>
            <h2>Awesome guys behind our charity activities</h2>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="team-item">
                    <div class="team-img">
                        <img src="img/team-1.jpg" alt="Team Image">
                    </div>
                    <div class="team-text">
                        <h2>Donald John</h2>
                        <p>Founder & CEO</p>
                        <div class="team-social">
                            <a href=""><i class="fab fa-twitter"></i></a>
                            <a href=""><i class="fab fa-facebook-f"></i></a>
                            <a href=""><i class="fab fa-linkedin-in"></i></a>
                            <a href=""><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="team-item">
                    <div class="team-img">
                        <img src="img/team-2.jpg" alt="Team Image">
                    </div>
                    <div class="team-text">
                        <h2>Adam Phillips</h2>
                        <p>Chef Executive</p>
                        <div class="team-social">
                            <a href=""><i class="fab fa-twitter"></i></a>
                            <a href=""><i class="fab fa-facebook-f"></i></a>
                            <a href=""><i class="fab fa-linkedin-in"></i></a>
                            <a href=""><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="team-item">
                    <div class="team-img">
                        <img src="img/team-3.jpg" alt="Team Image">
                    </div>
                    <div class="team-text">
                        <h2>Thomas Olsen</h2>
                        <p>Chef Advisor</p>
                        <div class="team-social">
                            <a href=""><i class="fab fa-twitter"></i></a>
                            <a href=""><i class="fab fa-facebook-f"></i></a>
                            <a href=""><i class="fab fa-linkedin-in"></i></a>
                            <a href=""><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="team-item">
                    <div class="team-img">
                        <img src="img/team-4.jpg" alt="Team Image">
                    </div>
                    <div class="team-text">
                        <h2>James Alien</h2>
                        <p>Advisor</p>
                        <div class="team-social">
                            <a href=""><i class="fab fa-twitter"></i></a>
                            <a href=""><i class="fab fa-facebook-f"></i></a>
                            <a href=""><i class="fab fa-linkedin-in"></i></a>
                            <a href=""><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="team-item">
                    <div class="team-img">
                        <img src="img/team-4.jpg" alt="Team Image">
                    </div>
                    <div class="team-text">
                        <h2>James Alien</h2>
                        <p>Advisor</p>
                        <div class="team-social">
                            <a href=""><i class="fab fa-twitter"></i></a>
                            <a href=""><i class="fab fa-facebook-f"></i></a>
                            <a href=""><i class="fab fa-linkedin-in"></i></a>
                            <a href=""><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Team End -->

<!-- Testimonial Start -->
<div class="testimonial">
    <div class="container">
        <div class="section-header text-center">
            <p>Testimonial</p>
            <h2>What people are talking about our charity activities</h2>
        </div>
        <div class="owl-carousel testimonials-carousel">
            <div class="testimonial-item">
                <div class="testimonial-profile">
                    <img src="img/testimonial-1.jpg" alt="Image">
                    <div class="testimonial-name">
                        <h3>Person Name</h3>
                        <p>Profession</p>
                    </div>
                </div>
                <div class="testimonial-text">
                    <p>
                        Lorem ipsum dolor sit amet elit. Phasel preti mi facilis ornare velit non vulputa. Aliqu
                        metus tortor, auctor id gravid vivera quis
                    </p>
                </div>
            </div>
            <div class="testimonial-item">
                <div class="testimonial-profile">
                    <img src="img/testimonial-2.jpg" alt="Image">
                    <div class="testimonial-name">
                        <h3>Person Name</h3>
                        <p>Profession</p>
                    </div>
                </div>
                <div class="testimonial-text">
                    <p>
                        Lorem ipsum dolor sit amet elit. Phasel preti mi facilis ornare velit non vulputa. Aliqu
                        metus tortor, auctor id gravid vivera quis
                    </p>
                </div>
            </div>
            <div class="testimonial-item">
                <div class="testimonial-profile">
                    <img src="img/testimonial-3.jpg" alt="Image">
                    <div class="testimonial-name">
                        <h3>Person Name</h3>
                        <p>Profession</p>
                    </div>
                </div>
                <div class="testimonial-text">
                    <p>
                        Lorem ipsum dolor sit amet elit. Phasel preti mi facilis ornare velit non vulputa. Aliqu
                        metus tortor, auctor id gravid vivera quis
                    </p>
                </div>
            </div>
            <div class="testimonial-item">
                <div class="testimonial-profile">
                    <img src="img/testimonial-4.jpg" alt="Image">
                    <div class="testimonial-name">
                        <h3>Person Name</h3>
                        <p>Profession</p>
                    </div>
                </div>
                <div class="testimonial-text">
                    <p>
                        Lorem ipsum dolor sit amet elit. Phasel preti mi facilis ornare velit non vulputa. Aliqu
                        metus tortor, auctor id gravid vivera quis
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Testimonial End -->

<!-- Blog Start -->
<div class="blog">
    <div class="container">
        <div class="section-header text-center">
            <p>Our Blog</p>
            <h2>Latest news & articles directly from our blog</h2>
        </div>
        <div class="row">
            <c:forEach var="item" items="${getListNews}">
                <div class="col-lg-4">
                    <div class="blog-item">
                        <div class="blog-img">
                            <img src="${item.backGroundImg}" alt="Image">
                        </div>
                        <div class="blog-text">
                            <h3><a href="news?action=single&newsId=${item.newsId}">${item.newsTitle}</a></h3>
                            <p>
                                ${item.shortDes}
                            </p>
                        </div>
                        <div class="blog-meta">
                            <p><i class="fa fa-user"></i><a href="news?action=single&newsId=${item.newsId}">Watch more</a></p>

                            <c:if test="${sessionScope.user.role=='2' || sessionScope.user.role=='1'}">
                                <p><i class="fa fa-wrench"></i><a href="news?action=update&newsId=${item.newsId}">Edit News</a></p>

                                <form method="POST" id="delete-news-${item.newsId}" action="news-manage?action=delete&newsId=${item.newsId}" style="padding-left: 2em">
                                    <p onclick="document.getElementById(`delete-news-${item.newsId}`).submit()">
                                        <i class="fa fa-times"></i>
                                        <a onclick="document.getElementById(`delete-news-${item.newsId}`).submit()">Delete News</a>
                                    </p>
                                </form>

                            </c:if>

                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>
<!-- Blog End -->    



<%@include file="/includes/footer.jsp"%>
