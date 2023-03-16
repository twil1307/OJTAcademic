<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/includes/header.jsp"%>
<head>
    <title>Causes</title>
</head>

<%@include file="/includes/navbar.jsp"%>

<!-- Page Header Start -->
<div class="page-header">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2>Popular Causes</h2>
            </div>
            <div class="col-12">
                <a href="home">Home</a>
                <a href="">Program List</a>
            </div>
        </div>
    </div>
</div>
<!-- Page Header End -->

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


<!-- Causes Start -->
<div class="causes">
    <div class="container">
        <div class="section-header text-center">
            <p>Popular Causes</p>
            <h2>Let's know about charity causes around the world</h2>
        </div>
        <div class="row d-flex justify-content-center mb-5">
            <div class="col-md-12">
                <div class="card p-3  py-4">
                    <h5>An Easier way to find program</h5>
                    <form method="GET" action="program?action=list">
                        <div class="row g-3 mt-2">

                            <div class="col-md-10">
                                <input type="text" class="form-control" name="condition_programName" value="${param.condition_programName}" placeholder="Enter program name" style="height: 100%">
                            </div>
                            <div class="col-md-2">
                                <button type="submit" class="btn btn-custom btn-block">Search</button>
                            </div>
                        </div>
                        <div class="mt-3">
                            <a data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
                               aria-controls="collapseExample" class="advanced">
                                Advance Search With Filters <i class="fa fa-angle-down"></i>
                            </a>
                            <div class="collapse" id="collapseExample">
                                <div class="card card-body">
                                    <div class="row">
                                        <input type="hidden" name="action" value="${param.action}">
                                        <div class="col-md-4">
                                            <input type="text" placeholder="Search by place" name="condition_placeName" value="${param.condition_placeName}" class="form-control">
                                        </div>
                                        <div class="col-md-4">
                                            <input type="text" class="form-control" name="condition_investorName" value="${param.condition_investorName}" placeholder="Search by Investor">
                                        </div>
                                        <div class="col-md-4">
                                            <input type="text" class="form-control" name="condition_authorName" value="${param.condition_authorName}" placeholder="Search by Author">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach var="item" items="${listProgram}">
                <div class="col-lg-4" style="margin-bottom:2em; width: 100%">
                    <div class="chairy-item" style="background-color: white">
                        <div class="blog-img">
                            <img src="${item.programDisplayImg}" alt="Image"  style="height: 20em; width: 100%; object-fit: cover;">
                        </div>
                        <div class="causes-progress">
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuenow="${(item.raisedAmount/item.goalAmount)*100}" aria-valuemin="0" aria-valuemax="100">
                                    <span>${(item.raisedAmount/item.goalAmount)*100 > 100 ? 100 : (item.raisedAmount/item.goalAmount)*100}%</span>
                                </div>
                            </div>
                            <div class="progress-text">
                                <p><strong>Raised:</strong>$${(item.raisedAmount)}</p>
                                <p><strong>Goal:</strong> $${(item.goalAmount)}</p>
                            </div>
                        </div>
                        <div class="causes-text" style="height: 6em">
                            <h3>${item.programName}</h3>
                            <p>${item.shortDes}</p>
                        </div>
                        <div class="causes-btn" style="padding: 10px">
                            <a href="program?action=detail&programId=${item.programId}" class="btn btn-custom">Learn More</a>
                            <c:if test="${sessionScope.user.role=='2' || sessionScope.user.role=='1'}">
                                <a class="btn btn-custom" href="operator?programId=${item.programId}">Update Operator</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
            <div class="row">
                <div class="col-12">
                    <div id="pagination">
                    </div>
                </div>
            </div>
    </div>
</div>
<!-- Causes End -->


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


<c:if test="${not empty listProgram}">
    <script>
        let pages = ${pageNumber};
        let currentPage = ${param.page} + 0;

        if (!currentPage) {
            currentPage = 1;
        }

        document.getElementById('pagination').innerHTML = createPagination(pages, currentPage);

        function createPagination(pages, page) {
            let str = '<ul>';
            let active;
            let pageCutLow = page - 1;
            let pageCutHigh = page + 1;


            // Show the Previous button only if you are on a page other than the first
            if (page > 1) {
                str += '<li class="page-item previous no"><a onclick="createPagination(pages, ' + (page - 1) + ')" href="program?action=list&page=' + (page - 1) + '&condition_programName=' + `${condition_programName}` +  '&condition_placeName=' + `${condition_placeName}` + '&condition_investorName=' + `${condition_investorName}` + '&condition_authorName=' + `${condition_authorName}` + '">Previous</a></li>';
            }
            // Show all the pagination elements if there are less than 6 pages total
            if (pages < 6) {
                for (let p = 1; p <= pages; p++) {

                    active = page == p ? "active" : "no";
                    str += '<li class="' + active + '"><a onclick="createPagination(pages, ' + p + ')" href="program?action=list&page=' + p + '&condition_programName=' + `${condition_programName}` +  '&condition_placeName=' + `${condition_placeName}` + '&condition_investorName=' + `${condition_investorName}` + '&condition_authorName=' + `${condition_authorName}` + '">' + p + '</a></li>';
                }
            }
            // Use "..." to collapse pages outside of a certain range
            else {
                // Show the very first page followed by a "..." at the beginning of the
                // pagination section (after the Previous button)
                if (page > 2) {
                    str += '<li class="no page-item"><a onclick="createPagination(pages, 1)" href="program?action=list&page=1&condition_programName=' + `${condition_programName}` +  '&condition_placeName=' + `${condition_placeName}` + '&condition_investorName=' + `${condition_investorName}` + '&condition_authorName=' + `${condition_authorName}` + '">1</a></li>';
                    if (page > 3) {
                        str += '<li class="out-of-range"><a onclick="createPagination(pages,' + (page - 2) + ')" href="program?action=list&page=' + (page - 2) + '&condition_programName=' + `${condition_programName}` +  '&condition_placeName=' + `${condition_placeName}` + '&condition_investorName=' + `${condition_investorName}` + '&condition_authorName=' + `${condition_authorName}` + '">...</a></li>';
                    }
                }
                // Determine how many pages to show after the current page index
                if (page === 1) {
                    pageCutHigh += 2;
                } else if (page === 2) {
                    pageCutHigh += 1;
                }
                // Determine how many pages to show before the current page index
                if (page === pages) {
                    pageCutLow -= 2;
                } else if (page === pages - 1) {
                    pageCutLow -= 1;
                }
                // Output the indexes for pages that fall inside the range of pageCutLow
                // and pageCutHigh
                for (let p = pageCutLow; p <= pageCutHigh; p++) {
                    if (p === 0) {
                        p += 1;
                    }
                    if (p > pages) {
                        continue
                    }
                    active = page == p ? "active" : "no";
                    str += '<li class="page-item ' + active + '"><a onclick="createPagination(pages, ' + p + ')" href="program?action=list&page=' + p + '&condition_programName=' + `${condition_programName}` +  '&condition_placeName=' + `${condition_placeName}` + '&condition_investorName=' + `${condition_investorName}` + '&condition_authorName=' + `${condition_authorName}` + '">' + p + '</a></li>';
                }
                // Show the very last page preceded by a "..." at the end of the pagination
                // section (before the Next button)
                if (page < pages - 1) {
                    if (page < pages - 2) {
                        str += '<li class="out-of-range"><a onclick="createPagination(pages,' + (page + 2) + ')" href="program?action=list&page=' + (page + 2) + '&condition_programName=' + `${condition_programName}` +  '&condition_placeName=' + `${condition_placeName}` + '&condition_investorName=' + `${condition_investorName}` + '&condition_authorName=' + `${condition_authorName}` + '">...</a></li>';
                    }
                    str += '<li class="page-item no"><a onclick="createPagination(pages, pages)" href="program?action=list&page=' + (pages) + '&condition_programName=' + `${condition_programName}` +  '&condition_placeName=' + `${condition_placeName}` + '&condition_investorName=' + `${condition_investorName}` + '&condition_authorName=' + `${condition_authorName}` + '">' + pages + '</a></li>';
                }
            }
            // Show the Next button only if you are on a page other than the last
            if (page < pages) {
                str += '<li class="page-item next no"><a onclick="createPagination(pages, ' + (page + 1) + ')" href="program?action=list&page=' + (page + 1) + '&condition_programName=' + `${condition_programName}` +  '&condition_placeName=' + `${condition_placeName}` + '&condition_investorName=' + `${condition_investorName}` + '&condition_authorName=' + `${condition_authorName}` + '">Next</a></li>';
            }
            str += '</ul>';
            // Return the pagination string to be outputted in the pug templates
            document.getElementById('pagination').innerHTML = str;
            return str;
        }


    </script>
</c:if>



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
</body>

</html>
