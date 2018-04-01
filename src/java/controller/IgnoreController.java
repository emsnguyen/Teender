package controller;

import dal.UserDAO;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emsnguyen
 */
public class IgnoreController extends BaseAuthenticationController {
    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int ignoredID = Integer.parseInt(request.getParameter("ignoredID"));
            int doID = Integer.parseInt(request.getParameter("doID"));
            String query = "INSERT INTO [dbo].[Ignore]\n"
                    + "           ([ignorerID]\n"
                    + "           ,[ignoredID])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            UserDAO ud = new UserDAO();
            PreparedStatement statement = ud.connection.prepareStatement(query);
            statement.setInt(1, doID);
            statement.setInt(2, ignoredID);
            statement.execute();
            
            response.sendRedirect("choose");
        } catch (SQLException ex) {
            Logger.getLogger(IgnoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
