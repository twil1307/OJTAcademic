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
                <div style="display: flex; justify-content: space-between; align-items: center">
                    <h2 class="text-light "style="display: inline-block">Operator for Program</h2>
                    <button style="margin: 0!important" type="button" id="del-form-btn" class="mt-5 btn btn-danger">Delete investor</button>
                </div>
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
            <form method="POST" action="/OJT_Mock/operator?action=update" id="operator-form-main" class="container" style="margin-top: 12em" enctype="multipart/form-data">

                <c:choose>
                    <c:when test="${not empty operators}">
                        <c:forEach var="item" items="${operators}" varStatus="itemStatus">
                            <div data-schedule-date="investor" id="operator-form-${itemStatus.index+1}" class="form-group-invest">
                                <div style="display: flex; justify-content: space-between; align-items: center">
                                    <h2 class="text-light "style="display: inline-block">Operator for Program</h2>
                                    <button style="margin: 0!important" type="button" id="del-form-btn-${itemStatus.index+1}" class="mt-5 btn btn-danger" onclick="deleteRowById(${itemStatus.index+1})">Delete investor</button>
                                </div>


                                <div class="form-group">
                                    <label for="operatorDate">Operator Date</label>
                                    <input type="date" class="form-control form-control-lg" id="operatorDate" onchange="inputChange(${itemStatus.index+1})" aria-describedby="operatorDate"value="${item.operatorDate}" name="operatorDate-${itemStatus.index+1}" required>
                                    <label for="operatorDetailDes">Detail Description</label>
                                    <textarea type="text" onchange="inputChange(${itemStatus.index+1})" class="form-control" Jung id="operatorDetailDes" name="operatorDetailDes-${itemStatus.index+1}" aria-describedby="operatorDetailDes" placeholder="Enter Investor Description" style="height: 140px; min-height: 36px" name="operatorDetailDes-${itemStatus.index+1}" required>${item.operatorDetailDes}</textarea>

                                    <label for="activities">Activities Images</label>
                                    <input type="file" class="form-control-file activitiesImgCls-${itemStatus.index+1}" id="activities-${itemStatus.index+1}" onchange="activitiesImgChange(${itemStatus.index+1})" name="activities-${itemStatus.index+1}" ${item.activiesImgs.size()==0 ? required : ''} accept="image/*" multiple>
                                    <div id="investAvatar-preview-section-${itemStatus.index+1}" class="row">
                                        <c:forEach var="actImg" items="${item.activiesImgs}">
                                            <img class="col-sm-12 col-md-6 col-lg-4 image-preview" src="${actImg.path}">
                                            <input type="hidden" value="${actImg.id}" name="actImgId" id="actImgId-${itemStatus.index+1}" />
                                        </c:forEach>
                                    </div>
                                    <label for="actualExpense">Actual total Expense</label>
                                    <input type="number" onchange="inputChange(${itemStatus.index+1})" class="form-control form-control-lg" id="actualExpense" value="${item.actualExpense}" name="actualExpense-${itemStatus.index+1}" maxlength="10" placeholder="Enter total expense" required>
                                    <label for="billImg">Bill Images</label>
                                    <input type="file" class="form-control-file billImgCls-${itemStatus.index+1}" id="billImg-${itemStatus.index+1}" onchange="billImgChange(${itemStatus.index+1})" name="billImg-${itemStatus.index+1}" ${item.billImgs.size()==0 ? required : ''} accept="image/*" multiple>
                                    <div id="qualifyImg-preview-section-${itemStatus.index+1}" class="row">
                                        <c:forEach var="billImg" items="${item.billImgs}">
                                            <img class="col-sm-12 col-md-6 col-lg-4 image-preview" src="${billImg.path}">
                                            <input type="hidden" value="${billImg.id}" name="billImgId" id="billImgId-${itemStatus.index+1}" />
                                        </c:forEach>
                                    </div>
                                </div>
                                <input type="hidden" value="${item.operatorId}" name="operatorId-unchange" id="unchangeOperatorId-${itemStatus.index+1}" />
                                <input type="hidden" value="${item.operatorId}" name="operatorId-${itemStatus.index+1}" id="operatorId-${itemStatus.index+1}" />
                                <div class="row">

                                </div>

                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div data-schedule-date="investor" id="operator-form-1" class="form-group-invest">
                            <h2 class="text-light ">Operator for Program</h2>
                            <div class="form-group">
                                <label for="operatorDate">Operator Date</label>
                                <input type="date" class="form-control form-control-lg" id="operatorDate" aria-describedby="operatorDate" name="operatorDate-1" required>
                                <label for="operatorDetailDes">Detail Description</label>
                                <textarea type="text" class="form-control" Jung id="operatorDetailDes" name="operatorDetailDes-1" aria-describedby="operatorDetailDes" placeholder="Enter Investor Description" style="height: 140px; min-height: 36px" name="operatorDetailDes-1" required></textarea>

                                <label for="activities">Activities Images</label>
                                <input type="file" class="form-control-file" id="activities-1" name="activities-1" required accept="image/*" multiple>
                                <div id="operatorActivities-preview-section" class="row">

                                </div>
                                <label for="actualExpense">Actual total Expense</label>
                                <input type="number" class="form-control form-control-lg" id="actualExpense" name="actualExpense-1" maxlength="10" placeholder="Enter total expense" required>

                                <label for="billImg">Bill Images</label>
                                <input type="file" class="form-control-file" id="billImg-1" name="billImg-1" required accept="image/*" multiple>
                                <div id="operatorBill-preview-section" class="row">

                                </div>
                            </div>
                            <div class="row">

                            </div>

                        </div>
                    </c:otherwise>
                </c:choose>
                <input type="hidden" id="operator-days" name="operator-days" value="${operators.size() > 0 ? operators.size()  : 1 }">
                <input type="hidden" value="${programId}" name="programId" />

                <button type="button" class="mt-5 btn btn-primary" onclick="addRow()">Add investor</button>
                <button type="submit" id="submit-button" class="mt-5 btn btn-primary container-fluid">Submit</button>
            </form>
        </main>
    </body>
    <script>

        var form = document.getElementById('operator-form-main');
        var submitButton = document.getElementById('submit-button');
        console.log(form);
        var isFormChanged = false;

        form.addEventListener('change', function () {
            isFormChanged = true;
        });

        submitButton.addEventListener('click', function () {
            if (!isFormChanged) {
                event.preventDefault();
                window.alert('Form has not been modified');
            }
        });



        let currentSizeForm = ${operators.size()};
        let i = (currentSizeForm === 0 ? 1 : currentSizeForm);
        const programImgInputEl = document.getElementById("programImgs");
        const imagePreviewSectionEl = document.getElementById("image-preview-section");
        const startDateEl = document.getElementById("startDate");
        const endDateEl = document.getElementById("endDate");
        const scheStartDateEl = document.getElementById("scheStartDate");
        const scheEndDateEl = document.getElementById("scheEndDate");
        const operatorActPreviewEl = document.getElementById("operatorActivities-preview-section");
        const operatorBillPreviewEl = document.getElementById("operatorBill-preview-section");

        const activitiesNew = document.getElementById("activities-1");
        const billNew = document.getElementById("billImg-1");

        const onFileInputChange = (previewElement) => {
            return (e) => {
                const {files} = e.target;
                previewElement.innerHTML = ``;

                for (const file of files) {
                    const objectUrl = URL.createObjectURL(file);
                    const imagePreviewEl = document.createElement("img");

                    imagePreviewEl.classList.add('col-sm-12', 'col-md-6', 'col-lg-4', 'image-preview');
                    imagePreviewEl.src = objectUrl;

                    previewElement.append(imagePreviewEl);
                }
            }
        }

        const investorEls = form.querySelectorAll('.form-group-invest');

        investorEls.forEach((investorEl, index) => {

            const counter = index + 1;
            const investAvatarInputEl = investorEl.querySelector(".activitiesImgCls-" + counter);
            const qualifyImgInputEl = investorEl.querySelector(".billImgCls-" + counter);
            const investAvatarPreviewEl = investorEl.querySelector("#investAvatar-preview-section-" + counter);
            const qualifyImgPreviewEl = investorEl.querySelector("#qualifyImg-preview-section-" + counter);

            investAvatarInputEl.addEventListener('change', onFileInputChange(investAvatarPreviewEl));
            qualifyImgInputEl.addEventListener("change", onFileInputChange(qualifyImgPreviewEl));
        })

        activitiesNew.onchange = onFileInputChange(operatorActPreviewEl);
        billNew.onchange = onFileInputChange(operatorBillPreviewEl);


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
            investorForm.find('#del-form-btn').attr({
                name: 'del-form-btn-' + (i + 1),
                id: 'del-form-btn-' + (i + 1)
            });

            investorForm.find('#activities').attr({
                name: 'activities-' + (i + 1),
                id: 'activities-' + (i + 1)
            });
            investorForm.find('#billImg').attr({
                name: 'billImg-' + (i + 1),
                id: 'billImg-' + (i + 1)
            });

            const newActivitiesPreviewEl = document.createElement('div');
            newActivitiesPreviewEl.classList.add('row');
            newActivitiesPreviewEl.id = `operatorActivities-preview-section-${i + 2}`;

            const newBillImgPreviewEl = document.createElement('div');
            newBillImgPreviewEl.classList.add('row');
            newBillImgPreviewEl.id = `operatorBill-preview-section-${i + 2}`;

//            $('#operator-form-' + i).after(investorForm);
            $('#operator-days').before(investorForm);

            investorForm.find(`#activities-` + (i + 1)).after(newActivitiesPreviewEl);
            investorForm.find(`#billImg-` + (i + 1)).after(newBillImgPreviewEl);

            investorForm.find(`#activities-` + (i + 1)).on('change', onFileInputChange(newActivitiesPreviewEl));
            investorForm.find(`#billImg-` + (i + 1)).on('change', onFileInputChange(newBillImgPreviewEl));

//            investorForm.find(`#del-form-btn-` + (i + 1)).addEventListener("click", deleteRowById(i+1));

            document.querySelector("#del-form-btn-" + (i + 1)).addEventListener("click", deleteRowAddById(i + 1));
            i++;
            $('#operator-days').val(i);
        }

        function deleteRowById(index) {
            isFormChanged = true;
            operatorIdDel = $("#operatorId-" + index).val();
            var hiddenElement = document.createElement("input");
            hiddenElement.setAttribute("type", "hidden");
            hiddenElement.setAttribute("name", "operatorIdDel");
            hiddenElement.setAttribute("id", "operatorIdDel");
            hiddenElement.setAttribute("value", operatorIdDel);

            var hiddenElementIndex = document.createElement("input");
            hiddenElementIndex.setAttribute("type", "hidden");
            hiddenElementIndex.setAttribute("name", "operatorDelIndex");
            hiddenElementIndex.setAttribute("id", "operatorDelIndex");
            hiddenElementIndex.setAttribute("value", index);

            $("#operator-days").after(hiddenElement);
            $("#operator-days").after(hiddenElementIndex);
            i = i - 1;
            $('#operator-days').val(i);
            $("#operator-form-" + index).remove();
        }

        const deleteRowAddById = (index) => {
            return (e) => {
                i = i - 1;
                $('#operator-days').val(i);
                $("#operator-form-" + index).remove();
            }
        }

        function activitiesImgChange(index) {
            $("#investAvatar-preview-section").empty();
            var imgId = document.querySelectorAll("#actImgId-" + index);
            for (var i = 0; i < imgId.length; i++) {
                imgId[i].remove();
            }
            $('#unchangeOperatorId-' + index).remove();
        }

        function billImgChange(index) {
            var imgId = document.querySelectorAll("#billImgId-" + index);
            for (var i = 0; i < imgId.length; i++) {
                imgId[i].remove();
            }
            $('#unchangeOperatorId-' + index).remove();
        }

        function inputChange(index) {
            $('#unchangeOperatorId-' + index).remove();
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

    <script src="https://cdn.jsdelivr.net/jquery.dirtyforms/2.0.0/jquery.dirtyforms.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <script src="js/program.js"></script>
</html>
