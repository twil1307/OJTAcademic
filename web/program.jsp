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
                        <form method="POST" action="/OJT_Mock/program?action=register" id="form" class="container" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="programName">Program Name</label>
                                <input type="text" class="form-control form-control-lg" id="programName" aria-describedby="programName" name="programName" placeholder="Enter Program Name" required>
                            </div>
                            <div class="form-group">
                                <label for="shortDescription">Short Description</label>
                                <input type="text" class="form-control" id="detailDescription" aria-describedby="detailDescription" placeholder="Enter Short Description" name="shortDes" required> >
                            </div>
                            <div class="form-group">
                                <label for="detailDescription">Detail Description</label>
                                <textarea type="text" class="form-control" id="detailDescription" aria-describedby="detailDescription" placeholder="Enter Detail Description" style="height: 140px; min-height: 36px" name="detailDes" required></textarea>
                            </div>
                            <div class="form-group">
                                <label for="goalAmount">Goal Amount</label>
                                <input type="number" class="form-control" id="goalAmount" aria-describedby="goalAmount" placeholder="Enter goal amount" name="goalAmount" required>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <label for="startDate">Start Date</label>
                                    <input type="date" class="form-control" id="goalAmount" aria-describedby="startDate" placeholder="Enter Start Date" name="startDate" required>
                                </div>
                                <div class="col">
                                    <label for="endDate">End Date</label>
                                    <input type="date" class="form-control" id="endDate" aria-describedby="endDate" placeholder="Enter End Date" name="endDate" required>
                                </div>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <label for="city">City</label>
                                    <input type="text" class="form-control" id="city" aria-describedby="city" placeholder="Enter City" name="city" required>
                                </div>
                                <div class="col">
                                    <label for="province">Province</label>
                                    <input type="text" class="form-control" id="province" aria-describedby="province" placeholder="Enter city" name="province" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" id="address" aria-describedby="address" placeholder="Enter Address" name="address" required>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <label for="scheStartDate">Schedule Start Date</label>
                                    <input type="date" class="form-control" id="scheduleStartDate" aria-describedby="scheStartDate" placeholder="Enter Start Date" name="scheStartDate" required>
                                </div>
                                <div class="col">
                                    <label for="scheEndDate">Schedule End Date</label>
                                    <input type="date" class="form-control" id="endDate" aria-describedby="scheEndDate" placeholder="Enter End Date" name="scheEndDate" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="programImgs">Program Images</label>
                                <input type="file" class="form-control-file" id="programImgs" aria-describedby="programImgs" placeholder="Add Program's Images" name="programImgs" accept="image/*" multiple required>
                            </div>
                            <div id="image-preview-section" class="row">

                            </div>
                            <button class="mt-5 btn btn-primary container-fluid">Submit</button>
                        </form>
                    </main>
            </body>
            <script>
                const programImgInputEl = document.getElementById("programImgs");
                const imagePreviewSectionEl = document.getElementById("image-preview-section");

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
            </script>

        </html>