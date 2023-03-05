/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "ProgramController", urlPatterns = {"/program"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
    maxFileSize = 1024 * 1024 * 50, // 50 MB
    maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ProgramController extends HttpServlet {
    private ProgramService service = new ProgramService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        
        switch(action) {
            case "register": 
                handleRegisterProgram(req);
            default: 
                
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void handleRegisterProgram(HttpServletRequest req) {
        String programName = req.getParameter("programName");
        String shortDes = req.getParameter("shortDes");
        String detailDes = req.getParameter("detailDes");
        double goalAmount = Double.parseDouble(req.getParameter("goalAmount"));
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String city = req.getParameter("city");
        String province = req.getParameter("province");        
        String address = req.getParameter("address");
        String scheStartDate = req.getParameter("scheStartDate");        
        String scheEndDate = req.getParameter("scheEndDate");
        List<ProgramImage> programImgs = new ArrayList();
        List<Part> programImgParts = new ArrayList();
        
        String imageUploadPath = req.getServletContext().getRealPath("/img");
        try {
            for (Part part : req.getParts()) {
                if (part.getName().equals("programImgs")) {
                    String fileName = imageUploadPath + File.separator + programName + part.getSubmittedFileName();
                    ProgramImage programImage = new ProgramImage(0, fileName, 0);
                    programImgs.add(programImage);
                    programImgParts.add(part);
                }
            }
        } catch(IOException | ServletException e) {
            throw new Error("Input images not found");
        }
        
        Program newProgram = new Program(
                0, programName, shortDes, detailDes, 
                goalAmount, startDate, endDate, city, province, address, 
                scheStartDate, scheEndDate, 0, programImgs
        );
        
        service.registerProgram(newProgram, programImgParts, imageUploadPath);
    }

}
