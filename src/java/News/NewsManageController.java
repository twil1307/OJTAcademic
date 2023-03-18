/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package News;

import Program.ProgramImage;
import User.Account;
import java.io.File;
import java.io.IOException;
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

/**
 *
 * @author toten
 */
@WebServlet(name = "NewsCreateController", urlPatterns = {"/news-manage"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
    maxFileSize = 1024 * 1024 * 50, // 50 MB
    maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class NewsManageController extends HttpServlet {
    
    private final NewsService service = new NewsService();

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
        req.getRequestDispatcher("newsCreate.jsp").forward(req, resp);
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
            case "update": 
                updateNews(req, resp);
                break;
             case "register": 
                regisNews(req, resp);
                break;
             case "delete": 
                 deleteNews(req, resp);
            default:
                
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
    
    private void deleteNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int newsId = Integer.parseInt(req.getParameter("newsId"));
        
        service.deleteNewsById(newsId);

        String urlHistory = (String) session.getAttribute("urlHistory");
                System.out.println(urlHistory);
                
                if(urlHistory!=null) {
                    resp.sendRedirect(urlHistory);
                } else {
                    resp.sendRedirect("news?action=list");
                }
        
    }
    
    private void updateNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int newsId = Integer.parseInt(req.getParameter("newsId"));
        
        String newsTitle = req.getParameter("newsTitle");
        String shortDes = req.getParameter("shortDes");
        String newsDes = req.getParameter("newsDes");
        List<String> newsImgs = new ArrayList();
        List<Part> newsParts = new ArrayList();
        Account account = (Account) session.getAttribute("user");
        
//        String titleFormat = newsTitle.trim().replaceAll("\\s+", " ");
        
        String imageUploadPath = req.getServletContext().getRealPath("");
        try {
            for (Part part : req.getParts()) {
                
                if (part.getName().equals("newsImgs") && !part.getSubmittedFileName().isEmpty()) {
                    String name = part.getSubmittedFileName();
                    String fileName = imageUploadPath + File.separator + newsTitle + part.getSubmittedFileName();
                    newsImgs.add(fileName);
                    newsParts.add(part);
                }
            }
        } catch(IOException | ServletException e) {
            throw new Error("Input images not found");                                                                                      
        }
        
        News news = new News(newsId, newsTitle, newsDes, shortDes, null, account.getAccountId(), newsImgs);

        service.updateNews(news, newsParts, imageUploadPath);
        
        req.getRequestDispatcher("successPage.jsp").forward(req, resp);
    }
    
    private void regisNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        
        String newsTitle = req.getParameter("newsTitle");
        String shortDes = req.getParameter("shortDes");
        String newsDes = req.getParameter("newsDes");
        List<String> newsImgs = new ArrayList();
        List<Part> newsParts = new ArrayList();
        Account account = (Account) session.getAttribute("user");
        
//        String titleFormat = newsTitle.trim().replaceAll("\\s+", " ");
        
        String imageUploadPath = req.getServletContext().getRealPath("");
        try {
            for (Part part : req.getParts()) {
                if (part.getName().equals("newsImgs")) {
                    String fileName = imageUploadPath + File.separator + newsTitle + part.getSubmittedFileName();
                    newsImgs.add(fileName);
                    newsParts.add(part);
                }
            }
        } catch(IOException | ServletException e) {
            throw new Error("Input images not found");                                                                                      
        }
        
        News news = new News(0, newsTitle, newsDes, shortDes, null, account.getAccountId(), newsImgs);
        
        service.createNews(news, newsParts, imageUploadPath);
        
        resp.sendRedirect("news?action=list");
    }
}
