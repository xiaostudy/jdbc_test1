package com.xiaostudy.util;

import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MyDataSource implements DataSource {
    private static LinkedList<Connection> pool=new LinkedList<Connection>();
    static{
        for (int i = 0; i < 5; i++) {
            Connection conn=JdbcUtil.getConnection();
            pool.add(conn);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection conn=null;
        if (0 == pool.size()) {
            for (int i = 0; i < 5; i++) {
                conn=JdbcUtil.getConnection();
                pool.add(conn);
            }
        }
        conn=pool.remove(0);
        return conn;
    }

    public static void close(Connection conn){
        pool.add(conn);
    }

    public static void close(PreparedStatement pstmt, Connection conn, ResultSet rs) {
        if(null != conn) {
            pool.add(conn);
        }
        JdbcUtil.close(pstmt, null, rs);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter arg0) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLoginTimeout(int arg0) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public Connection getConnection(String arg0, String arg1)
            throws SQLException {

        return null;
    }

}