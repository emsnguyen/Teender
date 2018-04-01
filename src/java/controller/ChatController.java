/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserInfoDAO;
import java.io.IOException;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserInfo;

/**
 *
 * @author emsnguyen
 */
public class ChatController extends BaseAuthenticationController {

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("chat.jsp").forward(request, response);
        //add to message table
    }
    protected void prepare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        int user1ID = u.getUserID();

        //get all friends of a user
        UserInfoDAO infoDB = new UserInfoDAO();
        Hashtable<Integer, String> friends = infoDB.getAllFriends(user1ID);
        request.getSession().setAttribute("friends", friends);
        UserInfo info = infoDB.get(u.getUserID());
        request.getRequestDispatcher("chat.jsp").forward(request, response);
    }

}
