/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operator;

import News.*;
import Schedule.ScheduleController;
import User.UserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@WebServlet(name = "OperatorController", urlPatterns = {"/operator"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class OperatorController extends HttpServlet {

    private final NewsService newsService = new NewsService();
    private final UserService userService = new UserService();
    private final OperatorService operatorService = new OperatorService();

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
        int programId = Integer.parseInt(req.getParameter("programId"));
        List<Operator> operators = operatorService.getOperatorsByProgramId(programId);

        System.out.println(operators.size());
        
        req.setAttribute("operators", operators);
        req.setAttribute("programId", programId);
        req.getRequestDispatcher("operator.jsp").forward(req, resp);
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
        
        int investorNumber = Integer.parseInt(req.getParameter("operator-days"));
        
        int programId = Integer.parseInt(req.getParameter("programId"));
        List<Operator> listOperator = new ArrayList<>();
        String imageUploadPath = req.getServletContext().getRealPath("");

        for (int i = 0; i < investorNumber; i++) {
            String operatorDate = req.getParameter("operatorDate-" + (i + 1));
            String operatorDetailDes = req.getParameter("operatorDetailDes-" + (i + 1));
            double actualExpense =Double.parseDouble(req.getParameter("actualExpense-" + (i + 1)));
            List<OperatorImage> activitiesImage = new ArrayList();
            List<OperatorImage> bilImage = new ArrayList();
           
            
            
             try {
                        for (Part part : req.getParts()) {
                            if (part.getName().equals("activities-" + (i + 1))) {
                                String imgPath = "img/" + programId + part.getSubmittedFileName();
                                OperatorImage image = new OperatorImage(0, programId, imgPath);
                                activitiesImage.add(image);
                            }
                            
                            if (part.getName().equals("billImg-" + (i + 1))) {
                                String imgPath = "img/" + programId + part.getSubmittedFileName();
                                OperatorImage image = new OperatorImage(0, programId, imgPath);
                                bilImage.add(image);
                            }
                        }
                    } catch (IOException | ServletException ex) {
                        Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            listOperator.add(new Operator(0, programId, operatorDate, operatorDetailDes, actualExpense, activitiesImage, bilImage));
   
        }
        
        List<Part> activitiesParts = req.getParts().stream()
                .filter(part -> part.getName().matches("activities-(.*)"))
                .collect(Collectors.toList());
        
        List<Part> bilParts = req.getParts().stream()
                .filter(part -> part.getName().matches("billImg-(.*)"))
                .collect(Collectors.toList());
        
        operatorService.registerOperator(listOperator, activitiesParts, bilParts, ""+programId, imageUploadPath);
        
        req.getRequestDispatcher("successPage.jsp").forward(req, resp);

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
    
    private void getUpdateNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int newsId = Integer.parseInt(req.getParameter("newsId"));
        
        News news = newsService.getSingleNews(newsId);
        
        req.setAttribute("news", news);
        req.getRequestDispatcher("newsUpdate.jsp").forward(req, resp);
    }

}
