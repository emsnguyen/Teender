package controller;

import dal.UserInfoDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserInfo;

/**
 *
 * @author emsnguyen
 */
public class SettingController extends BaseAuthenticationController {

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String nickname = request.getParameter("nickname");
        String birthDate = request.getParameter("birthDate");
        String aboutMe = request.getParameter("aboutme");
        String address = request.getParameter("address");
        String work = request.getParameter("work");
        String online = request.getParameter("online");
        boolean isOnline = false;
        if (online.equals("yes")) {
            isOnline = true;
        }
        String preferMale = request.getParameter("preferMale");
        boolean isPreferMale = false;
        if (preferMale.equals("male")) {
            isPreferMale = true;
        }
        User u = (User) request.getSession().getAttribute("user");
        UserInfo info = new UserInfo(u, nickname, aboutMe, Date.valueOf(birthDate), work, address, isOnline, isPreferMale);
        UserInfoDAO infoDB = new UserInfoDAO();
        request.getSession().setAttribute("info", info);
        if (infoDB.get(u.getUserID()) == null) { //this is a new user
            if (infoDB.insert(info)) {
                String path = request.getSession().getAttribute("avatarPath").toString();
                if (path == null || path.equals("img/logo.jpg")) { //avatar not chosen
                    response.sendRedirect("changeavatar");
                } else {
                    response.sendRedirect("home2.jsp");
                }
            } else {
                response.getWriter().write("error inserting new user info");
            }
        } else { // a logged-in user
            if (infoDB.update(info)) {
                response.sendRedirect("home2.jsp");
            } else {
                response.getWriter().write("error updating user info");
            }
        }

    }

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("settings.jsp").forward(request, response);
    }

}
