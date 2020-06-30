package com.xiaoguo.dao.impl;

import com.xiaoguo.dao.MessDao;
import com.xiaoguo.model.Mess;
import com.xiaoguo.util.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessDaoImpl extends DBUtils implements MessDao{

    public int addMess(Mess mess) {
        String sql = "insert into messinfo values(default,?,?,?,now())";

        Object[] params = {
                mess.getUserID(),
                mess.getCommentID(),
                mess.getMess_text()
        };
        return super.executeUpdate(sql, params);
    }

    public List<Mess> queryMessBycommentId(int commentId) {
        String sql = "select * from messinfo where commentId=? order by mess_time DESC";
        try {
            super.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, commentId);
            rs = ps.executeQuery();
            List<Mess> messageList = new ArrayList<>();
            while(rs.next()) {
                Mess mess = new Mess();
                mess.setMessID(rs.getInt(1));
                mess.setUserID(rs.getInt(2));
                mess.setCommentID(rs.getInt(3));
                mess.setMess_text(rs.getString(4));
                mess.setMess_time(rs.getTimestamp(5));
                messageList.add(mess);
            }
            return messageList;
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
