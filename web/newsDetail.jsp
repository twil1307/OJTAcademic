<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="/includes/header.jsp"%>
<head>
    <title>Detail</title>
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
                <a>${news.newsTitle}</a>
            </div>
        </div>
    </div>
</div>
<!-- Page Header End -->


<!-- Single Post Start-->
<div class="single">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="single-content">

                    <div class="carousel" style="background-color: #dcf9fc">
                        <div class="container-fluid">

                            <!-- News title -->
                            <div class="news-header-wrap">
                                <h1>${news.newsTitle}</h1>
                                <p>${news.postedDate}</p>
                            </div>


                            <div class="owl-carousel">
                                <!-- News images -->
                                <c:forEach var="item" items="${news.imgsPath}">
                                    <div class="carousel-item">
                                        <div class="carousel-img">
                                            <img src="${item}" style="height: 25em" alt="Image">
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <!-- News shortDes -->
                    <h4>${news.shortDes}</h4>
                    <p style="white-space: pre-wrap;">${news.newsDes}</p>
                </div>
                <div class="single-bio">
                    <div class="single-bio-img">
                        <img src="${author.avatar}" />
                    </div>
                    <div class="single-bio-text">
                        <h3>${author.name}</h3>
                        <p>
                            ${author.email}
                        </p>
                    </div>
                </div>

            </div>

            <div class="col-lg-4">
                <div class="sidebar">
                    

                    <div class="sidebar-widget">
                        <h2 class="widget-title">Recent Post</h2>
                        <div class="recent-post">
                            
                            <c:forEach var="item" items="${recentNews}">
                                <div class="post-item">
                                    <div class="post-img">
                                        <img src="${item.backGroundImg}" />
                                    </div>
                                    <div class="post-text">
                                        <a href="news?action=single&newsId=${item.newsId}">${item.newsTitle}</a>
                                        <div class="post-meta">
                                            <p>By<a >${item.createdBy}</a></p>
                                            
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="sidebar-widget">
                        <div class="image-widget">
                            <a href="#"><img src="img/blog-1.jpg" alt="Image"></a>
                        </div>
                    </div>
                    <div class="sidebar-widget">
                        <div class="image-widget">
                            <a href="#"><img src="img/blog-2.jpg" alt="Image"></a>
                        </div>
                    </div>




                </div>
            </div>
        </div>
    </div>
</div>
<!-- Single Post End-->  

<%@include file="/includes/footer.jsp"%>

