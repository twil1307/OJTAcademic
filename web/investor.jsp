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
            <div data-schedule-date="investor" class="investor-form form-group-invest" style="display: none;">
                <h4 class="text-light">Investor for Program</h4>
                <div class="form-group">
                    <label for="investorName">Investor name</label>
                    <input type="text" class="form-control form-control-lg" id="investorName" aria-describedby="investorName" placeholder="Enter Program Name" required>
                    <label for="legalRepresent">Legal Represent</label>
                    <input type="text" class="form-control form-control-lg" id="legalRepresent" aria-describedby="legalRepresent" placeholder="Enter legal represent" required>
                    <label for="investorDes">Detail Description</label>
                    <textarea type="text" class="form-control" Jung id="investorDes" aria-describedby="detailDescription" placeholder="Enter Investor Description" style="height: 140px; min-height: 36px" name="detailDes-1" required></textarea>
                    <label for="contact">Contact</label>
                    <input type="number" class="form-control form-control-lg" id="contact"  maxlength="10" placeholder="Enter Contact" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]" required>
                    <label for="investAvatar">Investor Images</label>
                    <input type="file" class="form-control-file" id="investAvatar" required accept="image/*">
                    <label for="qualifyImg">Qualify Images</label>
                    <input type="file" class="form-control-file" id="qualifyImg" required accept="image/*">
                </div>
                <div class="row">

                </div>
                <input type="hidden" value="${item.toString()}" name="schedule_${counter.index}_date" />

            </div>
            <form method="POST" action="/OJT_Mock/investor?action=register" id="form" class="container" enctype="multipart/form-data">
                <div data-schedule-date="investor" id="investor-form-1" class="form-group-invest">
                    <h4 class="text-light">Investor for Program</h4>
                    <div class="form-group">
                        <label for="investorName">Investor name</label>
                        <input type="text" class="form-control form-control-lg" id="investorName" aria-describedby="investorName" name="investorName-1" placeholder="Enter Program Name" required>
                        <label for="legalRepresent">Legal Represent</label>
                        <input type="text" class="form-control form-control-lg" id="legalRepresent" aria-describedby="legalRepresent" name="legalRepresent-1" placeholder="Enter legal represent" required>
                        <label for="investorDes">Detail Description</label>
                        <textarea type="text" class="form-control" Jung id="investorDes" name="investorDes-1" aria-describedby="detailDescription" placeholder="Enter Investor Description" style="height: 140px; min-height: 36px" name="detailDes-1" required></textarea>
                        <label for="contact">Contact</label>
                        <input type="number" class="form-control form-control-lg" id="contact" name="contact-1" maxlength="10" placeholder="Enter Contact" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]" required>
                        <label for="investAvatar">Investor Images</label>
                        <input type="file" class="form-control-file" id="investAvatar" name="investAvatar-1" required accept="image/*">
                        <label for="qualifyImg">Qualify Images</label>
                        <input type="file" class="form-control-file" id="qualifyImg" name="qualifyImg-1" required accept="image/*">

                    </div>
                    <div class="row">

                    </div>
                    <input type="hidden" value="${item.toString()}" name="schedule_${counter.index}_date" />

                </div>

                <input type="hidden" id="investor-number" name="investor-number" value="1">
                <input type="hidden" value="${param.programId}" name="programId" />
                <button type="button" class="mt-5 btn btn-primary" onclick="addRow()">Add investor</button>
                <button type="button" class="mt-5 btn btn-danger" onclick="deleteRow()">Delete investor</button>
                <button type="submit" class="mt-5 btn btn-primary container-fluid">Submit</button>
            </form>
        </main>
    </body>
    <script>
        let i = 1;
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
            var investorForm = $('.investor-form').clone();
            investorForm.css('display', 'block');
            investorForm.removeClass('investor-form');
            investorForm.find('#investorName').attr('name', 'investorName-' + (i + 1));
            investorForm.find('#legalRepresent').attr('name', 'legalRepresent-' + (i + 1));
            investorForm.find('#investorDes').attr('name', 'investorDes-' + (i + 1));
            investorForm.find('#investAvatar').attr('name', 'investAvatar-' + (i + 1));
            investorForm.find('#qualifyImg').attr('name', 'qualifyImg-' + (i + 1));
            investorForm.find('#contact').attr('name', 'contact-' + (i + 1));

            $('#investor-form-1').after(investorForm);
            i++;
            $('#investor-number').val(i);
        }

        function deleteRow() {
            var investFormGroup = $('#form').find('.form-group-invest');
            if (investFormGroup.length > 1) {
                investFormGroup.last().remove();
                i--;
                $('#investor-number').val(i);
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
    <script src="js/program.js"></script>
</html>
