/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Program.Program.Destination;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        req.getRequestDispatcher("program.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        
        switch(action) {
            case "register": 
                handleRegisterProgram(req, resp);
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
    
    private void handleRegisterProgram(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        LocalDate localScheStartDate = toLocalDate(scheStartDate);
        LocalDate localScheEndDate = toLocalDate(scheEndDate);
        List<LocalDate> datesBetweenSche = getDatesBetween(localScheStartDate, localScheEndDate);
        
        
        String imageUploadPath = req.getServletContext().getRealPath("");

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
                goalAmount, startDate, endDate, null, 
                scheStartDate, scheEndDate, 0, programImgs
        );
        Program.Destination programDestination = newProgram.new Destination(0, city, province, address);
        newProgram.setDestination(programDestination);
        
        int programId = service.registerProgram(newProgram, programImgParts, imageUploadPath);
        
        req.setAttribute("dateBetween", datesBetweenSche);
        req.setAttribute("programId", programId);
        req.setAttribute("programName", programName);
        req.getRequestDispatcher("schedule.jsp?programId=" + programId).forward(req, resp);
    }
    
    private LocalDate toLocalDate(String date) {
        try {
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch(ParseException e) {
            throw new Error("Date parsed exception");
        }
        
    }
    
    private List<LocalDate> getDatesBetween(
        LocalDate startDate, LocalDate endDate) { 

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate); 
        return IntStream.iterate(0, i -> i + 1)
          .limit(numOfDaysBetween)
          .mapToObj(i -> startDate.plusDays(i))
          .collect(Collectors.toList()); 
    }

}
