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
                        <h2>Login Now</h2>
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
                            <form>
                                <div class="control-group">
                                    <input type="text" class="form-control" placeholder="Username" required="required" />
                                </div>
                                <div class="control-group">
                                    <input type="password" class="form-control" placeholder="Password" required="required" />
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

