/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 *
 * @author toten
 */
@WebServlet(name = "ScheduleController", urlPatterns = {"/schedule"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ScheduleController extends HttpServlet {

    private ScheduleService service = new ScheduleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "register":
                handleRegisterSchedule(req, resp);
                break;
            case "update":
                handleUpdateSchedule(req, resp);
                break;
            default:

        }
    }
    
    private void handleUpdateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int programId = Integer.parseInt(req.getParameter("programId"));
        List<Object> results = getScheduleFromForm(req, resp);
        List<Schedule> schedules = (List<Schedule>) results.get(0);
        List<Part> scheduleImageParts = (List<Part>) results.get(1);
        boolean isNewlyAdded = !req.getParameter("state").equals("false");

        String imageUploadPath = req.getServletContext().getRealPath("");
        
        //TODO: fixing repository not updating
        service.updateSchedule(schedules, scheduleImageParts, "" + programId, imageUploadPath, isNewlyAdded);
        
        // Testing purpose only
//        req.getRequestDispatcher("investor.jsp?programId=" + programId).forward(req, resp);
        
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Object> getScheduleFromForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int scheduleSize = Integer.parseInt(req.getParameter("scheduleSize"));
        int programId = Integer.parseInt(req.getParameter("programId"));

        List<Schedule> schedules = IntStream.iterate(0, i -> i + 1)
                .limit(scheduleSize)
                .mapToObj(i -> {
                    String scheduleDate = req.getParameter("schedule_" + i + "_date");
                    String detailDes = req.getParameter("detail_des_" + i);
                    int scheduleId = req.getParameter("schedule_id_" + i) == null || 
                                    req.getParameter("schedule_id_" + i).isEmpty()
                                    ? 0 : 
                                    Integer.parseInt(req.getParameter("schedule_id_" + i));
                    Schedule schedule = new Schedule(scheduleId, programId, scheduleDate, detailDes, null);
                    List<ScheduleImage> scheduleImages = new ArrayList();
                    
                    System.out.println("Schedule Id: " + scheduleId);
                    try {
                        for (Part part : req.getParts()) {
                            if (part.getName().equals("schedule_img_" + i) && !part.getSubmittedFileName().isEmpty()) {
                                String imgPath = "img/" + programId + part.getSubmittedFileName();
                                ScheduleImage image = new ScheduleImage(0, scheduleId, imgPath);
                                System.out.println(image.getScheduleId());
                                scheduleImages.add(image);
                            }
                        }
                    } catch (IOException | ServletException ex) {
                        Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    schedule.setImgPath(scheduleImages);
                    return schedule;
                })
                .collect(Collectors.toList());
        
        List<Part> scheduleImageParts = req.getParts().stream()
                .filter(part -> part.getName().matches("schedule_img_(.*)") && !part.getSubmittedFileName().isEmpty())
                .collect(Collectors.toList());
        
        List<Object> results = new ArrayList();
        results.add(schedules);
        results.add(scheduleImageParts);
        
        return results;
    }

    private void handleRegisterSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int programId = Integer.parseInt(req.getParameter("programId"));
        List<Object> results = getScheduleFromForm(req, resp);
        List<Schedule> schedules = (List<Schedule>) results.get(0);
        List<Part> scheduleImageParts = (List<Part>) results.get(1);

        String imageUploadPath = req.getServletContext().getRealPath("");
        
        schedules.forEach(x -> System.out.println(x.getProgram_id()));
        // TODO: upload images into server file system
        service.registerSchedule(schedules, scheduleImageParts, "" + programId, imageUploadPath);
        
//        Testing purpose only
//        req.setAttribute("action", "register");
//        req.getRequestDispatcher("investor.jsp?programId=" + programId).forward(req, resp);

    }
}
