/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Dashboard.DashBoardService;
import News.News;
import News.NewsService;
import Operator.Operator;
import Operator.OperatorService;
import Operator.OperatorVO;
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
@WebServlet(name = "ProgramHomeController", urlPatterns = {"/home"})
public class ProgramHomeController extends HttpServlet {

    private final ProgramService service = new ProgramService();
    private final NewsService newsService = new NewsService();
    private final OperatorService operatorService = new OperatorService();
    private final DashBoardService dashBoardService = new DashBoardService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
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
        List<Program> listPrograms = service.getListProgram(1, 6);
        List<News> getListNews = newsService.getListNews(1, 3);
        List<OperatorVO> operators = operatorService.getOperatorsHome();
        long totalRaised = dashBoardService.getTotal("all");
        long totalGoal = dashBoardService.getTotalGoal();

        System.out.println(totalGoal);
        System.out.println(totalRaised);

        String urlHistory = "home";
        session = req.getSession(true);
        session.setAttribute("urlHistory", urlHistory);

        req.setAttribute("operators", operators);
        req.setAttribute("totalRaised", totalRaised);
         req.setAttribute("totalGoal", totalGoal);
        req.setAttribute("listPrograms", listPrograms);
        req.setAttribute("getListNews", getListNews);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
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
}
