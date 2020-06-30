package com.xiaoguo.service.Impl;

import com.xiaoguo.dao.CommentDao;
import com.xiaoguo.dao.MessDao;
import com.xiaoguo.dao.impl.CommentDaoImpl;
import com.xiaoguo.dao.impl.MessDaoImpl;
import com.xiaoguo.model.Comment;
import com.xiaoguo.model.Mess;
import com.xiaoguo.model.PageInfo;
import com.xiaoguo.model.PageParams;
import com.xiaoguo.service.CommentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentServiceImpl implements CommentService {
    //创建CommentDao对象
    private CommentDao commentDao = new CommentDaoImpl();
    private MessDao messDao = new MessDaoImpl();

    @Override
    public Map<Comment, List<Mess>> queryCommentById(int commentId) {
        //根据图书编号获得图书对象
        Comment comment = commentDao.queryCommentById(commentId);
        //根据图书编号获得图书的评论列表
        List<Mess> messList = messDao.queryMessBycommentId(commentId);
        //将图书对象和评论列表添加到Map集合中
        Map<Comment,List<Mess>> commentListMap = new HashMap<Comment,List<Mess>>();
       commentListMap.put(comment,messList);
       return commentListMap;
    }

    @Override
    public PageInfo<Comment> queryCommentForPagin(PageParams pageParam) {
        //创建PageInfo对象
        PageInfo<Comment> pageInfo = new PageInfo<>();
        //设置pageInfo的当前页(当前页是要查询的页)
        pageInfo.setCurPageNum(pageParam.getPageNum());
        //设置总记录数
        pageInfo.setCountRow(commentDao.queryCountRow());
        //设置查询到的数据(分页的图书信息)
        pageInfo.setData(commentDao.queryCommentForPagin(pageParam));
        return pageInfo;
    }

}
