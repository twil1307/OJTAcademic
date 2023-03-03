/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Security.PasswordEncrypt;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        
        User userSignUp = new User(0, username, password, email, city, province, address, name, "donor", null, phoneNumber, dob, bankAccount, null);
        


//        Check avatar is null or not to store an empty string
        if (part == null) {
            avatar = "";
        } else {
            String realPath = req.getServletContext().getRealPath("/images");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

            if (!Files.exists(Paths.get(realPath))) {
                Files.createDirectories(Paths.get(realPath));
            }
            part.write(realPath + "/" + fileName);
            avatar = "images/" + fileName;
            
            userSignUp.setAvatar(avatar);
        }
        
        //        Check password confirm is true

        if(!password.equals(passwordConfirm)) {
            req.setAttribute("signUpFailMessage", "Please check the password confirmation again!");
            req.setAttribute("userSignUp", userSignUp);
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }

//        Check if username is empty or existed
        if (!username.isEmpty() && userDAO.checkExistedUsername(username) == null) {
            try {
                
//                Encrypt password
                String saltValue = PasswordEncrypt.getSaltvalue(20);
                String encryptedPassword = PasswordEncrypt.generateSecurePassword(userSignUp.getPassword(), saltValue);
                userSignUp.setPassword(encryptedPassword);
                userSignUp.setSalt(saltValue);
                
//                Sign up user
                userDAO.signUpUser(userSignUp);
                
                req.setAttribute("signUpSuccessMessage", "Create account successfully");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } catch (Exception e) {
                req.setAttribute("signUpFailMessage", "Create account failed");
                req.setAttribute("userSignUp", userSignUp);
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("signUpFailMessage", "Username existed");
            req.setAttribute("userSignUp", userSignUp);
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
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
