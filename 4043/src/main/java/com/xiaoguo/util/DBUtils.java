package com.xiaoguo.util;

import java.sql.*;

public abstract class DBUtils {
    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;
    /***
     * 基于数据库的连接方法
     * @return
     * @throws SQLException
     */
    protected Connection getConn() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_sql", "root", "root");

    }

    /***
     * 释放资源方法
     */
    protected void closeAll() {
        try {
            if(rs != null) {
                rs.close();
            }
            if(ps != null) {
                ps.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            conn = null;
            ps = null;
            rs = null;
        }
    }
    /***
     * 执行增、删、改语句
     * @param sql     带有？号占位符的SQL语句
     * @param params   该参数是一个数组，数组中的每个元素表示SQL语句中？号占位符的值
     * 					约束条件:数组中第一个元素(0)必须对应SQL语句中第一个？号
     * @return
     */
    protected int executeUpdate(String sql,Object[] params) {
        try {
            //连接数据库
            getConn();
            //创建预处理对象
            ps = conn.prepareStatement(sql);
            //设置？号占位符的值
            //判断params数组是否存在或其中有数据
            if(params!=null && params.length!=0) {
                //循环设置？号占位符的值
                for(int i=0;i<params.length;i++) {
                    ps.setObject(i+1, params[i]);
                }
            }
            //执行SQL语句并返回结果
            return ps.executeUpdate();
        }catch (ClassNotFoundException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            this.closeAll();//释放资源
        }
        return 0;
    }

}
