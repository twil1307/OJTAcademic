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
            <h2 class="text-center text-light mt-10">Program <span class="font-weight-bold">${programName}</span></h2>

            <form method="POST" action="${action.equals("register") ? 
                "/OJT_Mock/schedule?action=register" :
                "/OJT_Mock/schedule?action=update" 
            }" id="form" class="container my-0" enctype="multipart/form-data">
                <input type="hidden" value="${dateBetween.size()}" name="scheduleSize" />    
                <input type="hidden" value="${programId}" name="programId" />
                <input type="hidden" value="${state}" name="state" />
                <c:forEach 
                begin="0" 
                end="${dateBetween.size() - 1}" 
                items="${dateBetween}"
                var="item"
                varStatus="counter"
                >
                    <c:set var="schedule" value="${schedules.get(counter.index)}"/>
                    <div data-schedule-date="${item.toString()}" >
                        <h4 class="text-light">Schedule for ${item.toString()}</h4>
                        <div class="form-group">
                        <label for="detail_des">Detail Description</label>
                            <textarea 
                                type="text" 
                                class="form-control"
                                id="detail_des_${counter.index}"
                                aria-describedby="detailDescription" 
                                placeholder="Enter Detail Description"
                                style="height: 140px; min-height: 36px"
                                name="detail_des_${counter.index}"
                                required
                            >${schedule.detail_des}</textarea>
                        </div>
                         <div class="form-group">
                             <label for="input_file_${counter.index}">Schedule Images</label>
                             <input 
                                 type="file" 
                                 class="form-control-file" 
                                 id="input_file_${counter.index}"
                                 name="schedule_img_${counter.index}"
                                 multiple
                                 ${action.equals("register") ? "required" : ""}
                                 accept="image/*"
                             >
                         </div>
                         <div class="row">
                             <c:forEach items="${schedule.imgPath}" var="image">
                                 <img src="${image.path}" alt="" class="col-sm-12 col-md-6 col-lg-4 image-preview" />
                             </c:forEach>
                         </div>
                        <input type="hidden" value="${action.equals("register") ? "" : schedule.schedule_id}" name="schedule_id_${counter.index}" />
                        <input type="hidden" value="${item.toString()}" name="schedule_${counter.index}_date" />
                    </div>
                </c:forEach>
                <button class="mt-5 btn btn-primary container-fluid">Submit</button>
           </form>
            
       </main>
    </body>
    <script>
        const formEl = document.getElementById("form");
        const formGroupEls = formEl.querySelectorAll("[data-schedule-date]");
        
        formGroupEls.forEach((formGroup, index) => {
            const fileInputEl = formGroup.querySelector(`#input_file_\${index}`);
            const imagePreviewSectionEl = formGroup.querySelector(".row");

            fileInputEl.onchange = (e) => {
               const { files } = e.target;
                imagePreviewSectionEl.innerHTML = '';
            
                for ( const file of files ) {
                    const objectUrl = URL.createObjectURL(file);

                    const imagePreviewEl = document.createElement("img");

                    imagePreviewEl.classList.add('col-sm-12', 'col-md-6', 'col-lg-4', 'image-preview');
                    imagePreviewEl.src = objectUrl;

                    imagePreviewSectionEl.append(imagePreviewEl);
                }  
            }
        })
    </script>
</html>
