/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
        Date startDate = parseStringToDate(req.getParameter("startDate"));
        Date endDate = parseStringToDate(req.getParameter("endDate"));
        String city = req.getParameter("city");
        String province = req.getParameter("province");        
        String address = req.getParameter("address");
        Date scheStartDate = parseStringToDate(req.getParameter("scheStartDate"));        
        Date scheEndDate = parseStringToDate(req.getParameter("scheEndDate"));
        List<String> programImgs = new ArrayList();
        List<Part> programImgParts = new ArrayList();
        
        try {
            for (Part part : req.getParts()) {
                if (part.getName().equals("programImgs")) {
                    programImgs.add(part.getName());
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
        
        // TODO: insert data into database

        String imageUploadPath = req.getServletContext().getRealPath("/img");
        service.registerProgram(newProgram, programImgParts, imageUploadPath);
    }
    
    private Date parseStringToDate(String source) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date result = df.parse(source);
            return result;
        } catch(ParseException e) {
            return null;
        }
    }
}
