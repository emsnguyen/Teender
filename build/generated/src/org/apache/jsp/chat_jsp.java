package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import java.util.*;

public final class chat_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("<script src=\"//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<link href=\"css/chat.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<script src=\"js/chat.js\" type=\"text/javascript\"></script>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Nhắn tin</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"chat_window\">\n");
      out.write("            <div class=\"top_menu\">\n");
      out.write("                <div class=\"buttons\">\n");
      out.write("                    <div class=\"button close\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"button minimize\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"button maximize\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"title\">Chat</div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <ul class=\"messages\">\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"bottom_wrapper clearfix\">\n");
      out.write("                <div class=\"message_input_wrapper\">\n");
      out.write("                    <input class=\"message_input\" placeholder=\"Type your message here...\" />\n");
      out.write("                </div><div class=\"send_message\">\n");
      out.write("                    <div class=\"icon\"></div>\n");
      out.write("                    <div class=\"text\">Send</div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"message_template\">\n");
      out.write("            <li class=\"message\">\n");
      out.write("                <div class=\"avatar\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"text_wrapper\">\n");
      out.write("                    <div class=\"text\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
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
