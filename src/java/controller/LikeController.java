/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emsnguyen
 */
public class LikeController extends BaseAuthenticationController {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int likedID = Integer.parseInt(request.getParameter("likedID"));
            int doID = Integer.parseInt(request.getParameter("doID"));
            String query = "INSERT INTO [dbo].[Like]\n"
                    + "           ([likerID]\n"
                    + "           ,[likedID])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            UserDAO ud = new UserDAO();
            PreparedStatement statement = ud.connection.prepareStatement(query);
            statement.setInt(1, doID);
            statement.setInt(2, likedID);
            statement.execute();
            response.sendRedirect("choose");
        } catch (SQLException ex) {
            Logger.getLogger(IgnoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //add to like table
        
        //check if the liked person also like the liker
        
        //if they do, redirect to chat, include the id of both liker and liked
        
        //if they don't, back to choose
        processRequest(request, response);
    }

}
