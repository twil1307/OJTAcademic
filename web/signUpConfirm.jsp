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
                        <a href="home">Home</a>
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
                                <h2>Confirm your OTP to make sure that your email and your bank account is legal</h2>
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
                           <form method="POST" action="donate?action=confirm">
                                <div class="control-group">
                                    <input type="hidden" class="form-control" name="amount" value="${amount}"/>
                                    <input type="hidden" class="form-control" name="message" value="${message}"/>
                                    <input type="hidden" class="form-control" name="programId" value="${programId}"/>
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
    
    <%@include file="/includes/footer.jsp"%>

