/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Security.PasswordEncrypt;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
@MultipartConfig
@WebServlet(name = "UserSignUpController", urlPatterns = {"/signup"})
public class UserSignUpController extends HttpServlet {

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
        req.getRequestDispatcher("signup.jsp").forward(req, resp);
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
                requestSignUpUser(req, resp);
                break;
            case "confirm":
                confirmSignUpUser(req, resp);
                break;
        }

    }

    protected void requestSignUpUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDAO userDAO = new UserDAO();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("passwordConfirm");
        String email = req.getParameter("email");
        String city = req.getParameter("city");
        String province = req.getParameter("province");
        String address = req.getParameter("address");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String dob = req.getParameter("dob");
        String bankAccount = req.getParameter("bank_account");
        Part part = req.getPart("avatar");
        String avatar;

        Account accountSignUp = new Account(0, username, password, 3, null);
        Donor donorSignUp = new Donor(0, username, password, 3, null, email, city, province, address, name, null, phoneNumber, dob, bankAccount);

        if (userDAO.checkExistedUsername(username) != null) {
            req.setAttribute("signUpFailMessage", "Username existed");
            req.setAttribute("userSignUp", donorSignUp);
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }

        //        Check password confirm is true
        if (!password.equals(passwordConfirm)) {
            req.setAttribute("signUpFailMessage", "Please check the password confirmation again!");
            req.setAttribute("userSignUp", donorSignUp);
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }

        //        Check avatar is null or not to store an empty string
        if (part == null) {
            avatar = "";
        } else {
            String realPath = req.getServletContext().getRealPath("/img");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectories(Paths.get(realPath));
            }
            part.write(realPath + File.separator + fileName);
            avatar = "img/" + fileName;

            donorSignUp.setAvatar(avatar);
        }

        String regisOtp = OTPGenerate.generateOTP();

        session.setAttribute("regisOtp", regisOtp);

        boolean sendMailCheck = SendMail.sendConfirmEmail("success", email, "VERIFY YOUR EMAIL", "We receive your request to create a new account, please confirm by the OTP", "Here is your OTP", regisOtp);

        if (sendMailCheck == false) {
            req.getRequestDispatcher("failedPage.jsp").forward(req, resp);
        } else {
            session.setAttribute("partAvatar", part);

            req.setAttribute("passwordConfirm", passwordConfirm);
            req.setAttribute("accountSignUp", accountSignUp);
            req.setAttribute("donorSignUp", donorSignUp);

            req.getRequestDispatcher("confirmEmailRegis.jsp").forward(req, resp);

        }

    }

    protected void confirmSignUpUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String city = req.getParameter("city");
        String province = req.getParameter("province");
        String address = req.getParameter("address");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String dob = req.getParameter("dob");
        String bankAccount = req.getParameter("bank_account");
        String avatar = req.getParameter("avatarPath");

//        
//        User userSignUp = new User(0, username, password, email, city, province, address, name, "donor", null, phoneNumber, dob, bankAccount, null);
        Account accountSignUp = new Account(0, username, password, 3, null);
        Donor donorSignUp = new Donor(0, username, password, 3, null, email, city, province, address, name, avatar, phoneNumber, dob, bankAccount);

        try {

//                Encrypt password
            String saltValue = PasswordEncrypt.getSaltvalue(20);
            String encryptedPassword = PasswordEncrypt.generateSecurePassword(accountSignUp.getPassword(), saltValue);
            accountSignUp.setPassword(encryptedPassword);
            accountSignUp.setSalt(saltValue);

//                Sign up account
            int accountId = userDAO.signUpAccount(accountSignUp);
            donorSignUp.setAccountId(accountId);

//                Sign up donor
            userDAO.signUpDonor(donorSignUp);

            req.setAttribute("message", "Create account successfully");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("signUpFailMessage", "Create account failed");
            req.setAttribute("userSignUp", donorSignUp);
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }

    }

//    protected void confirmRegisUser() 
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
