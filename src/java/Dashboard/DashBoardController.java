/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

import Contact.ContactService;
import Contact.ContactVO;
import Donate.Donate;
import Donate.DonateService;
import News.NewsService;
import Program.Program;
import Program.ProgramService;
import User.Account;
import User.Donor;
import User.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toten
 */
@WebServlet(name = "DashBoardController", urlPatterns = {"/dashboard"})
public class DashBoardController extends HttpServlet {

    private final NewsService newsService = new NewsService();
    private final DonateService donateService = new DonateService();
    private final ProgramService programService = new ProgramService();
    private final UserService userService = new UserService();
    private final DashBoardService dashBoardService = new DashBoardService();
    private final ContactService contactService = new ContactService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req
     * @param resp
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "donation":
                donationDashboard(req, resp);
                break;
            case "user":
                userDashboard(req, resp);
                break;
            case "contact":
                messageDashboard(req, resp);
                break;
            default:
                req.getRequestDispatcher("home").forward(req, resp);
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req
     * @param resp
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    public void donationDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        double totalToday = dashBoardService.getTotal("today");
        double totalThisMonth = dashBoardService.getTotal("month");
        double totalAll = dashBoardService.getTotal("all");
        double totalCalledAmountClose = programService.getActutalAmountAll("close");
        double totalCalledAmountOpen = programService.getActutalAmountAll("open");
        long totalActualAmountClose = (long) programService.getGoalAmountAll("close");
        long totalActualAmountOpen = (long) programService.getGoalAmountAll("open");
        List<Program> programs = programService.getListProgramAllAvaiable();
        List<Donate> donate = donateService.getListDonation();

        System.out.println(totalCalledAmountClose);

        String urlHistory = "dashboard?action=donation";

        session = req.getSession(true);
        session.setAttribute("urlHistory", urlHistory);

        req.setAttribute("totalCalledAmountClose", totalCalledAmountClose);
        req.setAttribute("totalCalledAmountOpen", totalCalledAmountOpen);
        req.setAttribute("totalActualAmountClose", totalActualAmountClose);
        req.setAttribute("totalActualAmountOpen", totalActualAmountOpen);
        req.setAttribute("donations", donate);
        req.setAttribute("totalToday", totalToday);
        req.setAttribute("totalThisMonth", totalThisMonth);
        req.setAttribute("totalAll", totalAll);
        req.setAttribute("avaiablePrograms", programs.size());
        req.setAttribute("programs", programs);

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }

    public void userDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        List<Account> listUser = userService.listUser();
        int managerCount = userService.getManagerNumber();

        String urlHistory = "dashboard?action=user";

        session = req.getSession(true);
        session.setAttribute("urlHistory", urlHistory);

        req.setAttribute("listUser", listUser);
        req.setAttribute("managerNumber", managerCount);

        req.getRequestDispatcher("dashboardUser.jsp").forward(req, resp);
    }
    
    public void messageDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        List<ContactVO> listContact = contactService.getAllMessage();
        int managerCount = userService.getManagerNumber();
        
        System.out.println(listContact);

        String urlHistory = "dashboard?action=contact";

        session = req.getSession(true);
        session.setAttribute("urlHistory", urlHistory);

        req.setAttribute("listContact", listContact);
        req.setAttribute("managerNumber", managerCount);

        req.getRequestDispatcher("dashboardContact.jsp").forward(req, resp);
    }

}
