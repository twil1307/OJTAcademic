/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Donate.Donate;
import Donate.DonateService;
import Investor.Investor;
import Investor.InvestorService;
import Program.Program.Destination;
import Schedule.Schedule;
import Schedule.ScheduleService;
import User.Account;
import User.UserService;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "ProgramController", urlPatterns = {"/program"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ProgramController extends HttpServlet {

    private final ProgramService service = new ProgramService();
    private final UserService userService = new UserService();
    private final DonateService donateService = new DonateService();
    private final InvestorService investorService = new InvestorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "list":
                getListPrograms(req, resp);
                break;
            case "detail":
                getProgramInformation(req, resp);
                break;
            case "register":
                break;
            default:
                break;
        }

        // TODO: route base on action
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "register":
                handleRegisterProgram(req, resp);
            default:

        }
    }
    
    private void getListPrograms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         final int PAGE_SIZE = 6;
        
        HttpSession session = req.getSession(false);
        String pageStr = req.getParameter("page");
        
        List<Program> listProgram= null;
        int totalProgram = service.getTotalProgram();
        int pageNumber = (int) Math.floor(totalProgram/PAGE_SIZE) + (totalProgram%PAGE_SIZE > 0 ? 1 : 0);
        
        System.out.println("Page number " + pageNumber);

        
        if (pageStr != null ) {
            int page = Integer.parseInt(pageStr);
            int beginElement = (page - 1) * PAGE_SIZE;
            listProgram = service.getListProgram(beginElement, PAGE_SIZE);
            
        } else {
            pageStr="1";
            int beginElement = (Integer.parseInt(pageStr) - 1) * PAGE_SIZE;
            listProgram = service.getListProgram(beginElement, PAGE_SIZE);
        }
        
        System.out.println(listProgram.size());
       
        String urlHistory = "program?action=list&page="+pageStr;

        session = req.getSession(true);
        session.setAttribute("urlHistory", urlHistory);
        req.setAttribute("listProgram", listProgram);
        req.setAttribute("totalProgram", totalProgram);
        req.setAttribute("page", pageStr);
        req.setAttribute("pageNumber", pageNumber);
        req.getRequestDispatcher("programList.jsp").forward(req, resp);
    }

    private void getProgramInformation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int programId = Integer.parseInt(req.getParameter("programId"));
        Program program = service.getProgramById(programId);
        List<Schedule> programSchedules = new ScheduleService().getSchedulesByProgramId(programId);
        List<Donate> listDonate = donateService.getListRecentDonateByProgramId(programId);
        List<Investor> investors = investorService.getListInvestorsByProgramId(programId);
        Account acc = userService.getUserByID(program.getUserId());
        double raisedAmount = service.getProgramRaisedAmount(programId);
        
        session = req.getSession(true);
        session.setAttribute("urlHistory", "program?action=detail&programId=" + programId);
        
        req.setAttribute("investors", investors);
        req.setAttribute("program", program);
        req.setAttribute("schedules", programSchedules);
        req.setAttribute("raisedAmount", raisedAmount);
        req.setAttribute("author", acc);
        req.setAttribute("listDonate", listDonate);

        req.getRequestDispatcher("program.jsp").forward(req, resp);
    }

    private void handleRegisterProgram(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Account account = (Account) session.getAttribute("user");
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
        datesBetweenSche.add(localScheEndDate);

        String imageUploadPath = req.getServletContext().getRealPath("");

        try {
            for (Part part : req.getParts()) {
                if (part.getName().equals("programImgs")) {
                    String fileName = "img" + File.separator + programName + part.getSubmittedFileName();
                    ProgramImage programImage = new ProgramImage(0, fileName, 0);
                    programImgs.add(programImage);
                    programImgParts.add(part);
                }
            }
        } catch (IOException | ServletException e) {
            throw new Error("Input images not found");
        }

        Program newProgram = new Program(
                0, programName, shortDes, detailDes,
                goalAmount, startDate, endDate, null,
                scheStartDate, scheEndDate, account.getAccountId(), programImgs
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
        } catch (ParseException e) {
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
