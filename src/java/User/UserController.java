/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Donate.Donate;
import Donate.DonateService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author toten
 */
@WebServlet(name = "UserController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {
    
    private final DonateService donateService = new DonateService();
    private final UserService userService = new UserService();
    
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
         HttpSession session = req.getSession(false);
         int userId = Integer.parseInt(req.getParameter("userId"));
        List<Donate> donateHistory = donateService.getDonateHistoryByUserId(userId);
        Account account = userService.getUserByID(userId);
        double totalDonate = userService.getUserDonateTotal(account.getAccountId());
        double totalDonateThisMonth = userService.getContributeThisMonth(account.getAccountId());
        int numberProgramContribute = userService.getUserContributeProgramNum(account.getAccountId());
        
        if(account==null) {
            req.setAttribute("signUpFailMessage", "Username existed");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        
        req.setAttribute("totalDonate", totalDonate);
        req.setAttribute("totalDonateThisMonth", totalDonateThisMonth);
        req.setAttribute("numberProgramContribute", numberProgramContribute);
        req.setAttribute("account", account);
        req.setAttribute("donateHistory", donateHistory);
        
        req.getRequestDispatcher("profilePage.jsp").forward(req, resp);
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
        
        String action = req.getParameter("action");
        
        switch (action) {
            case "updateBasicInfo": 
                updateBasicInfo(req, resp);
                break;
        }
        
        
    }
    
    private void updateBasicInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String city = req.getParameter("city");
        String province = req.getParameter("province");
        String address = req.getParameter("address");
        Part part = req.getPart("avatar");
        String avatar;
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
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
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
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
}
