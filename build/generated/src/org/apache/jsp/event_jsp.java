package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class event_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/includes/header.jsp");
    _jspx_dependants.add("/includes/navbar.jsp");
    _jspx_dependants.add("/includes/footer.jsp");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Events</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("    ");
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
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <!-- Page Header Start -->\r\n");
      out.write("        <div class=\"page-header\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-12\">\r\n");
      out.write("                        <h2>Upcoming Events</h2>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-12\">\r\n");
      out.write("                        <a href=\"\">Home</a>\r\n");
      out.write("                        <a href=\"\">Events</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Page Header End -->\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <!-- Event Start -->\r\n");
      out.write("        <div class=\"event\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"section-header text-center\">\r\n");
      out.write("                    <p>Upcoming Events</p>\r\n");
      out.write("                    <h2>Be ready for our upcoming charity events</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        <div class=\"event-item\">\r\n");
      out.write("                            <img src=\"img/event-1.jpg\" alt=\"Image\">\r\n");
      out.write("                            <div class=\"event-content\">\r\n");
      out.write("                                <div class=\"event-meta\">\r\n");
      out.write("                                    <p><i class=\"fa fa-calendar-alt\"></i>01-Jan-45</p>\r\n");
      out.write("                                    <p><i class=\"far fa-clock\"></i>8:00 - 10:00</p>\r\n");
      out.write("                                    <p><i class=\"fa fa-map-marker-alt\"></i>New York</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"event-text\">\r\n");
      out.write("                                    <h3>Lorem ipsum dolor sit</h3>\r\n");
      out.write("                                    <p>\r\n");
      out.write("                                        Lorem ipsum dolor sit amet elit. Neca pretim miura bitur facili ornare velit non vulpte liqum metus tortor\r\n");
      out.write("                                    </p>\r\n");
      out.write("                                    <a class=\"btn btn-custom\" href=\"\">Join Now</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        <div class=\"event-item\">\r\n");
      out.write("                            <img src=\"img/event-2.jpg\" alt=\"Image\">\r\n");
      out.write("                            <div class=\"event-content\">\r\n");
      out.write("                                <div class=\"event-meta\">\r\n");
      out.write("                                    <p><i class=\"fa fa-calendar-alt\"></i>01-Jan-45</p>\r\n");
      out.write("                                    <p><i class=\"far fa-clock\"></i>8:00 - 10:00</p>\r\n");
      out.write("                                    <p><i class=\"fa fa-map-marker-alt\"></i>New York</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"event-text\">\r\n");
      out.write("                                    <h3>Lorem ipsum dolor sit</h3>\r\n");
      out.write("                                    <p>\r\n");
      out.write("                                        Lorem ipsum dolor sit amet elit. Neca pretim miura bitur facili ornare velit non vulpte liqum metus tortor\r\n");
      out.write("                                    </p>\r\n");
      out.write("                                    <a class=\"btn btn-custom\" href=\"\">Join Now</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        <div class=\"event-item\">\r\n");
      out.write("                            <img src=\"img/event-1.jpg\" alt=\"Image\">\r\n");
      out.write("                            <div class=\"event-content\">\r\n");
      out.write("                                <div class=\"event-meta\">\r\n");
      out.write("                                    <p><i class=\"fa fa-calendar-alt\"></i>01-Jan-45</p>\r\n");
      out.write("                                    <p><i class=\"far fa-clock\"></i>8:00 - 10:00</p>\r\n");
      out.write("                                    <p><i class=\"fa fa-map-marker-alt\"></i>New York</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"event-text\">\r\n");
      out.write("                                    <h3>Lorem ipsum dolor sit</h3>\r\n");
      out.write("                                    <p>\r\n");
      out.write("                                        Lorem ipsum dolor sit amet elit. Neca pretim miura bitur facili ornare velit non vulpte liqum metus tortor\r\n");
      out.write("                                    </p>\r\n");
      out.write("                                    <a class=\"btn btn-custom\" href=\"\">Join Now</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-6\">\r\n");
      out.write("                        <div class=\"event-item\">\r\n");
      out.write("                            <img src=\"img/event-2.jpg\" alt=\"Image\">\r\n");
      out.write("                            <div class=\"event-content\">\r\n");
      out.write("                                <div class=\"event-meta\">\r\n");
      out.write("                                    <p><i class=\"fa fa-calendar-alt\"></i>01-Jan-45</p>\r\n");
      out.write("                                    <p><i class=\"far fa-clock\"></i>8:00 - 10:00</p>\r\n");
      out.write("                                    <p><i class=\"fa fa-map-marker-alt\"></i>New York</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"event-text\">\r\n");
      out.write("                                    <h3>Lorem ipsum dolor sit</h3>\r\n");
      out.write("                                    <p>\r\n");
      out.write("                                        Lorem ipsum dolor sit amet elit. Neca pretim miura bitur facili ornare velit non vulpte liqum metus tortor\r\n");
      out.write("                                    </p>\r\n");
      out.write("                                    <a class=\"btn btn-custom\" href=\"\">Join Now</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Event End -->\r\n");
      out.write("    \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Footer Start -->\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                    <div class=\"footer-contact\">\r\n");
      out.write("                        <h2>Our Head Office</h2>\r\n");
      out.write("                        <p><i class=\"fa fa-map-marker-alt\"></i>123 Street, New York, USA</p>\r\n");
      out.write("                        <p><i class=\"fa fa-phone-alt\"></i>+012 345 67890</p>\r\n");
      out.write("                        <p><i class=\"fa fa-envelope\"></i>info@example.com</p>\r\n");
      out.write("                        <div class=\"footer-social\">\r\n");
      out.write("                            <a class=\"btn btn-custom\" href=\"\"><i class=\"fab fa-twitter\"></i></a>\r\n");
      out.write("                            <a class=\"btn btn-custom\" href=\"\"><i class=\"fab fa-facebook-f\"></i></a>\r\n");
      out.write("                            <a class=\"btn btn-custom\" href=\"\"><i class=\"fab fa-youtube\"></i></a>\r\n");
      out.write("                            <a class=\"btn btn-custom\" href=\"\"><i class=\"fab fa-instagram\"></i></a>\r\n");
      out.write("                            <a class=\"btn btn-custom\" href=\"\"><i class=\"fab fa-linkedin-in\"></i></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                    <div class=\"footer-link\">\r\n");
      out.write("                        <h2>Popular Links</h2>\r\n");
      out.write("                        <a href=\"\">About Us</a>\r\n");
      out.write("                        <a href=\"\">Contact Us</a>\r\n");
      out.write("                        <a href=\"\">Popular Causes</a>\r\n");
      out.write("                        <a href=\"\">Upcoming Events</a>\r\n");
      out.write("                        <a href=\"\">Latest Blog</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                    <div class=\"footer-link\">\r\n");
      out.write("                        <h2>Useful Links</h2>\r\n");
      out.write("                        <a href=\"\">Terms of use</a>\r\n");
      out.write("                        <a href=\"\">Privacy policy</a>\r\n");
      out.write("                        <a href=\"\">Cookies</a>\r\n");
      out.write("                        <a href=\"\">Help</a>\r\n");
      out.write("                        <a href=\"\">FQAs</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                    <div class=\"footer-newsletter\">\r\n");
      out.write("                        <h2>Newsletter</h2>\r\n");
      out.write("                        <form>\r\n");
      out.write("                            <input class=\"form-control\" placeholder=\"Email goes here\">\r\n");
      out.write("                            <button class=\"btn btn-custom\">Submit</button>\r\n");
      out.write("                            <label>Don't worry, we don't spam!</label>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container copyright\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <p>&copy; <a href=\"#\">Your Site Name</a>, All Right Reserved.</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6\">\r\n");
      out.write("                    <p>Designed By <a href=\"https://htmlcodex.com\">HTML Codex</a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Footer End -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Back to top button -->\r\n");
      out.write("    <a href=\"#\" class=\"back-to-top\"><i class=\"fa fa-chevron-up\"></i></a>\r\n");
      out.write("\r\n");
      out.write("    <!-- Pre Loader -->\r\n");
      out.write("    <div id=\"loader\" class=\"show\">\r\n");
      out.write("        <div class=\"loader\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- JavaScript Libraries -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/easing/easing.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/owlcarousel/owl.carousel.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/waypoints/waypoints.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/counterup/counterup.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/parallax/parallax.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Contact Javascript File -->\r\n");
      out.write("    <script src=\"mail/jqBootstrapValidation.min.js\"></script>\r\n");
      out.write("    <script src=\"mail/contact.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Template Javascript -->\r\n");
      out.write("    <script src=\"js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
