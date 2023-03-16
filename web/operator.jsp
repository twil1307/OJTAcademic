<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <%@include file="/includes/header.jsp"%>
    <head>
        <title>Program Register</title>
        <link href="css/program.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>
        <main>
            <div data-schedule-date="investor" class="operator-form form-group-invest" style="display: none;">
                <h4 class="text-light">Investor for Program</h4>
                <div class="form-group">
                    <label for="operatorDate">Operator Date</label>
                    <input type="date" class="form-control form-control-lg" id="operatorDate" aria-describedby="operatorDate" name="operatorDate-" required>
                    <label for="operatorDetailDes">Detail Description</label>
                    <textarea type="text" class="form-control" Jung id="operatorDetailDes" name="operatorDetailDes-" aria-describedby="operatorDetailDes" placeholder="Enter Investor Description" style="height: 140px; min-height: 36px" name="operatorDetailDes-1" required></textarea>

                    <label for="activities">Activities Images</label>
                    <input type="file" class="form-control-file" id="activities" name="activities-" required accept="image/*" multiple>
                    <label for="actualExpense">Actual total Expense</label>
                    <input type="number" class="form-control form-control-lg" id="actualExpense" name="actualExpense-" maxlength="10" placeholder="Enter total expense" required>

                    <label for="billImg">Bill Images</label>
                    <input type="file" class="form-control-file" id="billImg" name="billImg-" required accept="image/*" multiple>

                </div>
                <div class="row">

                </div>
            </div>
            <form method="POST" action="/OJT_Mock/operator?action=register" id="form" class="container" enctype="multipart/form-data">

                <c:choose>
                    <c:when test="${not empty operators}">
                        <c:forEach var="item" items="${operators}" varStatus="itemStatus">
                            <div data-schedule-date="investor" id="operator-form-1" class="form-group-invest">
                                <h4 class="text-light">Operator for Program</h4>
                                <div class="form-group">
                                    <label for="operatorDate">Operator Date</label>
                                    <input type="date" class="form-control form-control-lg" id="operatorDate" aria-describedby="operatorDate"value="${item.operatorDate}" name="operatorDate-${itemStatus.index+1}" required>
                                    <label for="operatorDetailDes">Detail Description</label>
                                    <textarea type="text" class="form-control" Jung id="operatorDetailDes" name="operatorDetailDes-${itemStatus.index+1}" aria-describedby="operatorDetailDes" placeholder="Enter Investor Description" style="height: 140px; min-height: 36px" name="operatorDetailDes-${itemStatus.index+1}" required>${item.operatorDetailDes}</textarea>

                                    <label for="activities">Activities Images</label>
                                    <input type="file" class="form-control-file" id="activities" onchange="activitiesImgChange(${itemStatus.index+1})" name="activities-${itemStatus.index+1}" required accept="image/*" multiple>
                                    <div id="investAvatar-preview-section" class="row">
                                        <c:forEach var="actImg" items="${item.activiesImgs}">
                                             <img class="col-sm-12 col-md-6 col-lg-4 image-preview" src="${actImg.path}">
                                             <input type="hidden" value="${actImg.id}" name="actImgId" id="actImgId-${itemStatus.index+1}" />
                                        </c:forEach>
                                       
                                    </div>
                                    <label for="actualExpense">Actual total Expense</label>
                                    <input type="number" class="form-control form-control-lg" id="actualExpense" value="${item.actualExpense}" name="actualExpense-${itemStatus.index+1}" maxlength="10" placeholder="Enter total expense" required>
                                    <label for="billImg">Bill Images</label>
                                    <input type="file" class="form-control-file" id="billImg" onchange="billImgChange(${itemStatus.index+1})" name="billImg-${itemStatus.index+1}" required accept="image/*" multiple>
                                    <div id="qualifyImg-preview-section" class="row">
                                        <c:forEach var="billImg" items="${item.billImgs}">
                                             <img class="col-sm-12 col-md-6 col-lg-4 image-preview" src="${billImg.path}">
                                            <input type="hidden" value="${billImg.id}" name="billImgId" id="actImgId-${itemStatus.index+1}" />
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="row">

                                </div>

                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div data-schedule-date="investor" id="operator-form-1" class="form-group-invest">
                            <h4 class="text-light">Operator for Program</h4>
                            <div class="form-group">
                                <label for="operatorDate">Operator Date</label>
                                <input type="date" class="form-control form-control-lg" id="operatorDate" aria-describedby="operatorDate" name="operatorDate-1" required>
                                <label for="operatorDetailDes">Detail Description</label>
                                <textarea type="text" class="form-control" Jung id="operatorDetailDes" name="operatorDetailDes-1" aria-describedby="operatorDetailDes" placeholder="Enter Investor Description" style="height: 140px; min-height: 36px" name="operatorDetailDes-1" required></textarea>

                                <label for="activities">Activities Images</label>
                                <input type="file" class="form-control-file" id="activities" name="activities-1" required accept="image/*" multiple>
                                <label for="actualExpense">Actual total Expense</label>
                                <input type="number" class="form-control form-control-lg" id="actualExpense" name="actualExpense-1" maxlength="10" placeholder="Enter total expense" required>

                                <label for="billImg">Bill Images</label>
                                <input type="file" class="form-control-file" id="billImg" name="billImg-1" required accept="image/*" multiple>

                            </div>
                            <div class="row">

                            </div>

                        </div>
                    </c:otherwise>
                </c:choose>




                <input type="hidden" id="operator-days" id="operator-days" name="operator-days" value="${operators.size() > 0 ? operators.size()  : 1 }">
                <input type="hidden" value="${programId}" name="programId" />
                <button type="button" class="mt-5 btn btn-primary" onclick="addRow()">Add investor</button>
                <button type="button" class="mt-5 btn btn-danger" onclick="deleteRow()">Delete investor</button>
                <button type="submit" class="mt-5 btn btn-primary container-fluid">Submit</button>
            </form>
        </main>
    </body>
    <script>
        let currentSizeForm = ${operators.size()};
        let i = (currentSizeForm===0 ? 1 :  currentSizeForm);
        const programImgInputEl = document.getElementById("programImgs");
        const imagePreviewSectionEl = document.getElementById("image-preview-section");
        const startDateEl = document.getElementById("startDate");
        const endDateEl = document.getElementById("endDate");
        const scheStartDateEl = document.getElementById("scheStartDate");
        const scheEndDateEl = document.getElementById("scheEndDate");

        programImgInputEl.onchange = (e) => {
            const {
                files
            } = e.target;

            for (const file of files) {
                const objectUrl = URL.createObjectURL(file);
                const imagePreviewEl = document.createElement("img");

                imagePreviewEl.classList.add('col-sm-12', 'col-md-6', 'col-lg-4', 'image-preview');
                imagePreviewEl.src = objectUrl;

                imagePreviewSectionEl.append(imagePreviewEl);
            }
        }

        function addRow() {
            var investorForm = $('.operator-form').clone();
            investorForm.css('display', 'block');
            investorForm.removeClass('operator-form');
            investorForm.attr('id', 'operator-form-' + (i + 1));
            investorForm.find('#operatorDate').attr('name', 'operatorDate-' + (i + 1));
            investorForm.find('#operatorDetailDes').attr('name', 'operatorDetailDes-' + (i + 1));
            investorForm.find('#activities').attr('name', 'activities-' + (i + 1));
            investorForm.find('#actualExpense').attr('name', 'actualExpense-' + (i + 1));
            investorForm.find('#qualifyImg').attr('name', 'qualifyImg-' + (i + 1));
            investorForm.find('#billImg').attr('name', 'billImg-' + (i + 1));

//            $('#operator-form-' + i).after(investorForm);
            $('#operator-days').before(investorForm);
            i++;
            $('#operator-days').val(i);
        }

        function deleteRow() {
            var investFormGroup = $('#form').find('.form-group-invest');
            if (investFormGroup.length > 1) {
                investFormGroup.last().remove();
                i--;
                $('#investor-number').val(i);
            }
        }
        
        function activitiesImgChange(index) {
            
        }
        
        function billImgChange(index) {
            
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
    <script src="js/program.js"></script>
</html>
