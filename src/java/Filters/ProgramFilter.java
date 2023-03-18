/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import User.Account;
import User.UserDAO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toten
 */
@WebFilter(
        urlPatterns = {"/program", "/schedule", "/operator", "/news-manage"},
        filterName = "programFilter"
)
public class ProgramFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
//        String urlHistory = (String) session.getAttribute("urlHistory");
        String action = req.getParameter("action");
        String urlHistory = (String) session.getAttribute("urlHistory");
        
        
        if(action.equals("register") || action.equals("update") || action.equals("delete")) {
            Account acc = (Account) session.getAttribute("user");
            
            if(acc.getRole() == 1 || acc.getRole() ==2) {
                chain.doFilter(request, response);
            } else {
                if(urlHistory!=null) {
                    res.sendRedirect(urlHistory);
                } else {
                    res.sendRedirect("home");
                }
                
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
}
