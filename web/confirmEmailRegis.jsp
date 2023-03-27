<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/includes/header.jsp"%>
    <head>
        <title>Donate Now</title>
    </head>

    <%@include file="/includes/navbar.jsp"%>

    <!-- Page Header Start -->
    <div class="page-header">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h2>Confirmation</h2>
                </div>
                <div class="col-12">
                    <a href="">Confirm</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Donate Start -->
    <div class="container">
        <div class="donate" data-parallax="scroll" data-image-src="img/donate.jpg">
            <div class="row align-items-center">
                <div class="col-lg-7">
                    <div class="donate-content">
                        <div class="section-header">
                            <p>Confirm your OTP</p>
                            <h2>Please confirm your email ${email} by the OTP sent</h2>
                        </div>
                        <div class="donate-text">
                            <p>
                                Lorem ipsum dolor sit amet elit. Phasellus nec pretium mi. Curabitur facilisis ornare velit non. Aliquam metus tortor, auctor id gravida, viverra quis sem. Curabitur non nisl nec nisi maximus. Aenean convallis porttitor. Aliquam interdum at lacus non blandit.
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5">
                    <div class="donate-form">
                        <c:if test="${error!=null}">
                            <div class="alert alert-danger">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                <strong>${error}</strong>
                            </div>
                        </c:if>
                        <form method="POST" action="signup?action=confirm">
                            <div class="control-group">
                                <input type="hidden" class="form-control" name="username" value="${donorSignUp.username}"/>
                                <input type="hidden" class="form-control" name="password" value="${donorSignUp.password}"/>
                                <input type="hidden" class="form-control" name="passwordConfirm" value="${passwordConfirm}"/>
                                 <input type="hidden" class="form-control" name="email" value="${donorSignUp.email}"/>
                                <input type="hidden" class="form-control" name="city" value="${donorSignUp.city}"/>
                                <input type="hidden" class="form-control" name="province" value="${donorSignUp.province}"/>
                                <input type="hidden" class="form-control" name="address" value="${donorSignUp.address}"/>
                                <input type="hidden" class="form-control" name="name" value="${donorSignUp.name}"/>
                                <input type="hidden" class="form-control" name="phoneNumber" value="${donorSignUp.phoneNumber}"/>
                                <input type="hidden" class="form-control" name="dob" value="${donorSignUp.dob}"/>
                                <input type="hidden" class="form-control" name="bank_account" value="${donorSignUp.bank_account}"/>
                                <input type="hidden" class="form-control" name="avatarPath" value="${donorSignUp.avatar}"/>
                                <input type="text" class="form-control" name="otp" placeholder="Confirm your OTP code" required="required" />
                            </div>

                            <div>
                                <button class="btn btn-custom" type="submit">Confirm</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Donate End -->

  
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

