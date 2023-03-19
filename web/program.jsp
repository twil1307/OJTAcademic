<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/includes/header.jsp"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<head>
    <title>FantasticV - Charity Website</title>
    <link rel="stylesheet" href="css/program.css">

    <style>
        .table-responsive{
            height:400px;  
            overflow:scroll;
            overflow-x:hidden;
            background: white;
        }
        thead tr:nth-child(1) th{
            background: white;
            position: sticky;
            top: 0;
            z-index: 10;
        }
    </style>
</head>

<%@include file="/includes/navbar.jsp"%>

<!-- Carousel Start -->
<div class="carousel" style="background-color: #dcf9fc">
    <div class="container-fluid">
        <div class="owl-carousel">
            <c:forEach items="${program.programImgs}" var="image">
                <div class="carousel-item"> 
                    <div class="carousel-img">
                        <img src="${image.path}" alt="Image" style="max-height: 70vh">
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="program-title row text-light">
        <div class="col-12 text-center">
            <h1>${program.programName}</h1>
            <h3>${program.destination.city} - ${program.destination.province} - ${program.destination.address}</h3>
            <p>${program.shortDes}</p>
        </div>
        <div class="col-12 text-center">
            <p>${program.startDate} <span>-</span> ${program.endDate}</p>
        </div>
    </div>
</div>
<!-- Carousel End -->

<!-- Start Detail Description -->
<div class="container-fluid detail-description">
    <div class="section-header">
        <p class="text-center">Detail Description</p>
    </div>
    <p class="description">
        ${program.detailDes.replaceAll("\\r\\n", "<br>")}
    </p>
    <blockquote class="blockquote">
        <footer class="blockquote-footer">Program Creator</footer>
    </blockquote>
</div>
<!-- End Detail Description -->



<!-- Facts Start -->
<div class="facts" data-parallax="scroll" data-image-src="img/facts.jpg">
    <div class="container">
        <div class="row">         
            <div class="col-lg-6 col-md-12">
                <div class="facts-item justify-content-center">
                    <i class="flaticon-kindness"></i>
                    <div class="facts-text">
                        <h3 class="facts-dollar" data-toggle="counter-up">${program.goalAmount}</h3>
                        <p>Our Goal</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-12">
                <div class="facts-item justify-content-center">
                    <i class="flaticon-donation"></i>
                    <div class="facts-text">
                        <h3 class="facts-dollar" data-toggle="counter-up">${raisedAmount}</h3>
                        <p>Raised</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Facts End -->

<!-- Causes Start -->
<div id="schedule-carousel" class="carousel slide" data-ride="carousel">
    <div class="section-header">
        <p class="text-center">Schedule</p>
    </div>
    <div class="carousel-inner">
        <c:forEach items="${schedules}" var="schedule" varStatus="counter">
            <c:if test="${counter.count % 4 == 0}">
                <div class="carousel-item">
                    <div class="cards-wrapper">
                        <c:forEach begin="0" end="3" step="1" var="i">
                            <c:set var="desc" value="${3 - i}" />
                            <c:set var="schedule" value="${schedules.get(counter.index - desc)}"/>
                            <div class="card">
                                <div class="card-img-top slide" id="schedule-carousel-${counter.index - desc}">
                                    <div class="owl-carousel">
                                        <c:forEach items="${schedule.imgPath}" var="image">
                                            <div class="owl-carousel-item">
                                                <img src="${image.path}" class="d-block w-100" alt="schedule image">
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">${schedule.date}</h5>
                                    <p class="card-text">${schedule.detail_des}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <c:if test="${(
                          (counter.count % 4 != 0) and (counter.count == schedules.size())
                          )}">
                  <div class="carousel-item">
                      <div class="cards-wrapper">
                          <c:set var="size" value="${counter.count % 4}"></c:set>
                          <c:forEach begin="0" end="${size - 1}" step="1" var="i">
                              <c:set var="desc" value="${size - 1 - i}" />
                              <c:set var="schedule" value="${schedules.get(counter.index - desc)}"/>
                              <div class="card"  style="flex-basis: calc(((${size} * 25%) - (${size} - 0.5) * 0.2rem) / ${size}); flex-grow: 0">
                                  <div class="card-img-top slide" id="schedule-carousel-${counter.index - desc}">
                                      <div class="owl-carousel">
                                          <c:forEach items="${schedule.imgPath}" var="image" varStatus="imageIndex">
                                              <div class="owl-carousel-item ${imageIndex.index == 0 ? "active" : ""}">
                                                  <img src="${image.path}" class="d-block w-100" alt="schedule image">
                                              </div>
                                          </c:forEach>
                                      </div>
                                  </div>
                                  <div class="card-body">
                                      <h5 class="card-title">${schedule.date}</h5>
                                      <p class="card-text">${schedule.detail_des}</p>
                                  </div>
                              </div>
                          </c:forEach>
                      </div>
                  </div>
            </c:if>
        </c:forEach> 
    </div>
    <a class="carousel-control-prev" href="#schedule-carousel" role="button" data-slide="prev" id="schedule-carousel-prev-btn">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#schedule-carousel" role="button" data-slide="next" id="schedule-carousel-next-btn">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<!-- Causes End -->


<!-- Donate Start -->
<div class="donate" data-parallax="scroll" data-image-src="img/donate.jpg">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-7">
                <div class="donate-content">
                    <div class="section-header">
                        <p>Donate Now</p>
                        <h2>Let's donate to needy people for better lives</h2>
                    </div>
                    <div class="donate-text">
                        <p>
                            Lorem ipsum dolor sit amet elit. Phasellus nec pretium mi. Curabitur facilisis ornare
                            velit non. Aliquam metus tortor, auctor id gravida, viverra quis sem. Curabitur non nisl
                            nec nisi maximus. Aenean convallis porttitor. Aliquam interdum at lacus non blandit.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-5 text-center">

                <c:choose>
                    <c:when test="${sessionScope.user !=null}">
                        <div class="donate-form">
                            <form  onsubmit="return submitFormPrivate()" method="POST" action="donate?action=request&programId=${program.programId}">
                                <div class="control-group">
                                    <input type="number" class="form-control" name="amount" placeholder="Donate amount" required="required" />
                                    <input type="hidden" class="form-control" name="programName" value="${program.programName}"  required="required" />
                                </div>
                                <div class="control-group">
                                    <textarea class="form-control" id="message" style="height: auto" rows="7" placeholder="Message" name="message" required="required" data-validation-required-message="Please enter your message"></textarea>
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div>
                                    <button class="btn btn-custom" id="privateSubmitBtn" type="submit">Donate Now</button>
                                </div>
                            </form>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <button style="color: white; padding: 0; height: 3em" class="btn btn-custom" type="submit">
                            <a style="width: 100%; height: 100%; color: white; padding: 5em 1em" href="login">
                                Login now to donate

                            </a>
                        </button>
                    </c:otherwise>
                </c:choose>


            </div>
        </div>
    </div>
</div>
<!-- Donate End -->


<!-- Event Start -->
<c:if test="${not empty operators}">
    <div class="event">
        <div class="container">
            <div class="section-header text-center">
                <p>Upcoming Events</p>
                <h2>Be ready for our upcoming charity events</h2>
            </div>
            <div class="row">
                <c:forEach var="item" items="${operators}">
                    <div class="section-header text-center">
                        <p>Operator</p>
                        <h5>${item.operatorDate}</h5>
                    </div>
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
                                    <p><i class="fa fa-map-marker-alt"></i>${destination.city}</p>
                                    <p><i class="fa fa-map-marker-alt"></i>${destination.province}</p>
                                    <p><i class="fa fa-map-marker-alt"></i>${destination.address}</p>
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
                    <div class="col-lg-6" style="margin-bottom: 5em">
                        <div class="event-item" style="height: 100% !important">
                            <div class="carousel" style="margin-bottom: 0">
                                <div class="container-fluid">
                                    <div class="owl-carousel">
                                        <!-- News images -->
                                        <c:forEach items="${item.billImgs}" var="bill">
                                            <div class="owl-carousel-item"> 
                                                <div class="carousel-img">
                                                    <img src="${bill.path}" alt="Image" style="height: 360px; width: 100%">
                                                    <!--<img src="img/event-1.jpg" alt="Image">-->
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="event-content">
                                <div class="event-meta">
                                    <p><i class="fa fa-money-bill"></i>${item.actualExpense}</p>
                                    <p><i class="fa fa-map-marker-alt"></i>${destination.city}</p>
                                    <p><i class="fa fa-map-marker-alt"></i>${destination.province}</p>
                                    <p><i class="fa fa-map-marker-alt"></i>${destination.address}</p>
                                </div>
                                <div class="event-text">
                                    <h3>Bills</h3>
                                    <p>
                                        Total actual Expense here is: 
                                        <span style="font-size: 5em">${item.actualExpense}$</span>
                                    </p>

                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</c:if>

<!-- Event End -->


<!-- Team Start -->
<div class="team">
    <div class="container">
        <div class="section-header text-center">
            <p>Meet Our Team</p>
            <h2>Awesome guys behind our charity activities</h2>
        </div>
        <!-- TODO: Program Creator information -->
        <div class="row justify-content-center">
            <div class="col-lg-3 col-md-6">
                <div class="team-item">
                    <div class="team-img">
                        <img src="${author.avatar}" alt="Team Image">
                    </div>
                    <div class="team-text">
                        <h2>${author.name}</h2>
                        <p>${author.role == 1 ? 'Admin' : 'Manager'} of Fantastic V</p>
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
            <c:forEach var="item" items="${investors}">
                <div class="testimonial-item">
                    <div class="testimonial-profile">
                        <img src="${item.investorImg}" alt="Image">
                        <div class="testimonial-name">
                            <h3>${item.investorName}</h3>
                            <p>Represent: ${item.legalRepresent}</p>
                            <p>Contact: ${item.contact}</p>
                        </div>
                    </div>
                    <div class="testimonial-text">
                        <p>
                            ${item.investorDes}
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<!-- Testimonial End -->

<!-- Blog Start -->
<div class="container">
    <div class="section-header text-center">
        <p>Donation</p>
        <h2>Recently donate</h2>
    </div>
    <div class="table-responsive">
        <table class="table table-hover" id="job-table">
            <thead>
                <tr class="text-center">
                    <th scope="col">No.</th>
                    <th scope="col">Name</th>
                    <th scope="col">Amount</th>
                    <th scope="col-2" colspan="3">Message</th>
                    <th scope="col">At</th>
                </tr>
            </thead>

            <c:set var = "donateNo" value="${1}" />
            <tbody class="text-center tableBody">
                <c:forEach var="item" items="${listDonate}">
                    <tr key={key}>
                        <td class="font-weight-bold">${donateNo}</td>
                        <td class="font-weight-bold"><a href="user?userId=${item.userId}">${item.name}</a> </td>
                        <td>${item.amount}$</td>
                        <td class="font-weight-bold" colspan="3">${item.message}</td>
                        <td>${item.donate_date}</td>
                    </tr>
                    <c:set var = "donateNo" value="${donateNo+1}" />
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!-- Blog End -->    

<!-- Footer Start -->
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="footer-contact">
                    <h2>Our Head Office</h2>
                    <p><i class="fa fa-map-marker-alt"></i>123 Street, New York, USA</p>
                    <p><i class="fa fa-phone-alt"></i>+012 345 67890</p>
                    <p><i class="fa fa-envelope"></i>info@example.com</p>
                    <div class="footer-social">
                        <a class="btn btn-custom" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-custom" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-custom" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-custom" href=""><i class="fab fa-instagram"></i></a>
                        <a class="btn btn-custom" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-link">
                    <h2>Popular Links</h2>
                    <a href="">About Us</a>
                    <a href="">Contact Us</a>
                    <a href="">Popular Causes</a>
                    <a href="">Upcoming Events</a>
                    <a href="">Latest Blog</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-link">
                    <h2>Useful Links</h2>
                    <a href="">Terms of use</a>
                    <a href="">Privacy policy</a>
                    <a href="">Cookies</a>
                    <a href="">Help</a>
                    <a href="">FQAs</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-newsletter">
                    <h2>Newsletter</h2>
                    <form>
                        <input class="form-control" placeholder="Email goes here">
                        <button class="btn btn-custom">Submit</button>
                        <label>Don't worry, we don't spam!</label>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="container copyright">
        <div class="row">
            <div class="col-md-6">
                <p>&copy; <a href="#">Your Site Name</a>, All Right Reserved.</p>
            </div>
            <div class="col-md-6">
                <p>Designed By <a href="https://htmlcodex.com">HTML Codex</a></p>
            </div>
        </div>
    </div>
</div>
<!-- Footer End -->

<!-- Back to top button -->
<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- Pre Loader -->
<div id="loader" class="show">
    <div class="loader"></div>
</div>
<script>
    function submitFormPrivate() {
        document.getElementById("privateSubmitBtn").disabled = true;
        document.getElementById("privateSubmitBtn").style.display = "none";
    }

</script>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/counterup/counterup.min.js"></script>
<script src="lib/parallax/parallax.min.js"></script>

<!-- Contact Javascript File -->
<script src="mail/jqBootstrapValidation.min.js"></script>
<script src="mail/contact.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>
<script src="js/program.js"></script>
</body>

</html>

