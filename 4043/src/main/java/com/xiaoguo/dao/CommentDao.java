package com.xiaoguo.dao;

import java.util.List;

import com.xiaoguo.model.Comment;
import com.xiaoguo.model.PageParams;


public interface CommentDao {
	/**
	 * 查看所有模块
	 * @return
	 */
	public List<Comment> queryComment();
	/**
	 * 根据id查看模块
	 * @param commentId
	 * @return
	 */
	public Comment queryCommentById(int commentId);
	/**
	 * 分页查询
	 * @param pageParam
	 * @return
	 */
	public List<Comment> queryCommentForPagin(PageParams pageParam);
	/**
	 * 查询分页的总数据量
	 * @return
	 */
	public Integer queryCountRow();
}
