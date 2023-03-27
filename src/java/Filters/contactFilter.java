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
        urlPatterns = {"/contact"},
        filterName = "contactFilter"
)
public class contactFilter implements Filter {

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
        String urlHistory = (String) session.getAttribute("urlHistory");

        Account acc = (Account) session.getAttribute("user");

        if (acc!=null) {
            chain.doFilter(request, response);
        } else {
            if (urlHistory != null && !urlHistory.contains("contact")) {
                res.sendRedirect(urlHistory);
            } else {
                res.sendRedirect("home");
            }

        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
}
