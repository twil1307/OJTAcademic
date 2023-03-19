/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Donate.Donate;
import Donate.DonateService;
import Security.PasswordEncrypt;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import shared.OTPGenerate;
import shared.SendMail;

/**
 *
 * @author toten
 */
@WebServlet(name = "UserController", urlPatterns = {"/user"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
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

        if (account == null) {
            req.setAttribute("signUpFailMessage", "Username existed");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

        session.setAttribute("urlHistory", "user?userId=" + userId);

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
            case "requestChangeEmail":
                requestChangeEmail(req, resp);
                break;
            case "confirmChangeEmail":
                confirmChangeEmail(req, resp);
                break;
            case "changePassword":
                changePassword(req, resp);
                break;
        }

    }

    private void updateBasicInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int accountId = Integer.parseInt(req.getParameter("accountId"));
        String phoneNumber = req.getParameter("phoneNumber");
        String dob = req.getParameter("dob");
        String city = req.getParameter("city");
        String province = req.getParameter("province");
        String address = req.getParameter("address");
        Part part = req.getPart("avatar");
        String avatar = null;

        if (part == null) {
            Donor findAcc = (Donor) userService.getUserByID(accountId);
            avatar = (findAcc.getAvatar());
        } else {
            String realPath = req.getServletContext().getRealPath("/img");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

            if (fileName == null || fileName.isEmpty() || fileName.equals("")) {
                Donor findAcc = (Donor) userService.getUserByID(accountId);
                avatar = (findAcc.getAvatar());
            } else {
                part.write(realPath + File.separator + fileName);
                avatar = "img" + File.separator + fileName;
            }
        }

        Account acc = new Donor(accountId, null, name, phoneNumber, dob, city, province, address, avatar);

        userService.updateBasicInfo(acc);

        req.getRequestDispatcher("successPage.jsp").forward(req, resp);
    }

    private void requestChangeEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String bankAccount = req.getParameter("bank_account");
        String userId = req.getParameter("userId");

        String otp = OTPGenerate.generateOTP();
        session.setAttribute("emailChangeConfirmOtp", otp);

        req.setAttribute("userId", userId);
        req.setAttribute("email", email);
        req.setAttribute("bankAccount", bankAccount);

        boolean sendMail = SendMail.sendConfirmEmail("confirm", email, "Confirmation", "Confirm that you have changed your private information", "Here is your OTP", otp);

        if (sendMail == false) {
            req.getRequestDispatcher("failedPage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("confirmEmail.jsp").forward(req, resp);

        }

    }

    private void confirmChangeEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String otp = req.getParameter("otp");
        String email = req.getParameter("email");
        String bankAccount = req.getParameter("bankAccount");
        int userId = Integer.parseInt(req.getParameter("userId"));
        String otpConfirm = (String) session.getAttribute("emailChangeConfirmOtp");

        if (!otp.equalsIgnoreCase(otpConfirm)) {
            req.setAttribute("error", "Your OTP is not correct, please try again!");
            req.setAttribute("email", email);
            req.setAttribute("bankAccount", bankAccount);
            req.setAttribute("userId", userId);
            req.getRequestDispatcher("confirmEmail.jsp").forward(req, resp);
        } else {

            Donor accUpdt = new Donor(userId, email, bankAccount);

            req.setAttribute("email", email);
            req.setAttribute("bankAccount", bankAccount);
            req.setAttribute("userId", userId);

            userService.changeEmailAndBankAcc(accUpdt);

            session.removeAttribute("otp");

            req.getRequestDispatcher("successPage.jsp").forward(req, resp);
        }

    }

    private void changePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");
        String userId = req.getParameter("userId");

        if (!password.equals(passwordConfirm)) {
            req.setAttribute("error", "The confirmation is not correct!!");
            req.getRequestDispatcher("user?userId=" + userId).forward(req, resp);
        }

        String saltValue = PasswordEncrypt.getSaltvalue(20);
        String encryptedPassword = PasswordEncrypt.generateSecurePassword(password, saltValue);

        userService.changePassword(encryptedPassword, saltValue, userId);

        req.getRequestDispatcher("successPage.jsp").forward(req, resp);
    }

}
