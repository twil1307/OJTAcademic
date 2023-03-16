<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/includes/header.jsp"%>
<head>
    <title>Blog</title>
</head>

<%@include file="/includes/navbar.jsp"%>

<!-- Page Header Start -->
<div class="page-header">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2>News</h2>
            </div>
            <div class="col-12">
                <a href="home">Home</a>
                <a href="news?action=list">News</a>
            </div>
        </div>
    </div>
</div>
<!-- Page Header End -->


<!-- Blog Start -->
<div class="blog">
    <div class="container">
        <div class="section-header text-center">
            <p>Our News</p>
            <h2>Latest news & articles directly from our website</h2>
        </div>
        <div class="row g-2">
            <c:forEach var="item" items="${listNews}">
                <div class="col-lg-4" style="margin-bottom: 2em">
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
        <c:if test="${pageNumber > 1}">
            <div class="row">
                <div class="col-12">
                    <div id="pagination">

                    </div>
                </div>
            </div>
        </c:if>

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


<c:if test="${not emptytotalNews}">
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
                str += '<li class="page-item previous no"><a onclick="createPagination(pages, ' + (page - 1) + ')" href="news?action=list&page=' + (page - 1) + '">Previous</a></li>';
            }
            // Show all the pagination elements if there are less than 6 pages total
            if (pages < 6) {
                for (let p = 1; p <= pages; p++) {

                    active = page == p ? "active" : "no";
                    str += '<li class="' + active + '"><a onclick="createPagination(pages, ' + p + ')" href="news?action=list&page=' + p + '">' + p + '</a></li>';
                }
            }
            // Use "..." to collapse pages outside of a certain range
            else {
                // Show the very first page followed by a "..." at the beginning of the
                // pagination section (after the Previous button)
                if (page > 2) {
                    str += '<li class="no page-item"><a onclick="createPagination(pages, 1)" href="news?action=list&page=1">1</a></li>';
                    if (page > 3) {
                        str += '<li class="out-of-range"><a onclick="createPagination(pages,' + (page - 2) + ')" href="news?action=list&page=' + (page - 2) + '">...</a></li>';
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
                    str += '<li class="page-item ' + active + '"><a onclick="createPagination(pages, ' + p + ')" href="news?action=list&page=' + p + '">' + p + '</a></li>';
                }
                // Show the very last page preceded by a "..." at the end of the pagination
                // section (before the Next button)
                if (page < pages - 1) {
                    if (page < pages - 2) {
                        str += '<li class="out-of-range"><a onclick="createPagination(pages,' + (page + 2) + ')" href="news?action=list&page=' + (page + 2) + '">...</a></li>';
                    }
                    str += '<li class="page-item no"><a onclick="createPagination(pages, pages)" href="news?action=list&page=' + (pages) + '">' + pages + '</a></li>';
                }
            }
            // Show the Next button only if you are on a page other than the last
            if (page < pages) {
                str += '<li class="page-item next no"><a onclick="createPagination(pages, ' + (page + 1) + ')" href="news?action=list&page=' + (page + 1) + '">Next</a></li>';
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
