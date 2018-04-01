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
import model.User;

/**
 *
 * @author emsnguyen
 */
public class UserDAO extends BaseDAO<User> {

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT [userID]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "  FROM [User]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public ArrayList<Integer> getChooseList(int userID) {
        ArrayList<Integer> list = new ArrayList();
        try {
            String query = "SELECT u.userID FROM [User] u\n"
                    + "  WHERE (u.userID <> ?) AND (u.userID NOT IN (\n"
                    + "  SELECT likedID \n"
                    + "  FROM [Like] l \n"
                    + "  WHERE (l.likerID = ?)))\n"
                    + "  AND (u.userID NOT IN (\n"
                    + "  SELECT ignoredID \n"
                    + "  FROM  Ignore i\n"
                    + "  WHERE (i.ignorerID = ?))) order by checksum(newID());";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userID);
            statement.setInt(2, userID);
            statement.setInt(3, userID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int i = rs.getInt("userID");
                list.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public User getNextPersonToChoose(int userID) {
        try {
            String query = "SELECT u.userID FROM [User] u"
                    + "  WHERE (u.userID <> ?) AND (u.userID NOT IN ("
                    + "  SELECT likedID "
                    + "  FROM [Like] l"
                    + "  WHERE (l.likerID = ?)))"
                    + "  AND (u.userID NOT IN ("
                    + "  SELECT ignoredID "
                    + "  FROM  Ignore i "
                    + "  WHERE (i.ignorerID = ?)))";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userID);
            statement.setInt(2, userID);
            statement.setInt(3, userID);
            ResultSet rs = statement.executeQuery();
            System.out.println("query: " + query);
            if (rs.next()) {
                int i = rs.getInt("userID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                User u = new User(userID, username, password);
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isUsernameExisted(String username) {
        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "  FROM [User] where username = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public User getUser(String username, String password) {
        try {
            String sql = "SELECT [userID]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "  FROM [User] where username = ? and password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean delete(User model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(User model) {
        try {
            //insert to User
            String query = "INSERT INTO [User]\n"
                    + "           ([username]\n"
                    + "           ,[password])\n"
                    + "     VALUES\n"
                    + "           (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, model.getUsername());
            ps.setString(2, model.getPassword());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }

    @Override
    public User get(int index) {
        try {
            String sql = "SELECT [userID]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "  FROM [User] where userID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, index);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                User u = new User(index, username, password);
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updatePassword(User u) {
        try {
            String query = "UPDATE [User]\n"
                    + "   SET [password] = ?\n"
                    + " WHERE userID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, u.getPassword());
            ps.setInt(2, u.getUserID());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int getID(String username) {
        try {
            String sql = "SELECT [userID]\n"
                    + "  FROM [User] WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("userID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
