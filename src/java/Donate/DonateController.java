/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Donate;

import User.Account;
import User.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shared.OTPGenerate;
import shared.SendMail;

/**
 *
 * @author toten
 */
@WebServlet(name = "DonateController", urlPatterns = {"/donate"})
public class DonateController extends HttpServlet {

    private final DonateService service = new DonateService();
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
        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
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
            case "request":
                requestDonating(req, resp);
                break;

            case "confirm":
                confirmDonating(req, resp);
                break;
            default:
                req.getRequestDispatcher("home").forward(req, resp);
                break;
        }
    }

    protected void confirmDonating(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Account account = (Account) session.getAttribute("user");
        String amount = req.getParameter("amount");
        String message = req.getParameter("message");
        String programId = req.getParameter("programId");
        String otpCheck = req.getParameter("otp");
        String urlHistory = (String) session.getAttribute("urlHistory");
        String otp = (String) session.getAttribute("otp");

        if (!otpCheck.equals(otp)) {
            String errOtp = "The OTP is not correct, please input it again.";

            req.setAttribute("programId", programId);
            req.setAttribute("amount", amount);
            req.setAttribute("message", message);
            req.setAttribute("errorMessage", errOtp);

            req.getRequestDispatcher("confirm.jsp").forward(req, resp);
            return;
        }

        session.removeAttribute("otp");
        Donate donate = new Donate(0, account.getAccountId(), Integer.parseInt(programId), Double.parseDouble(amount), null, message);
        try {
            service.donate(donate);
        } catch (Exception e) {
            req.setAttribute("urlHistory", urlHistory);
            req.getRequestDispatcher("failedPage.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("successPage.jsp").forward(req, resp);
    }

    protected void requestDonating(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Account account = (Account) session.getAttribute("user");
        String amount = req.getParameter("amount");
        String message = req.getParameter("message");
        String programId = req.getParameter("programId");
        String programName = req.getParameter("programName");
        String emailAccount = userService.getEmailByAccountID(account.getAccountId());
//        String urlHistory = (String) session.getAttribute("urlHistory");

        int currentWalletAmount = service.getWalletAmount(account.getAccountId());
        session = req.getSession(true);

//        Check if money in your bank is enough or not
        if (currentWalletAmount < Integer.parseInt(amount)) {
            req.setAttribute("errorMessage", "Your current wallet don't have enough money, please put more money!!");
            String urlHistory = "program?action=detail&programId=" + programId + "&errorMessage=Your current wallet don't have enough money, please put more money!!";
            session.setAttribute("urlHistory", urlHistory);
            resp.sendRedirect(urlHistory);
        } else {
            //        Send otp to confirm donating
            String otp = OTPGenerate.generateOTP();
            session.setAttribute("otp", otp);

            try {
                SendMail.sendConfirmEmail("success", emailAccount, "CONFIRM DONATING", "We receive a request that you donate " + amount + " dollars for the project " + programName + " pllease confirm it by the OTP", "Thanks for being a part of us", otp);

            } catch (Exception e) {
                resp.sendRedirect("failedPage.jsp");
            }

            req.setAttribute("amount", amount);
            req.setAttribute("message", message);
            req.setAttribute("programId", programId);
            req.getRequestDispatcher("confirm.jsp").forward(req, resp);
        }

    }

}
