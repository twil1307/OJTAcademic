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
                    <h2>Sign Up</h2>
                </div>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Donate Start -->
    <div class="container">
        <div class="donate" data-parallax="scroll" data-image-src="img/donate.jpg">            
            <div class="row align-items-center">
                <div class="col-lg-5">
                    <div class="donate-form">
                        <form method="POST" action="signup?action=request" enctype="multipart/form-data">
                            <div class="control-group">
                                <input type="text" name="username" class="form-control" placeholder="Username" required="required" value="${userSignUp.getUsername()}" />
                            </div>

                            <div class="control-group">
                                <input type="password" id="password" name="password" onkeyup="check();" class="form-control" minlength="6" value="${userSignUp.getPassword()}" placeholder="Password" required="required" />
                            </div>
                            <div class="control-group">
                                <input type="password" class="form-control" name="passwordConfirm" id="confirm_password" onkeyup="check();" minlength="6"  placeholder="Password confirmation" required="required" />
                                <span id='message'></span>
                            </div>
                            <div class="control-group">
                                <input type="text" name="name" class="form-control" placeholder="Your name" value="${userSignUp.getName()}" required="required" />
                            </div>
                            <div class="control-group">
                                <input type="email" name="email" class="form-control" placeholder="Email" required="required" value="${userSignUp.getEmail()}" />
                            </div>
                            <div class="control-group">
                                <input type="tel" id="phone" name="phoneNumber" class="form-control" name="phoneNumber" value="${userSignUp.getPhoneNumber()}" placeholder="Phone Number" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
                            </div>
                            <div class="control-group">
                                <input type="date" id="date" class="form-control" name="dob" placeholder="Date of birth" value="${userSignUp.getDob()}">
                            </div>
                            <div class="control-group">
                                <input type="text" name="city" list="cityName"placeholder="Your City" class="form-control" value="${userSignUp.getCity()}">
                                <datalist id="cityName">
                                    <option value="Boston">
                                    <option value="Cambridge">
                                </datalist>
                            </div>
                            <div class="control-group">
                                <input type="text" name="province" list="provincename"placeholder="Your Province" class="form-control" value="${userSignUp.getProvince()}">
                                <datalist id="provincename">
                                    <option value="Boston">
                                    <option value="Cambridge">
                                </datalist>
                            </div>
                            <div class="control-group">
                                <input type="text" name="address" class="form-control" placeholder="address" value="${userSignUp.getAddress()}" />
                            </div>
                            <div class="control-group">
                                <input type="number" name="bank_account" class="form-control" placeholder="Bank Account" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]" value="${userSignUp.getBank_account()}"/>
                            </div>
                            <div class="control-group button-wrap">
                                <label class="button" name="avatar" for="upload">Upload Your Avatar</label>
                                <input id="upload" name="avatar" type="file" accept="image/*" onchange="loadFile(event)">
                               
                                        
                                        <img id="output" style="height: 100%; width: 12em"  />
                            </div>

                            <!--                            <div class="control-group">
                                                            <input type="checkbox" id="rememberme" class="">
                                                            <label for="rememberme" class="remember" style="color: white">Remember me</label><br>
                                                        </div>-->
                            <div>
                                <button class="btn btn-custom" type="submit">Sign Up</button>
                            </div>

                        </form>
                    </div>
                </div>

                <div class="col-lg-7">
                    <div class="donate-content">
                        <div class="section-header">
                            <p>Sign Up Now</p>
                            <h2>Let's donate to needy people for better lives</h2>
                        </div>
                        <div class="donate-text">
                            <p>
                                Lorem ipsum dolor sit amet elit. Phasellus nec pretium mi. Curabitur facilisis ornare velit non. Aliquam metus tortor, auctor id gravida, viverra quis sem. Curabitur non nisl nec nisi maximus. Aenean convallis porttitor. Aliquam interdum at lacus non blandit.
                            </p>
                        </div>
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

    <c:if test="${not empty signUpFailMessage}">
        <script>
            window.addEventListener("load", function () {
                alert("${signUpFailMessage}");
            })
        </script>
    </c:if>

    <script>
        var loadFile = function (event) {
            var output = document.getElementById('output');
            output.src = URL.createObjectURL(event.target.files[0]);
            output.onload = function () {
                URL.revokeObjectURL(output.src) // free memory
            }
        };

        var check = function () {


            if (document.getElementById('password').value == document.getElementById('confirm_password').value) {
                document.getElementById('message').style.color = 'green';
                document.getElementById('message').innerHTML = 'matching';
            } else {
                document.getElementById('message').style.color = 'red';
                document.getElementById('message').innerHTML = 'not matching';
            }

            if (document.getElementById('password').value == "" || document.getElementById('confirm_password').value == "") {
                document.getElementById('message').innerHTML = "";
            }
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
</body>

</html>

