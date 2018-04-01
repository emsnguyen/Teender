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
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import model.UserInfo;

/**
 *
 * @author emsnguyen
 */
public class ChooseController extends BaseAuthenticationController {
    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //son
        UserDAO userDB = new UserDAO();
        HttpSession session = request.getSession();
        
        int userID = (Integer) session.getAttribute("userID");
        ArrayList<Integer> index = userDB.getChooseList(userID);
        if (index.isEmpty()) {
            response.sendRedirect("fullSlot.jsp");
            return;
        }
        int nextID = index.get(0);
        User u = userDB.get(nextID);
        request.setAttribute("u", u);
        String realPath = getServletContext().getRealPath("/");
        String jpg = realPath + u.getUsername()+ ".jpg";
        File fileJpg = new File(jpg);
        String png = realPath + u.getUsername() + ".png";
        File filePng = new File(png);
        String jpeg = realPath + u.getUsername() + ".jpeg";
        File fileJpeg = new File(jpeg);
        if (fileJpg.exists()) {
            request.setAttribute("avatarPath", u.getUsername() + ".jpg");
        } else if (filePng.exists()) {
            request.setAttribute("avatarPath", u.getUsername() + ".png");
        } else if (fileJpeg.exists()) {
            request.setAttribute("avatarPath", u.getUsername() + ".jpeg");
        } else {
            request.setAttribute("avatarPath", "img/logo.jpg");
        }
        UserInfo info = new UserInfoDAO().get(nextID);
        if (info != null) {
            int age = new Date().getYear() - info.getBirthDate().getYear();
            request.setAttribute("age", age);
        } else {
            request.setAttribute("age", "Tuổi chưa rõ");
        }
        request.getRequestDispatcher("choose.jsp").forward(request, response);
    }
}