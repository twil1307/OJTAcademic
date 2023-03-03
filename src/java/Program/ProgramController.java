/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProgramController", urlPatterns = {"/program"})
public class ProgramController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        
        switch(action) {
            case "register": 
                handleRegisterProgram(req);
            default: 
                
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void handleRegisterProgram(HttpServletRequest req) {
        String programName = req.getParameter("programName");
        String shortDes = req.getParameter("shortDes");
        String detailDes = req.getParameter("detailDes");
        double goalAmount = Double.parseDouble(req.getParameter("goalAmount"));
//        String programName = req.getParameter("startDate");
//        String programName = req.getParameter("endDate");
//        String programName = req.getParameter("city");
//        String programName = req.getParameter("province");        
//        String programName = req.getParameter("address");
//        String programName = req.getParameter("scheStartDate");        
//        String programName = req.getParameter("scheEndDate");

    }
}
