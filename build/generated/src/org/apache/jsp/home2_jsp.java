package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/precheck.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_redirect_url_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_redirect_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_redirect_url_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<title>Teender</title>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("<style>\n");
      out.write("    body {font-family: \"Lato\", sans-serif}\n");
      out.write("    .mySlides {display: none}\n");
      out.write("    img {\n");
      out.write("        width: 100%;\n");
      out.write("    }\n");
      out.write("    #avatar {\n");
      out.write("        max-height: 50px;\n");
      out.write("        max-width: 50px;\n");
      out.write("    }\n");
      out.write("    .red {\n");
      out.write("        color: #33CCFF;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!-- Navbar -->\n");
      out.write("<div class=\"w3-top\">\n");
      out.write("  <div class=\"w3-bar w3-black w3-card\">\n");
      out.write("    <a class=\"w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0)\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("    <a href=\"index.html\" class=\"w3-bar-item w3-button w3-padding-large\">Trang chủ</a>\n");
      out.write("    <a href=\"choose?userID=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${info.nickname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">Tìm bạn</a>\n");
      out.write("    <a href=\"chat\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">Nhắn tin</a>\n");
      out.write("    <a href=\"chatwithstrangers.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">Chat với người lạ</a>\n");
      out.write("    <a href=\"#sendfeedback\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">Liên hệ</a>\n");
      out.write("    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avatarPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" \n");
      out.write("                id=\"avatar\"\n");
      out.write("                alt=\"avatar\"\n");
      out.write("                style=\"max-width:50px; max-height: 50px;\"\n");
      out.write("                />\n");
      out.write("    <div class=\"w3-dropdown-hover w3-hide-small\">\n");
      out.write("        <button class=\"w3-padding-large w3-button\" title=\"More\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        </button>     \n");
      out.write("      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n");
      out.write("        <a href=\"changepassword\" class=\"w3-bar-item w3-button\">Đổi mật khẩu</a>\n");
      out.write("        <a href=\"changeavatar\" class=\"w3-bar-item w3-button\">Đổi avatar</a>\n");
      out.write("        <a href=\"setting\" class=\"w3-bar-item w3-button\">Cài đặt tài khoản</a>\n");
      out.write("        <a href=\"logout\" class=\"w3-bar-item w3-button\">Thoát</a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <a href=\"javascript:void(0)\" class=\"w3-padding-large w3-hover-red w3-hide-small w3-right\"><i class=\"fa fa-search\"></i></a>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<!--\n");
      out.write(" Navbar on small screens \n");
      out.write("<div id=\"navDemo\" class=\"w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top\" style=\"margin-top:46px\">\n");
      out.write("  <a href=\"#band\" class=\"w3-bar-item w3-button w3-padding-large\">BAND</a>\n");
      out.write("  <a href=\"#tour\" class=\"w3-bar-item w3-button w3-padding-large\">TOUR</a>\n");
      out.write("  <a href=\"#contact\" class=\"w3-bar-item w3-button w3-padding-large\">CONTACT</a>\n");
      out.write("  <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large\">MERCH</a>\n");
      out.write("</div>-->\n");
      out.write("\n");
      out.write("<!-- Page content -->\n");
      out.write("<div class=\"w3-content\" style=\"max-width:2000px;margin-top:46px; min-height: 300px\">\n");
      out.write("\n");
      out.write("  <!-- Automatic Slideshow Images -->\n");
      out.write("  <div class=\"mySlides w3-display-container w3-center\">\n");
      out.write("    <!--<img src=\"/w3images/la.jpg\" style=\"width:100%\">-->\n");
      out.write("    <img src=\"img/1.jpg\" alt=\"\"/>\n");
      out.write("    <div class=\"w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small\">\n");
      out.write("      <h3>Giao diện đẹp, đơn giản, thân thiện</h3>\n");
      out.write("      <p><b>Dễ thao tác và sử dụng</b></p>   \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"mySlides w3-display-container w3-center\">\n");
      out.write("      <img src=\"img/7.jpg\" alt=\"\"/>\n");
      out.write("    <div class=\"w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small\">\n");
      out.write("      <h3>Bảo mật tuyệt đối</h3>\n");
      out.write("      <p><b>Mang lại trải nghiệm tuyệt vời cho người dùng với chính sách bảo mật mạnh mẽ</b></p>    \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"mySlides w3-display-container w3-center\">\n");
      out.write("    <img src=\"img/6.jpg\" alt=\"\"/>\n");
      out.write("    <div class=\"w3-display-bottommiddle w3-container w3-text-white w3-padding-32 w3-hide-small\">\n");
      out.write("      <h3>Cơ sở dữ liệu lớn</h3>\n");
      out.write("      <p><b>Dễ dàng tìm kiếm và kết bạn muôn phương</b></p>    \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- The Band Section -->\n");
      out.write("  <div class=\"w3-container w3-content w3-center w3-padding-64\" style=\"max-width:800px\" id=\"band\">\n");
      out.write("    <h2 class=\"w3-wide\">TEENDER</h2>\n");
      out.write("    <p class=\"w3-opacity\"><i>Hẹn hò chưa bao giờ dễ dàng đến thế</i></p>\n");
      out.write("    <p class=\"w3-justify\">Với giao diện đơn giản và thân thiện, Teender đang dần chiếm được cảm tình từ người dùng...</p>\n");
      out.write("    <div class=\"w3-row w3-padding-32\">\n");
      out.write("      <div class=\"w3-third\">\n");
      out.write("        <p>Sơn</p>\n");
      out.write("        <img src=\"uploads/teender (11).jpg\" class=\"w3-round w3-margin-bottom\" alt=\"Random Name\" style=\"width:165px; height:165px\">\n");
      out.write("      </div>\n");
      out.write("      <div class=\"w3-third\">\n");
      out.write("        <p>Ngọc Anh</p>\n");
      out.write("        <img src=\"uploads/teender (12).jpg\" class=\"w3-round w3-margin-bottom\" alt=\"Random Name\" style=\"width:165px; height:165px\">\n");
      out.write("      </div>\n");
      out.write("      <div class=\"w3-third\">\n");
      out.write("        <p>Phong</p>\n");
      out.write("        <img src=\"uploads/teender (10).jpg\" class=\"w3-round\" alt=\"Random Name\" style=\"width:165px; height:165px\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- The Tour Section -->\n");
      out.write("  <div class=\"w3-black\" id=\"tour\">\n");
      out.write("    <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:800px\">\n");
      out.write("      <h2 class=\"w3-wide w3-center\">Người dùng nói gì về Teender</h2>\n");
      out.write("      <!--<p class=\"w3-opacity w3-center\"><i>Remember to book your tickets!</i></p><br>-->\n");
      out.write("\n");
      out.write("      <div class=\"w3-row-padding w3-padding-32\" style=\"margin:0 -16px\">\n");
      out.write("        <div class=\"w3-third w3-margin-bottom\">\n");
      out.write("          <img src=\"uploads/teender (3).jpg\" alt=\"\" style=\"width:100%; height: 250px\" class=\"w3-hover-opacity\"/>\n");
      out.write("          <div class=\"w3-container w3-white\">\n");
      out.write("            <p><b>Hà</b></p>\n");
      out.write("            <p class=\"w3-opacity\">Fri 27 Nov 2016</p>\n");
      out.write("            <p>Teender là ứng dụng tốt nhất tôi từng dùng</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"w3-third w3-margin-bottom\">\n");
      out.write("          <img src=\"uploads/teender (7).jpg\" alt=\"\" style=\"width:100%; height: 250px\" class=\"w3-hover-opacity\"/>\n");
      out.write("          <div class=\"w3-container w3-white\">\n");
      out.write("            <p><b>Mai</b></p>\n");
      out.write("            <p class=\"w3-opacity\">Sat 28 Nov 2016</p>\n");
      out.write("            <p>Ứng dụng rất tiện lợi.Có nhiều chức năng và giao diện rất đẹp</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"w3-third w3-margin-bottom\">\n");
      out.write("          <img src=\"uploads/teender (9).jpg\" alt=\"\" style=\"width:100%; height: 250px\" class=\"w3-hover-opacity\"/>\n");
      out.write("          <div class=\"w3-container w3-white\">\n");
      out.write("            <p><b>Lan</b></p>\n");
      out.write("            <p class=\"w3-opacity\">Sun 29 Nov 2016</p>\n");
      out.write("            <p>5 sao!</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- The Contact Section -->\n");
      out.write("  <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:800px\" id=\"contact\">\n");
      out.write("    <h2 class=\"w3-wide w3-center\">Gửi feedback về dịch vụ của chúng tôi</h2>\n");
      out.write("    <!--<p class=\"w3-opacity w3-center\"><i>Fan? Drop a note!</i></p>-->\n");
      out.write("    <div class=\"w3-row w3-padding-32\">\n");
      out.write("      <div class=\"w3-col m6 w3-large w3-margin-bottom\">\n");
      out.write("        <i class=\"fa fa-map-marker\" style=\"width:30px\"></i> Đại học FPT, Hòa Lạc<br>\n");
      out.write("        <i class=\"fa fa-phone\" style=\"width:30px\"></i> Phone: +00 151515<br>\n");
      out.write("        <i class=\"fa fa-envelope\" style=\"width:30px\"> </i> Email: fpt.edu@gmail.com<br>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"w3-col m6\">\n");
      out.write("        <form action=\"thankyou.jsp\" id=\"sendfeedback\">\n");
      out.write("          <div class=\"w3-row-padding\" style=\"margin:0 -16px 8px -16px\">\n");
      out.write("            <div class=\"w3-half\">\n");
      out.write("              <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Name\" required name=\"Tên\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"w3-half\">\n");
      out.write("              <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Email\" required name=\"Email\">\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("            <textarea class=\"w3-input w3-border\" placeholder=\"Tin nhắn\" required name=\"Message\"\n");
      out.write("                      rows=\"5\">\n");
      out.write("            </textarea>\n");
      out.write("          <button class=\"w3-button w3-black w3-section w3-right\" type=\"submit\">GỬI</button>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("<!-- End Page Content -->\n");
      out.write("\n");
      out.write("<!-- Footer -->\n");
      out.write("<footer class=\"w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge\">\n");
      out.write("  <i class=\"fa fa-facebook-official w3-hover-opacity\"></i>\n");
      out.write("  <!--<i class=\"fa fa-instagram w3-hover-opacity\"></i>-->\n");
      out.write("  <!--<i class=\"fa fa-snapchat w3-hover-opacity\"></i>-->\n");
      out.write("  <i class=\"fa fa-pinterest-p w3-hover-opacity\"></i>\n");
      out.write("  <i class=\"fa fa-twitter w3-hover-opacity\"></i>\n");
      out.write("  <i class=\"fa fa-linkedin w3-hover-opacity\"></i>\n");
      out.write("  <p class=\"w3-medium\">Adapted by <a href=\"#\" target=\"_blank\">Teender Team</a> with <3 </p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("// Automatic Slideshow - change image every 4 seconds\n");
      out.write("var myIndex = 0;\n");
      out.write("carousel();\n");
      out.write("\n");
      out.write("function carousel() {\n");
      out.write("    var i;\n");
      out.write("    var x = document.getElementsByClassName(\"mySlides\");\n");
      out.write("    for (i = 0; i < x.length; i++) {\n");
      out.write("       x[i].style.display = \"none\";  \n");
      out.write("    }\n");
      out.write("    myIndex++;\n");
      out.write("    if (myIndex > x.length) {myIndex = 1}    \n");
      out.write("    x[myIndex-1].style.display = \"block\";  \n");
      out.write("    setTimeout(carousel, 4000);    \n");
      out.write("}\n");
      out.write("\n");
      out.write("// Used to toggle the menu on small screens when clicking on the menu button\n");
      out.write("function myFunction() {\n");
      out.write("    var x = document.getElementById(\"navDemo\");\n");
      out.write("    if (x.className.indexOf(\"w3-show\") == -1) {\n");
      out.write("        x.className += \" w3-show\";\n");
      out.write("    } else { \n");
      out.write("        x.className = x.className.replace(\" w3-show\", \"\");\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("\n");
      out.write("// When the user clicks anywhere outside of the modal, close it\n");
      out.write("var modal = document.getElementById('ticketModal');\n");
      out.write("window.onclick = function(event) {\n");
      out.write("  if (event.target == modal) {\n");
      out.write("    modal.style.display = \"none\";\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user eq null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_redirect_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_redirect_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:redirect
    org.apache.taglibs.standard.tag.rt.core.RedirectTag _jspx_th_c_redirect_0 = (org.apache.taglibs.standard.tag.rt.core.RedirectTag) _jspx_tagPool_c_redirect_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.RedirectTag.class);
    _jspx_th_c_redirect_0.setPageContext(_jspx_page_context);
    _jspx_th_c_redirect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_redirect_0.setUrl("accessdenied.html");
    int _jspx_eval_c_redirect_0 = _jspx_th_c_redirect_0.doStartTag();
    if (_jspx_th_c_redirect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
      return true;
    }
    _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
    return false;
  }
}
