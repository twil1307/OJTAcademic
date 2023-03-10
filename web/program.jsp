<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/includes/header.jsp"%>
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
            <div class="col-lg-5">
                <div class="donate-form">
                    <form method="POST" action="donate?action=request&programId=${program.programId}">
                        <div class="control-group">
                            <input type="number" class="form-control" name="amount" placeholder="Donate amount" required="required" />
                            <input type="hidden" class="form-control" name="programName" value="${program.programName}"  required="required" />

                        </div>
                        <div class="control-group">
                            <textarea class="form-control" id="message" style="height: auto" rows="7" placeholder="Message" name="message" required="required" data-validation-required-message="Please enter your message"></textarea>
                            <p class="help-block text-danger"></p>
                        </div>
                        <div>
                            <button class="btn btn-custom" type="submit">Donate Now</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Donate End -->


<!-- Event Start -->
<div class="event">
    <div class="container">
        <div class="section-header text-center">
            <p>Upcoming Events</p>
            <h2>Be ready for our upcoming charity events</h2>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="event-item">
                    <img src="img/event-1.jpg" alt="Image">
                    <div class="event-content">
                        <div class="event-meta">
                            <p><i class="fa fa-calendar-alt"></i>01-Jan-45</p>
                            <p><i class="far fa-clock"></i>8:00 - 10:00</p>
                            <p><i class="fa fa-map-marker-alt"></i>New York</p>
                        </div>
                        <div class="event-text">
                            <h3>Lorem ipsum dolor sit</h3>
                            <p>
                                Lorem ipsum dolor sit amet elit. Neca pretim miura bitur facili ornare velit non
                                vulpte liqum metus tortor
                            </p>
                            <a class="btn btn-custom" href="">Join Now</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="event-item">
                    <img src="img/event-2.jpg" alt="Image">
                    <div class="event-content">
                        <div class="event-meta">
                            <p><i class="fa fa-calendar-alt"></i>01-Jan-45</p>
                            <p><i class="far fa-clock"></i>8:00 - 10:00</p>
                            <p><i class="fa fa-map-marker-alt"></i>New York</p>
                        </div>
                        <div class="event-text">
                            <h3>Lorem ipsum dolor sit</h3>
                            <p>
                                Lorem ipsum dolor sit amet elit. Neca pretim miura bitur facili ornare velit non
                                vulpte liqum metus tortor
                            </p>
                            <a class="btn btn-custom" href="">Join Now</a>
                        </div>
                    </div>
                </div>
            </div>
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
                        <td class="font-weight-bold">${item.name}</td>
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
<%@include file="/includes/footer.jsp"%>
