/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import dal.UserInfoDAO;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserInfo;

/**
 *
 * @author emsnguyen
 */
public class LogInController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDB = new UserDAO();
        User u = userDB.getUser(username, password);
        
        if (u == null) {
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            doGet(request, response);
        } else {
            //set avatar path 
//            String realPath = "C:\\Users\\emsnguyen\\Documents\\NetBeansProjects\\TeenderWebApp\\web\\";
//            System.out.println("real context path in login controller: " + getServletContext().getRealPath("/"));
            String realPath = getServletContext().getRealPath("/");
            String jpg = realPath + u.getUsername()+ ".jpg";
            File fileJpg = new File(jpg);
            String png = realPath + u.getUsername() + ".png";
            File filePng = new File(png);
            String jpeg = realPath + u.getUsername() + ".jpeg";
            File fileJpeg = new File(jpeg);
            if (fileJpg.exists()) {
                request.getSession().setAttribute("avatarPath", u.getUsername() + ".jpg");
            } else if (filePng.exists()) {
                request.getSession().setAttribute("avatarPath", u.getUsername() + ".png");
            } else if (fileJpeg.exists()) {
                request.getSession().setAttribute("avatarPath", u.getUsername() + ".jpeg");
            } else {
                request.getSession().setAttribute("avatarPath", "img/logo.jpg");
            }
            //set user attribute
            request.getSession().setAttribute("user", u);
            request.getSession().setAttribute("userID", u.getUserID());
            
            UserInfoDAO infoDB = new UserInfoDAO();
            UserInfo info = infoDB.get(u.getUserID());
            if (info != null) {
                request.getSession().setAttribute("info", info);
                response.sendRedirect("home2.jsp");
            } else {
                response.sendRedirect("setting");
            }
        }
    }
}
