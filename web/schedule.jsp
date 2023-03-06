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
            <h2 class="text-center text-light mt-10">Program Name Goes Here</h2>

            <form method="POST" action="/OJT_Mock/program?action=register" id="form" class="container my-0">
                <div class="form-group">
                   <label for="detailDescription">Detail Description</label>
                    <textarea 
                        type="text" 
                        class="form-control" Jung
                        id="detailDescription"
                        aria-describedby="detailDescription" 
                        placeholder="Enter Detail Description"
                        style="height: 140px; min-height: 36px"
                        name="detailDescription"
                    ></textarea>
               </div>
                <div class="form-group">
                    <label for="exampleFormControlFile1">Example file input</label>
                    <input type="file" class="form-control-file" id="exampleFormControlFile1">
                </div>
                <p style="white-space: pre;">
                    ${detailDes}
                </p>
                <div>
                    <!-- TOBE: Showing image after upload -->
                </div>
                <button class="mt-5 btn btn-primary container-fluid">Submit</button>
           </form>
            
       </main>
    </body>
</html>
