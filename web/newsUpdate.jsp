<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <%@include file="/includes/header.jsp"%>
    <head>
        <title>Program Register</title>
        <link href="css/news.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>
        <main>
            <form method="POST" action="/OJT_Mock/news-manage?action=update&newsId=${news.newsId}" id="form" class="container" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="newsTitle">News Title</label>
                    <input type="text" class="form-control form-control-lg" id="newsTitle" aria-describedby="newsTitle" value="${news.newsTitle}" name="newsTitle" placeholder="Enter News Title" required>
                </div>
                <div class="form-group">
                    <label for="shortDescription">Short Description</label>
                    <textarea type="text" class="form-control" id="shortDescription" aria-describedby="shortDes" maxlength="200" placeholder="Enter Short Description" style="height: 80px; min-height: 36px" name="shortDes" required>${news.shortDes}</textarea>
                    <div class="char-count"><span id="charCountShort">0</span>/200</div>
                </div>
                <div class="form-group">
                    <label for="detailDescription">Detail Description</label>
                    <textarea type="text" class="form-control" id="detailDescription" aria-describedby="detailDescription" maxlength="4000" placeholder="Enter Detail Description" style="height: 30em; min-height: 36px" name="newsDes" required>${news.newsDes}</textarea>
                    <div class="char-count"><span id="charCountDetail">0</span>/4000</div>
                </div>
                <div class="form-group">
                    <label for="newsImgs">Program Images</label>
                    <input type="file" class="form-control-file" id="newsImgs" aria-describedby="newsImgs" placeholder="Add News' Images" name="newsImgs" accept="image/*" multiple>
                </div>

                <div id="image-preview-section-edit" class="row">
                    <c:forEach var="item" items="${news.imgsPath}">
                        <img class="col-sm-12 col-md-6 col-lg-4 image-preview" src="${item}">
                    </c:forEach>
                    
                </div>

                <div id="image-preview-section" class="row">

                </div>
                <button class="mt-5 btn btn-primary container-fluid">Submit</button>
            </form>
        </main>


    </body>
    <script>
        const programImgInputEl = document.getElementById("newsImgs");
        const imagePreviewSectionEl = document.getElementById("image-preview-section");
        const imageImgSectionElEdit = document.getElementById("image-preview-section-edit");

        programImgInputEl.onchange = (e) => {
            imageImgSectionElEdit.innerHTML="";
            
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



//        Count detail des character
        const textareaDetail = document.getElementById("detailDescription");
        const charCountDetail = document.getElementById("charCountDetail");

        textareaDetail.addEventListener("keyup", () => {
            const text = textareaDetail.value;
            charCountDetail.innerText = text.length;
        });


//        Count short des character 
        const textareaShort = document.getElementById("shortDescription");
        const charCountShort = document.getElementById("charCountShort");

        textareaShort.addEventListener("keyup", () => {
            const text = textareaShort.value;
            charCountShort.innerText = text.length;
        });

    </script>
</html>
