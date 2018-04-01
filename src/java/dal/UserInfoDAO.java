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
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import model.UserInfo;

/**
 *
 * @author emsnguyen
 */
public class UserInfoDAO extends BaseDAO<UserInfo> {
    public Hashtable<Integer, String> getAllFriends(int userID) {
        Hashtable<Integer, String> idNickName = new Hashtable<>();
        try {
            String sql = "select distinct u.nickname, l1.likerID from [Like] l1 INNER JOIN [Like] l2\n" +
                        "ON l1.likedID = l2.likerID AND l1.likerID = l2.likedID \n" +
                        "INNER JOIN UserInfo u ON u.userID = l1.likerID\n" +
                        "WHERE l1.likerID <> ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("likerID");
                String nickname = rs.getString("nickname");
                idNickName.put(id, nickname);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idNickName;
    }
    @Override
    public ArrayList<UserInfo> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserInfo get(int index) {
        try {
            String query = "SELECT [userID]\n"
                    + "      ,[nickname]\n"
                    + "      ,[aboutMe]\n"
                    + "      ,[birthDate]\n"
                    + "      ,[work]\n"
                    + "      ,[address]\n"
                    + "      ,[preferMale]\n"
                    + "      ,[online]\n"
                    + "  FROM [UserInfo] where userID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, index);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nickname = rs.getString("nickname");
                String aboutme = rs.getString("aboutMe");
                Date birthDate = rs.getDate("birthDate");
                String work = rs.getString("work");
                String address = rs.getString("address");
                boolean preferMale = rs.getBoolean("preferMale");
                boolean online = rs.getBoolean("online");
                User u = new UserDAO().get(index);
                UserInfo info = new UserInfo(u, nickname, aboutme, birthDate, work, address, online, preferMale);
                return info;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean delete(UserInfo model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UserInfo model) {
        try {
            String query = "UPDATE [UserInfo]\n"
                    + "   SET [nickname] = ?\n"
                    + "      ,[aboutMe] = ?\n"
                    + "      ,[birthDate] = ?\n"
                    + "      ,[work] = ?\n"
                    + "      ,[address] = ?\n"
                    + "      ,[preferMale] = ?\n"
                    + "      ,[online] = ?\n"
                    + " WHERE [userID] = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, model.getNickname());
            ps.setString(2, model.getAboutMe());
            ps.setDate(3, new java.sql.Date(model.getBirthDate().getTime()));
            ps.setString(4, model.getWork());
            ps.setString(5, model.getAddress());
            ps.setBoolean(6, model.isPreferMale());
            ps.setBoolean(7, model.isOnline());
            ps.setInt(8, model.getUser().getUserID());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean insert(UserInfo model) {
        try {
            //insert to User
            String query = "INSERT INTO [UserInfo]\n"
                    + "           ([userID]\n"
                    + "           ,[nickname]\n"
                    + "           ,[aboutMe]\n"
                    + "           ,[birthDate]\n"
                    + "           ,[work]\n"
                    + "           ,[address]\n"
                    + "           ,[preferMale]\n"
                    + "           ,[online])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, model.getUser().getUserID());
            ps.setString(2, model.getNickname());
            ps.setString(3, model.getAboutMe());
            ps.setDate(4, new java.sql.Date(model.getBirthDate().getTime()));
            ps.setString(5, model.getWork());
            ps.setString(6, model.getAddress());
            ps.setBoolean(7, model.isPreferMale());
            ps.setBoolean(8, model.isOnline());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
