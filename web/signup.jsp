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
                        <form method="POST" action="register" enctype="multipart/form-data">
                            <div class="control-group">
                                <input type="text" name="username" class="form-control" placeholder="Username" required="required" />
                            </div>
      
                            <div class="control-group">
                                <input type="password" name="password" class="form-control" placeholder="Password" required="required" />
                            </div>
                            <div class="control-group">
                                <input type="password" class="form-control" placeholder="Password confirmation" required="required" />
                            </div>
                            <div class="control-group">
                                <input type="text" name="name" class="form-control" placeholder="Your name" required="required" />
                            </div>
                            <div class="control-group">
                                <input type="email" name="email" class="form-control" placeholder="Email" required="required" />
                            </div>
                            <div class="control-group">
                                <input type="tel" id="phone" name="phoneNumber" class="form-control" name="phoneNumber"placeholder="Phone Number" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]">
                            </div>
                            <div class="control-group">
                                <input type="date" id="date" class="form-control" name="dob" placeholder="Date of birth">
                            </div>
                            <div class="control-group">
                                <input type="text" name="city" list="cityName"placeholder="Your City" class="form-control">
                                <datalist id="cityName">
                                    <option value="Boston">
                                    <option value="Cambridge">
                                </datalist>
                            </div>
                            <div class="control-group">
                                <input type="text" name="province" list="provincename"placeholder="Your Province" class="form-control">
                                <datalist id="provincename">
                                    <option value="Boston">
                                    <option value="Cambridge">
                                </datalist>
                            </div>
                            <div class="control-group">
                                <input type="text" name="address" class="form-control" placeholder="address" />
                            </div>
                            <div class="control-group button-wrap">
                                <label class="button" name="avatar" for="upload">Upload Your Avatar</label>
                                <input id="upload" name="avatar" type="file">
                            </div>

                            <div class="control-group">
                                <input type="checkbox" id="rememberme" class="">
                                <label for="rememberme" class="remember" style="color: white">Remember me</label><br>
                            </div>
                            <div>
                                <button class="btn btn-custom" type="submit">Login</button>
                            </div>
                            <div class="regis-nav">
                                <a href="">Don't have an account?</a>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="col-lg-7">
                    <div class="donate-content">
                        <div class="section-header">
                            <p>Login Now</p>
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

    <%@include file="/includes/footer.jsp"%>

