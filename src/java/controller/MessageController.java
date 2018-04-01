/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.MessageDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Message;
import model.User;

/**
 *
 * @author Admin
 */
public class MessageController extends BaseAuthenticationController {

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        int user1ID = u.getUserID();
        int user2ID = (Integer) request.getSession().getAttribute("user2ID");
        String content = request.getParameter("content");

        Message m = new Message();
        m.setSenderID(user1ID);
        m.setReceiverID(user2ID);
        m.setContent(content);

        //insert new message to database
        MessageDAO msgDB = new MessageDAO();
        if (!msgDB.insert(m)) {
            response.getWriter().write("error while inserting new message");
            return;
        }
        
        //similar methods as handleGet
        ArrayList<Message> messages = msgDB.getAll(user1ID, user2ID);
        System.out.println("messages: " + messages);
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("chat").forward(request, response);
    }

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve user infos
        User u = (User) request.getSession().getAttribute("user");
        System.out.println(u.getUsername());
        int user1ID = u.getUserID();
        int user2ID = Integer.parseInt(request.getParameter("user2ID"));
        request.getSession().setAttribute("user2ID", user2ID);
        MessageDAO msgDB = new MessageDAO();
        
        ArrayList<Message> messages = msgDB.getAll(user1ID, user2ID);
        System.out.println("messages: " + messages);
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("chat.jsp").forward(request, response);
    }

}
