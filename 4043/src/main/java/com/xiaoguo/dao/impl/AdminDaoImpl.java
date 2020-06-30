package com.xiaoguo.dao.impl;

import com.xiaoguo.dao.AdminDao;
import com.xiaoguo.model.Admin;
import com.xiaoguo.model.Mess;
import com.xiaoguo.model.User;
import com.xiaoguo.util.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl extends DBUtils implements AdminDao {
    @Override
    public Admin login(String username, String password) {
        try {
            String sql = "select * from admininfo where adminUsername=? and adminPassword=?";
            super.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setAdminID(rs.getInt(1));
                admin.setAdminUsername(rs.getString(2));
                admin.setAdminPassword(rs.getString(3));
                return admin;
            }
            return null;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            super.closeAll();
        }
        return null;
    }

    @Override
    public List<Mess> queryMess() {
        try {
            //获得链接对象
            super.getConn();
            String sql = "select * from messinfo";
            //使用链接对象和SQL语句创建预处理对象
            ps = conn.prepareStatement(sql);
            //执行SQL语句
            rs = ps.executeQuery();
            List<Mess> messList = new ArrayList<>();
            while (rs.next()) {
                Mess mess = new Mess();
                mess.setMessID(rs.getInt(1));
                mess.setUserID(rs.getInt(2));
                mess.setCommentID(rs.getInt(3));
                mess.setMess_text(rs.getString(4));
                mess.setMess_time(rs.getTimestamp(5));
                messList.add(mess);
            }
            return messList;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            super.closeAll();
        }

        return null;
    }

    @Override
    public void deleteMess(int messId) {
        String sql = "DELETE  from messinfo WHERE messID=?";
        Object[] params = {messId};
        super.executeUpdate(sql,params);
    }
    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE  from userinfo WHERE userID=?";
        Object[] params = {userId};
        super.executeUpdate(sql,params);
    }

    @Override
    public List<User> queryUser() {
        try {
            //获得链接对象
            super.getConn();
            String sql = "select * from userinfo";
            //使用链接对象和SQL语句创建预处理对象
            ps = conn.prepareStatement(sql);
            //执行SQL语句
            rs = ps.executeQuery();
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setSex(rs.getString(4));
                user.setEmail(rs.getString(5));
                userList.add(user);
            }
            return userList;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            super.closeAll();
        }

        return null;
    }

    @Override
    public void update(User user) {

        String sql = "update userinfo set userName=?,password=?,sex=?,email=? where userID=? ";
        Object[] params={
                user.getUserName(),
                user.getPassword(),
                user.getSex(),
                user.getEmail(),
                user.getUserID()
        };
        super.executeUpdate(sql,params);
    }

    @Override
    public User findById(int userId){
        try{
      String sql ="select * from userinfo where userID=?";
        super.getConn();
        ps = conn.prepareStatement(sql);
        ps.setInt(1,userId);
        rs = ps.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setUserID(rs.getInt(1));
            user.setUserName(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setSex(rs.getString(4));
            user.setEmail(rs.getString(5));
            return user;
        }
        return null;
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
        super.closeAll();
    }
        return null;
}
}
