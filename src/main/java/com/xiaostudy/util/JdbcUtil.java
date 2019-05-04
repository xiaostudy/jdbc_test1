package com.xiaostudy.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


/**
 * Created with IntelliJ IDEA.
 * User: xiaostudy
 * Date: 2019/5/4
 * Time: 11:58
 * Description: No Description
 */
public class JdbcUtil {

    private static Connection connection;

    public static Connection getConnection() {
        if(null != connection) {
            return connection;
        }

        Properties pt = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src\\main\\resources\\db.properties");
            pt.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = pt.getProperty("driver");
        String url = pt.getProperty("url");
        String userName = pt.getProperty("userName");
        String password = pt.getProperty("password");

        if(null == driver || null == url || null == userName || null == password) {
            return null;
        }

        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(PreparedStatement pstmt, Connection conn,ResultSet rs) {
        try {
            if(null != rs) {
                rs.close();
                rs = null;
            }
            if(null != pstmt) {
                pstmt.close();
                pstmt = null;
            }
            if(null != conn) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
