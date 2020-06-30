package com.xiaoguo.dao.impl;

import com.xiaoguo.dao.CommentDao;
import com.xiaoguo.model.Comment;
import com.xiaoguo.model.PageParams;
import com.xiaoguo.util.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CommentDaoImpl extends DBUtils implements CommentDao{

	public List<Comment> queryComment() {
			try {
			//������Ӷ���
			super.getConn();
			String sql = "select * from commentinfo";
			//ʹ�����Ӷ����SQL��䴴��Ԥ�������
			ps = conn.prepareStatement(sql);
			//ִ��SQL���
			rs = ps.executeQuery();
			List<Comment> comments = new ArrayList<>();
			while(rs.next()) {
					Comment comment = new Comment();
					comment.setCommentID(rs.getInt(1));
					comment.setTitle(rs.getString(2));
					comment.setContent(rs.getString(3));
					comment.setTime(rs.getString(4));
					comment.setPostName(rs.getString(5));
					comment.setImage(rs.getString(6));
					comments.add(comment);
				}
			return comments;
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

	public Comment queryCommentById(int commentId) {

		try {
			super.getConn();
			String sql = "select * from commentinfo where commentID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, commentId);
			rs = ps.executeQuery();
			if(rs.next()) {
				Comment comment = new Comment();
				comment.setCommentID(rs.getInt(1));
				comment.setTitle(rs.getString(2));
				comment.setContent(rs.getString(3));
				comment.setTime(rs.getString(4));
				comment.setPostName(rs.getString(5));
				comment.setImage(rs.getString(6));
				return comment;
			}
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


	public List<Comment> queryCommentForPagin(PageParams pageParam) {
		try {
			super.getConn();
			String sql = "select * from commentinfo limit ?,?";
			ps = conn.prepareStatement(sql);
			//��÷�ҳ��ѯ����ʼ�к�
			int startRowNum = (pageParam.getPageNum()-1)*pageParam.getPageRowNum();
			ps.setInt(1, startRowNum);
			ps.setInt(2,pageParam.getPageRowNum());
			rs = ps.executeQuery();
			List<Comment> comments = new ArrayList<>();
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setCommentID(rs.getInt(1));
				comment.setTitle(rs.getString(2));
				comment.setContent(rs.getString(3));
				comment.setTime(rs.getString(4));
				comment.setPostName(rs.getString(5));
				comment.setImage(rs.getString(6));
				comments.add(comment);
			}
			return comments;
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

	public Integer queryCountRow() {
		try {
			super.getConn();
			String sql = "select count(commentID) as 'commentID' from commentinfo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Comment comment = new Comment();
			if(rs.next()) {
				comment.setCommentID(rs.getInt(1));
				return comment.getCommentID();
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
