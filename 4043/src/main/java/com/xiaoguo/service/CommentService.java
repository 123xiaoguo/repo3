package com.xiaoguo.service;

import com.xiaoguo.model.Comment;
import com.xiaoguo.model.Mess;
import com.xiaoguo.model.PageInfo;
import com.xiaoguo.model.PageParams;

import java.util.List;
import java.util.Map;

public interface CommentService {

    public Map<Comment,List<Mess>> queryCommentById(int commentId);
    public PageInfo<Comment> queryCommentForPagin(PageParams pageParam);
}
