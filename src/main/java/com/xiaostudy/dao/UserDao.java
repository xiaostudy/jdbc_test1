package com.xiaostudy.dao;

import com.xiaostudy.Base.User;
import com.xiaostudy.util.JdbcUtil;
import com.xiaostudy.util.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiaostudy
 * Date: 2019/5/4
 * Time: 16:47
 * Description: No Description
 */
public class UserDao {

    public int insert(User user) {
        if(null == user) {
            return 0;
        }

        Connection conn = JdbcUtil.getConnection();
        if(null == conn) {
            return 0;
        }

        int i = 0;
        String sql = "insert into t_user (user_name,password) values(?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt, conn, null);
        }
        return i;
    }

    public int update(User user) {
        if(null == user || null == user.getId() || user.getId() <= 0) {
            return 0;
        }

        Connection conn = JdbcUtil.getConnection();
        if(null == conn) {
            return 0;
        }

        int i = 0;
        String sql = "update t_user set user_name='" + user.getUserName() + "', password='" + user.getPassword() + "' where id='" + user.getId() + "' ";
        PreparedStatement pstmt = null;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt, conn, null);
        }
        return i;
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<User>();
        Connection conn = JdbcUtil.getConnection();
        if(null == conn) {
            return list;
        }

        String sql = "select id, user_name, password from t_user";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt, conn, rs);
        }
        return list;
    }

    public User getUserByUserName(String userName) {
        if(null == userName || userName.trim().length() <= 0) {
            return null;
        }

        Connection conn = JdbcUtil.getConnection();
        if(null == conn) {
            return null;
        }

        User user = new User();
        String sql = "select id, user_name, password from t_user where user_name='" + userName + "'";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt, conn, rs);
        }
        return user;
    }

    public int delete(String userName) {
        if(null == userName || userName.trim().length() <= 0) {
            return 0;
        }

        Connection conn = JdbcUtil.getConnection();
        if(null == conn) {
            return 0;
        }

        int i = 0;
        String sql = "delete from t_user where user_name='" + userName + "'";
        PreparedStatement pstmt = null;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt, conn, null);
        }
        return i;
    }
}
