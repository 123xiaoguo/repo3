package com.xiaoguo.dao;

import com.xiaoguo.model.Comment;
import com.xiaoguo.model.Mess;
import com.xiaoguo.model.PageParams;

import java.util.List;

public interface MessDao {
    /**
     * 添加评论
     * @param mess
     * @return
     */
    public int addMess(Mess mess);
    /***
     * 	根据板块id获得该板块的所有评论
     * @param commentId
     * @return
     */
    public List<Mess> queryMessBycommentId(int commentId);

}
