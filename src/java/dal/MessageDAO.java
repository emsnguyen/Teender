/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Message;
import model.User;

/**
 *
 * @author emsnguyen
 */
public class MessageDAO extends BaseDAO<Message>{
    public ArrayList<Message> getAll(int senderID, int receiverID) {
        ArrayList<Message> messages = new ArrayList<>();
        try {
            String sql = "SELECT [senderID]\n" +
                        "      ,[receiverID]\n" +
                        "      ,[content]\n" +
                        "  FROM [Message] \n" +
                        "  where (senderID = ? and receiverID = ?) "
                    + "OR (senderID = ? and receiverID = ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, senderID);
            ps.setInt(2, receiverID);
            ps.setInt(3, receiverID);
            ps.setInt(4, senderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Message m = new Message();
                m.setSenderID(rs.getInt("senderID"));
                m.setReceiverID(rs.getInt("receiverID"));
                m.setContent(rs.getString("content"));
                messages.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messages;
    }
    @Override
    public ArrayList<Message> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message get(int id) {
        Message m = new Message();
        try {
            String sql = "SELECT [senderID]\n" +
                            "      ,[receiverID]\n" +
                            "      ,[content]\n" +
                            "  FROM [Message]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    @Override
    public boolean delete(Message model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Message model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Message model) {
        try {
            //insert to User
            String query = "INSERT INTO [Message]\n" +
                            "           ([senderID]\n" +
                            "           ,[receiverID]\n" +
                            "           ,[content])\n" +
                            "     VALUES\n" +
                            "           (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, model.getSenderID());
            ps.setInt(2, model.getReceiverID());
            ps.setString(3, model.getContent());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }

    public ArrayList<User> getConnectedUsers(int user1ID) {
        ArrayList<User> users = new ArrayList<>();
        try {
            String query = "SELECT [userID]\n" +
                    "      ,[username]\n" +
                    "      ,[password]\n" +
                    "  FROM [User] u, Message m\n" +
                    "  where userID = m.senderID\n" +
                    "  and senderID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, user1ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
}
