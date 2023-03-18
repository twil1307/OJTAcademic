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

    <%@include file="/includes/footer.jsp"%>

