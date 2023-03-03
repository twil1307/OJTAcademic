package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class program_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/includes/header.jsp");
    _jspx_dependants.add("/includes/navbar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Favicon -->\r\n");
      out.write("        <link href=\"img/favicon.ico\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Google Font -->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap\"\r\n");
      out.write("              rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- CSS Libraries -->\r\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"lib/flaticon/font/flaticon.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"lib/animate/animate.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Template Stylesheet -->\r\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <title>Program Register</title>\n");
      out.write("        <link href=\"css/program.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body style=\"background-color: #dcf9fc\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Nav Bar Start -->\r\n");
      out.write("    <div class=\"navbar navbar-expand-lg bg-dark navbar-dark\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <a href=\"index.jsp\" class=\"navbar-brand\">FANTASTIC5</a>\r\n");
      out.write("            <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"collapse navbar-collapse justify-content-between\" id=\"navbarCollapse\">\r\n");
      out.write("                <div class=\"navbar-nav ml-auto\">\r\n");
      out.write("                    <a href=\"index.jsp\" class=\"nav-item nav-link\">Home</a>\r\n");
      out.write("                    <a href=\"about.jsp\" class=\"nav-item nav-link\">About</a>\r\n");
      out.write("                    <a href=\"causes.jsp\" class=\"nav-item nav-link\">Causes</a>\r\n");
      out.write("                    <a href=\"event.jsp\" class=\"nav-item nav-link\">Events</a>\r\n");
      out.write("                    <a href=\"blog.jsp\" class=\"nav-item nav-link\">Blog</a>\r\n");
      out.write("                    <div class=\"nav-item dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\">Pages</a>\r\n");
      out.write("                        <div class=\"dropdown-menu\">\r\n");
      out.write("                            <a href=\"detail.jsp\" class=\"dropdown-item\">Detail Page</a>\r\n");
      out.write("                            <a href=\"service.jsp\" class=\"dropdown-item\">What We Do</a>\r\n");
      out.write("                            <a href=\"team.jsp\" class=\"dropdown-item\">Meet The Team</a>\r\n");
      out.write("                            <a href=\"donate.jsp\" class=\"dropdown-item\">Donate Now</a>\r\n");
      out.write("                            <a href=\"volunteer.html\" class=\"dropdown-item\">Become A Volunteer</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <a href=\"contact.jsp\" class=\"nav-item nav-link\">Contact</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"nav-item dropdown\">\r\n");
      out.write("                    <a class=\"nav-link dropdown-toggle text-light\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                        <i class=\"fas fa-user\"></i>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"login.jsp\">Log in</a>\r\n");
      out.write("                        <a class=\"dropdown-item\" href=\"signup.jsp\">Sign Up</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Nav Bar End -->\r\n");
      out.write("\n");
      out.write("       <main>\n");
      out.write("            <form method=\"POST\" action=\"/OJT_Mock/program?action=register\" id=\"form\" class=\"container\">\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"programName\">Program Name</label>\n");
      out.write("                    <input \n");
      out.write("                        type=\"text\" \n");
      out.write("                        class=\"form-control form-control-lg\" \n");
      out.write("                        id=\"programName\"\n");
      out.write("                        aria-describedby=\"programName\" \n");
      out.write("                        name=\"programName\"\n");
      out.write("                        placeholder=\"Enter Program Name\"\n");
      out.write("                        required\n");
      out.write("                    >\n");
      out.write("               </div>\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"shortDescription\">Short Description</label>\n");
      out.write("                    <input \n");
      out.write("                        type=\"text\" \n");
      out.write("                        class=\"form-control\" \n");
      out.write("                        id=\"detailDescription\"\n");
      out.write("                        aria-describedby=\"detailDescription\" \n");
      out.write("                        placeholder=\"Enter Short Description\"\n");
      out.write("                        name=\"detailDescription\"\n");
      out.write("                        required\n");
      out.write("                    >\n");
      out.write("                    >\n");
      out.write("               </div>\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"detailDescription\">Detail Description</label>\n");
      out.write("                    <textarea \n");
      out.write("                        type=\"text\" \n");
      out.write("                        class=\"form-control\" \n");
      out.write("                        id=\"detailDescription\"\n");
      out.write("                        aria-describedby=\"detailDescription\" \n");
      out.write("                        placeholder=\"Enter Detail Description\"\n");
      out.write("                        style=\"height: 140px; min-height: 36px\"\n");
      out.write("                        name=\"detailDescription\"\n");
      out.write("                        required\n");
      out.write("                    >\n");
      out.write("                    ></textarea>\n");
      out.write("               </div>\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                   <label for=\"goalAmount\">Goal Amount</label>\n");
      out.write("                    <input \n");
      out.write("                        type=\"number\" \n");
      out.write("                        class=\"form-control\" \n");
      out.write("                        id=\"goalAmount\"\n");
      out.write("                        aria-describedby=\"goalAmount\" \n");
      out.write("                        placeholder=\"Enter goal amount\"\n");
      out.write("                        name=\"goalAmount\"\n");
      out.write("                        required\n");
      out.write("                    >\n");
      out.write("               </div>\n");
      out.write("                <div class=\"form-row mb-3\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <label for=\"startDate\">Start Date</label>\n");
      out.write("                        <input \n");
      out.write("                            type=\"date\" \n");
      out.write("                            class=\"form-control\" \n");
      out.write("                            id=\"goalAmount\"\n");
      out.write("                            aria-describedby=\"startDate\" \n");
      out.write("                            placeholder=\"Enter Start Date\"\n");
      out.write("                            name=\"startDate\"\n");
      out.write("                            required\n");
      out.write("                        >\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <label for=\"endDate\">End Date</label>\n");
      out.write("                        <input \n");
      out.write("                            type=\"date\" \n");
      out.write("                            class=\"form-control\" \n");
      out.write("                            id=\"endDate\"\n");
      out.write("                            aria-describedby=\"endDate\" \n");
      out.write("                            placeholder=\"Enter End Date\"\n");
      out.write("                            name=\"endDate\"\n");
      out.write("                            required\n");
      out.write("                        >\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-row mb-3\">\n");
      out.write("                     <div class=\"col\">\n");
      out.write("                         <label for=\"city\">City</label>\n");
      out.write("                         <input \n");
      out.write("                             type=\"text\" \n");
      out.write("                             class=\"form-control\" \n");
      out.write("                             id=\"city\"\n");
      out.write("                             aria-describedby=\"city\" \n");
      out.write("                             placeholder=\"Enter City\"\n");
      out.write("                             name=\"city\"\n");
      out.write("                             required\n");
      out.write("                         >\n");
      out.write("                     </div>\n");
      out.write("                     <div class=\"col\">\n");
      out.write("                         <label for=\"province\">Province</label>\n");
      out.write("                         <input \n");
      out.write("                             type=\"text\" \n");
      out.write("                             class=\"form-control\" \n");
      out.write("                             id=\"province\"\n");
      out.write("                             aria-describedby=\"province\" \n");
      out.write("                             placeholder=\"Enter city\"\n");
      out.write("                             name=\"province\"\n");
      out.write("                             required\n");
      out.write("                         >\n");
      out.write("                     </div>\n");
      out.write("                 </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"address\">Address</label>\n");
      out.write("                     <input \n");
      out.write("                         type=\"text\" \n");
      out.write("                         class=\"form-control\" \n");
      out.write("                         id=\"address\"\n");
      out.write("                         aria-describedby=\"address\" \n");
      out.write("                         placeholder=\"Enter Address\"\n");
      out.write("                         name=\"address\"\n");
      out.write("                         required\n");
      out.write("                     >\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-row mb-3\">\n");
      out.write("                     <div class=\"col\">\n");
      out.write("                         <label for=\"scheduleStartDate\">Schedule Start Date</label>\n");
      out.write("                         <input \n");
      out.write("                             type=\"date\" \n");
      out.write("                             class=\"form-control\" \n");
      out.write("                             id=\"scheduleStartDate\"\n");
      out.write("                             aria-describedby=\"scheduleStartDate\" \n");
      out.write("                             placeholder=\"Enter Start Date\"\n");
      out.write("                             name=\"scheduleStartDate\"\n");
      out.write("                             required\n");
      out.write("                         >\n");
      out.write("                     </div>\n");
      out.write("                     <div class=\"col\">\n");
      out.write("                         <label for=\"scheduleEndDate\">Schedule End Date</label>\n");
      out.write("                         <input \n");
      out.write("                             type=\"date\" \n");
      out.write("                             class=\"form-control\" \n");
      out.write("                             id=\"endDate\"\n");
      out.write("                             aria-describedby=\"scheduleEndDate\" \n");
      out.write("                             placeholder=\"Enter End Date\"\n");
      out.write("                             name=\"scheduleEndDate\"\n");
      out.write("                             required\n");
      out.write("                         >\n");
      out.write("                     </div>\n");
      out.write("                 </div>\n");
      out.write("               <button class=\"mt-5 btn btn-primary container-fluid\">Submit</button>\n");
      out.write("           </form>\n");
      out.write("       </main>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
