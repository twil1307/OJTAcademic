/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package News;

import User.Account;
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
@WebServlet(name = "NewsController", urlPatterns = {"/news"})
public class NewsController extends HttpServlet {

    private final NewsService newsService = new NewsService();
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
        String action = req.getParameter("action");

        switch (action) {
            case "list":
                getListNews(req, resp);
                break;
            case "single":
                getSingleNews(req, resp);
                break;
            case "update": 
                getUpdateNews(req, resp);
                break;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
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

    private void getSingleNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int newsId = Integer.parseInt(req.getParameter("newsId"));

        News news = newsService.getSingleNews(newsId);
        Account author = userService.getUserByID(news.getUserId());
        List<News> recentNews = newsService.getRecentNews(newsId);
        System.out.println(news);
        System.out.println(recentNews);

        req.setAttribute("author", author);
        req.setAttribute("news", news);
        req.setAttribute("recentNews", recentNews);
        
        session = req.getSession(true);
        session.setAttribute("urlHistory", "news?action=single&newsId=" + newsId);

        req.getRequestDispatcher("newsDetail.jsp").forward(req, resp);
    }

    private void getListNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         final int PAGE_SIZE = 6;
        
        HttpSession session = req.getSession(false);
        String pageStr = req.getParameter("page");
        
        List<News> listNews = null;
        int totalNews = newsService.getTotalNews();
        int pageNumber = (int) Math.floor(totalNews/PAGE_SIZE) + (totalNews%PAGE_SIZE > 0 ? 1 : 0);
        
        System.out.println("Page number " + pageNumber);

        
        if (pageStr != null ) {
            int page = Integer.parseInt(pageStr);
            int beginElement = (page - 1) * PAGE_SIZE;
            listNews = newsService.getListNews(beginElement, PAGE_SIZE);
            
        } else {
            pageStr="1";
            int beginElement = (Integer.parseInt(pageStr) - 1) * PAGE_SIZE;
            listNews = newsService.getListNews(beginElement, PAGE_SIZE);
        }
        
        System.out.println(pageStr);
       
        String urlHistory = "news?action=list&page="+pageStr;

        session = req.getSession(true);
        session.setAttribute("urlHistory", urlHistory);
        req.setAttribute("listNews", listNews);
        req.setAttribute("totalNews", totalNews);
        req.setAttribute("page", pageStr);
        req.setAttribute("pageNumber", pageNumber);
        req.getRequestDispatcher("newsList.jsp").forward(req, resp);
    }
}
