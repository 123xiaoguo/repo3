package com.xiaoguo.dao.impl;

import java.sql.SQLException;

import com.xiaoguo.dao.UserDao;
import com.xiaoguo.model.User;
import com.xiaoguo.util.DBUtils;

public class UserDaoImpl extends DBUtils implements UserDao{

	public int addUser(User user) {
		String sql = "insert into userinfo values(default,?,?,?,?)";

		Object[] params = {
				user.getUserName(),
				user.getPassword(),
				user.getSex(),
				user.getEmail()
		};
		return super.executeUpdate(sql, params);
	}


	public User login(String username, String password) {
		String sql = "select * from userinfo where userName=? and password=?";
		try {
			super.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
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
		}finally {
			super.closeAll();
		}
		return null;
	}



}
